package com.sitesample.service;

import com.sitesample.service.model.Offer;
import com.sitesample.service.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("db.properties")
@ComponentScan("com.sitesample.service")
public class DatabaseConfig {

    @Value("${hibernate.connection.driver_class}")
    private String driverClass;

    @Value("${hibernate.connection.url}")
    private String url;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setAnnotatedClasses(User.class, Offer.class);
        sessionFactoryBean.setHibernateProperties(hibernateproperties());
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    private Properties hibernateproperties() {
        return new Properties(){
            {
                setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
                setProperty("hibernate.dialect", dialect);
            }
        };
    }
}
