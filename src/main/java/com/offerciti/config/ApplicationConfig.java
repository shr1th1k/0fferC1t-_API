package com.offerciti.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@PropertySource("classpath:application.properties")
@EnableSwagger2
public class ApplicationConfig {
  
  private static final String PROPERTY_NAME_DATABASE_DRIVER = "spring.datasource.driver-class-name";
  private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
  private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
  private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";

  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
  private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
  private static final String PROPERTY_NAME_SPRING_NAMING_STRATEGY="spring.jpa.hibernate.naming-strategy";

  @Resource
  private Environment environment;
  
  @Bean
  public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
      dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
      dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
      dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

      return dataSource;
  }
  
  @Bean
  public EntityManager entityManager() {
      return entityManagerFactory().getObject().createEntityManager();
  }
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan("com.offerciti");
      em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      Properties jpaProterties = new Properties();
      jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
      jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
      jpaProterties.put(PROPERTY_NAME_SPRING_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_SPRING_NAMING_STRATEGY));
      return em;
  }
  
  @Bean
  public Docket api() { 
      return new Docket(DocumentationType.SWAGGER_2)  
        .select()                                  
        .apis(RequestHandlerSelectors.any())              
        .paths(PathSelectors.any())                          
        .build();                                           
  }

}
