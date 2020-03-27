package br.com.albus.generic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestFilterHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestFilterHelper.class);

    private RequestFilterHelper() {
    }

    public static String getValueFilter(String[] objFilter) {
        return objFilter != null && !"".equals(objFilter[0]) ? String.valueOf(objFilter[0]) : null;
    }

    public static <E extends Enum<E>> List<E> checkListStringToListEnum(Class<E> enumType, String checkListString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<E> listEnum = new ArrayList();
        Map<String, Boolean> map = (Map)mapper.readValue(checkListString, new TypeReference<Map<String, Boolean>>() {
        });
        map.forEach((key, value) -> {
            if (value != null && value) {
                try {
                    listEnum.add(Enum.valueOf(enumType, key.toUpperCase()));
                } catch (IllegalArgumentException var5) {
                    LOGGER.warn("Valor " + key + " inválido para " + enumType.getName());
                }
            }

        });
        return listEnum;
    }
}
