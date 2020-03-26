package br.com.albus.config;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = WebEnvironment.RANDOM_PORT
)
@TestPropertySource(
        properties = {
                "server.port=8082",
                "spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false",
//                "spring.session.store-type=none",
//                "spring.profiles.default=test",
                "spring.liquibase.enabled=true",
                "spring.liquibase.change-log=classpath:db/master-init.xml",
                "spring.jpa.hibernate.ddl-auto=create-drop",
                "spring.jpa.hibernate.show_sql=true",
                "spring.jpa.open-in-view=false",
                "spring.liquibase.parameters.datasource.platform=h2",
                "spring.datasource.driverClassName=org.h2.Driver",
                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
                "spring.datasource.url=jdbc:h2:mem:testdb;" +
                        "DB_CLOSE_DELAY=-1;" +
                        "DB_CLOSE_ON_EXIT=FALSE;" +
                        "INIT=RUNSCRIPT FROM \'classpath:scripts/create_schemas.sql\'",
                "spring.datasource.initialize=false",
                "spring.datasource.username=sa",
                "spring.datasource.password=654654",
                "spring.jpa.show-sql=true",
                "spring.datasource.max-active=30",
                "spring.datasource.max-wait=60000",
                "spring.datasource.initial-size=5",
                "spring.datasource.max-idle=10",
                "spring.datasource.min-idle=5",
                "spring.datasource.time-between-eviction-runs-millis=5000",
                "spring.datasource.min-evictable-idle-time-millis=60000",
                "spring.datasource.validationQuery=SELECT 1",
                "logging.path=../",
                "org.h2=INFO",
                "logging.level.root=INFO",
                "logging.level.org.springframework.web=INFO",
                "logging.level.org.hibernate=INFO",
                "spring.h2.console.enabled=true",
                "spring.h2.console.path=/h2",
        }
)
@DirtiesContext(
        classMode = ClassMode.BEFORE_EACH_TEST_METHOD
)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@Transactional
@DbUnitConfiguration()
public abstract class GenericTest {
    public GenericTest() {

    }
}