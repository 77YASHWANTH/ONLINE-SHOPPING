package net.yash.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration  //Spring @Configuration annotation is part of the spring core framework. Spring Configuration annotation indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application.
@ComponentScan(basePackages= {"net.yash.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig<Datasource> { 
	
	//These are Database status-change the below based on the DBMS you choose
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping77";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = ""; 
	
	
	
	
	//Three Main Bean DataSource,SessionFactory,HibernateTransactionManager
	
	@Bean //DataSource (providing the connection information of the database.
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//providing the dataase connection information
				dataSource.setDriverClassName(DATABASE_DRIVER);
				dataSource.setUrl(DATABASE_URL);
				dataSource.setUsername(DATABASE_USERNAME);
				dataSource.setPassword(DATABASE_PASSWORD);
				
				
		
		return dataSource;
	}
	
	@Bean //configures application to use Hibernate and create a session object.
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.yash.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	// This method attached to SessionFactory ...it will return hibernate propeties to sessionfactory.
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	} 
	
	@Bean //To manage the hibernate transactions
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	
		return transactionManager;
	
	
	}
	

}
