package br.com.albus.generic;

import br.com.albus.generic.exception.GenericEntityTestException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class GenericEntityTest<E extends GenericEntity<I>, I extends Serializable> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericEntityTest.class);

    protected Class<E> entityClass;
    protected Class<I> idClass;

    protected Function<Object, I> functionGeradorDeIds = (object) -> (I) Mockito.any(this.idClass);


    protected ArrayList<String> idList = new ArrayList();

    public GenericEntityTest() {
    }

    @Test
    public void equalTest() throws GenericEntityTestException {
        E ob0;
        E ob1;
        E ob2;
        E ob3;

        try {
            ob0 = this.entityClass.newInstance();
            ob1 = this.entityClass.newInstance();
            ob2 = this.entityClass.newInstance();
            ob3 = this.entityClass.newInstance();
        } catch (Exception e) {
            throw new GenericEntityTestException();
        }
        Object ob5 = new Object();

        I id = functionGeradorDeIds.apply(new Object());
        ob0.setId(null);
        ob1.setId(null);
        ob2.setId(id);
        ob3.setId(id);

        Assert.assertTrue(ob0.equals(ob1));

        Assert.assertFalse(ob1.equals(null));
        Assert.assertTrue(ob1.equals(ob1));
        Assert.assertFalse(ob1.equals(ob2));
        Assert.assertFalse(ob1.equals(ob3));
        Assert.assertFalse(ob1.equals(ob5));

        Assert.assertFalse(ob2.equals(null));
        Assert.assertFalse(ob2.equals(ob1));
        Assert.assertTrue(ob2.equals(ob2));
        Assert.assertTrue(ob2.equals(ob3));
        Assert.assertFalse(ob2.equals(ob5));

        Assert.assertTrue(ob3.equals(ob2));
        Assert.assertTrue(ob3.equals(ob3));
    }

    @Test
    public void hashCodeTest() throws GenericEntityTestException {
        try {
            E ob1 = this.entityClass.newInstance();
            E ob2 = this.entityClass.newInstance();

            ob1.setId(null);
            ob2.setId(functionGeradorDeIds.apply(new Object()));

            Assert.assertEquals(0, ob1.hashCode());
            Assert.assertNotNull(ob2.hashCode());
        } catch (Exception e) {
            throw new GenericEntityTestException();
        }
    }

    @Test
    public void testGettersSetters() throws GenericEntityTestException {
        try {
            E entity = this.entityClass.newInstance();
            this.testMethodsGettersAndSetters(entity, entity.getClass().getDeclaredFields());
            if (Modifier.isAbstract(entity.getClass().getSuperclass().getModifiers())) {
                this.testMethodsGettersAndSetters(entity, entity.getClass().getSuperclass().getDeclaredFields());
            }

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException var2) {
            throw new GenericEntityTestException();
        }
    }

    private void testMethodsGettersAndSetters(E entity, Field[] fields) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Field[] var3 = fields;
        int var4 = fields.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            Field f = var3[var5];
            if (isFieldTestable(f)) {
                if (!f.getType().isEnum() && f.getType().getName().startsWith("br.com.albus")) {
                    this.callGetProperty(entity, f);
                } else {
                    Object valor = generateValue(f);

                    BeanUtils.setProperty(entity, f.getName(), valor);
                    if (Calendar.class.equals(f.getType())) {
                        Assert.assertEquals(PropertyUtils.getProperty(entity, f.getName()), valor);
                    } else {
                        Assert.assertSame(PropertyUtils.getProperty(entity, f.getName()), valor);
                    }
                }
            }
        }

    }

    private static Object generateValue(Field f) throws IllegalAccessException, InstantiationException {
        if (f.getType().equals(Boolean.class)) {
            return Boolean.TRUE;
        } else if (f.getType().equals(Integer.class)) {
            return 2147483647;
        } else if (f.getType().equals(Short.class)) {
            return 32767;
        } else if (f.getType().equals(Long.class)) {
            return 9223372036854775807L;
        } else if (f.getType().equals(BigDecimal.class)) {
            return BigDecimal.ZERO;
        } else if (f.getType().equals(Float.class)) {
            return 3.4028235E38F;
        } else if (f.getType().equals(Double.class)) {
            return 1.7976931348623157E308D;
        } else if (f.getType().equals(String.class)) {
            return "Texto de teste";
        } else if (f.getType().equals(Date.class)) {
            return new Date();
        } else if (f.getType().equals(LocalDate.class)) {
            return LocalDate.now();
        } else if (f.getType().equals(LocalDateTime.class)) {
            return LocalDateTime.now();
        } else if (f.getType().equals(Calendar.class)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            return calendar;
        } else if (f.getType().isEnum()) {
            return f.getType().getEnumConstants()[0];
        } else if (f.getType().isAssignableFrom(List.class)) {
            return new ArrayList();
        } else {
//            return f.getType().isAssignableFrom(Map.class) ? new HashMap() : new Object();
            return f.getType().isAssignableFrom(Map.class) ? new HashMap() : f.getType().newInstance();
        }
    }

    private void callGetProperty(E entity, Field f) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (!Modifier.isAbstract(f.getType().getModifiers())) {
            BeanUtils.setProperty(entity, f.getName(), f.getType().newInstance());
            PropertyUtils.getProperty(entity, f.getName());
        } else {
            Annotation[] annotations = f.getType().getAnnotations();
            Arrays.asList(annotations).forEach((annotation) -> {
                this.createPublishAttribute(entity, f, annotation);
            });
        }

    }

    private void createPublishAttribute(E entity, Field f, Annotation annotation) {
        if (annotation.annotationType().getName().equals("br.com.azi.hal.annotation.StagingEntity")) {
            try {
                Method getPublish = annotation.annotationType().getDeclaredMethod("publishEntity");
                Object obj = getPublish.invoke(annotation);
                BeanUtils.setProperty(entity, f.getName(), ((Class) obj).newInstance());
                PropertyUtils.getProperty(entity, f.getName());
            } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException var6) {
                LOGGER.error(var6.getLocalizedMessage());
            }
        }

    }

    private static boolean isFieldTestable(Field f) {
        return !f.getType().isPrimitive() && !"$jacocoData".equalsIgnoreCase(f.getName());
    }
}

