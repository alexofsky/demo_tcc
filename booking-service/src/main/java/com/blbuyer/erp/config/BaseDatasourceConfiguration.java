package com.blbuyer.erp.config;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * base数据源配置
 * 
 * @author He Liwei
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "baseEntityManagerFactory", transactionManagerRef = "baseTransactionManager", basePackages = {
        BaseDatasourceConfiguration.REPOSITORY_PAKAGE }) // 设置Repository所在位置
public class BaseDatasourceConfiguration {

    private static final String BASE_DATA_SOURCE_NAME = "baseDataSource";

    @Bean(name = BASE_DATA_SOURCE_NAME)
    @Qualifier(BASE_DATA_SOURCE_NAME)
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.base-db")
    public DataSource baseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Qualifier(BASE_DATA_SOURCE_NAME)
    private DataSource baseDataSource;

    private static final String DOMAIN_PACKAGE = "com.blbuyer.erp.domain";

    protected static final String REPOSITORY_PAKAGE = "com.blbuyer.erp.repository";

    // @Primary
    @Bean(name = "baseEntityManager")
    public EntityManager baseEntityManager(EntityManagerFactoryBuilder builder) {
        return baseEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "baseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean baseEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(baseDataSource)//
                .properties(getVendorProperties(baseDataSource))//
                .packages(DOMAIN_PACKAGE) // 设置实体类所在位置
                .persistenceUnit("basePersistenceUnit").build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "baseTransactionManager")
    public PlatformTransactionManager baseTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(baseEntityManagerFactory(builder).getObject());
    }

}
