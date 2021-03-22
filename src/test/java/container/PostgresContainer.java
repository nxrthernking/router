package container;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;


public class PostgresContainer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static final String IMAGE = "postgres:latest";
    public static final String INIT_DATABASE = "INIT_DATABASE";


    private final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(IMAGE)
            .withDatabaseName(INIT_DATABASE)
            .withUsername("postgres")
            .withPassword("root")
            .withNetwork(Network.newNetwork());


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        postgresContainer.start();
        TestPropertyValues.of(
                "spring.datasource.url=" + postgresContainer.getJdbcUrl() + "?currentSchema=router",
                "spring.datasource.username=" + postgresContainer.getUsername(),
                "spring.datasource.password=" + postgresContainer.getPassword())
                .applyTo(applicationContext.getEnvironment());
    }
}
