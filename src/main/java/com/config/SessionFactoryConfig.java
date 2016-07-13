
package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vote.dao.impl.BaseImpl;

@Configuration
// 启用注解事务管理，使用CGLib代理
@TransactionConfiguration(transactionManager = "transactionManager")
@EnableTransactionManagement(proxyTargetClass = true)
@Import({ DataSourceConfig.class })
public class SessionFactoryConfig {
	private static final Logger logger = Logger.getLogger(SessionFactoryConfig.class);

	@Value("${hibernate.dialect}")
	String hibernate_dialect;
	@Value("${hibernate.show_sql}")
	String hibernate_show_sql;
	@Value("${hibernate.hbm2ddl.auto}")
	String hibernate_hbm2ddl_auto;

	@Value("${hibernate.search.dir}")
	String hibernate_search_dir;
	@Value("${hibernate.directory.provider}")
	String hibernate_directory_provider;
	@Value("${defaultAutoCommit}")
	String defaultAutoCommit;
	@Value("${configurationClass}")
	String configurationClass;
	@Value("${hibernate.current.session.context.class}")
	String hibernate_current_session_context_class;

	/**
	 * 描述 : <负责解析资源文件>. <br>
	 * <p>
	 * <这个类必须有，而且必须声明为static，否则不能正常解析>
	 * </p>
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
		logger.info("PropertySourcesPlaceholderConfigurer");
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Autowired
	public DataSource dataSource;

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean localSessionFactoryBean() {
		logger.info("sessionFactory");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		String[] packagesToScan = new String[] { "com" };
		sessionFactory.setPackagesToScan(packagesToScan);

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
		hibernateProperties.setProperty("hibernate.show_sql", hibernate_show_sql);

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
		hibernateProperties.setProperty("configurationClass", configurationClass);
		hibernateProperties.setProperty("defaultAutoCommit", defaultAutoCommit);
		hibernateProperties.setProperty("hibernate.search.default.indexBase", hibernate_search_dir);
		hibernateProperties.setProperty("hibernate.search.default.directory_provider", hibernate_directory_provider);
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;

	}

	@Bean(name = "hibernateDAO")
	public BaseImpl hibernate4Dao() {
		logger.info("hibernateDAO");
		BaseImpl dao = new BaseImpl();
		LocalSessionFactoryBean local = localSessionFactoryBean();
		HibernateTemplate hibernateTemplate = new HibernateTemplate(local.getObject());
		dao.setHibernateTemplate(hibernateTemplate);
		dao.setSessionFactory(local.getObject());
		return dao;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager hibernateTransactionManager() {
		logger.info("transactionManager");
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());

		return hibernateTransactionManager;
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}

	@Bean(name = "cacheManager")
	public EhCacheCacheManager cacheManager() {
		logger.info("EhCacheCacheManager");
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
		return cacheManager;
	}
}