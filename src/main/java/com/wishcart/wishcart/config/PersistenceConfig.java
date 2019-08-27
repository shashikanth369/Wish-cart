package com.wishcart.wishcart.config;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import lombok.Getter;
import lombok.NonNull;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wishcart.wishcart.WishCartApplication;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;

@EnableTransactionManagement
@Configuration
public class PersistenceConfig {

	private static final String SCHEMA_NAME = "MY_DB";

	@Configuration
	static class TransactionConfig {
		@Bean
		@Primary
		public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
			return new JpaTransactionManager(entityManagerFactory);
		}
	}

	@Getter
	@Configuration
	@EnableJpaRepositories(basePackageClasses = { CustomerRepository.class, })
	static class JpaConfig extends AbstractJpaConfig {
		public JpaConfig(WishCartProperties wishCartProperties, JpaProperties jpaProperties, DataSource dataSource) {
			super(wishCartProperties, jpaProperties, dataSource);
		}

		@Bean
		@Primary
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
			return buildEntityManagerFactory(builder, "MY_DB", "MY_DB", WishCartApplication.class);
		}
	}

	@Getter
	static abstract class AbstractJpaConfig {
		@NonNull
		private WishCartProperties wishCartProperties;

		@NonNull
		private JpaProperties jpaProperties;

		@NonNull
		private DataSource dataSource;

		public AbstractJpaConfig(WishCartProperties wishCartProperties, JpaProperties jpaProperties,
				DataSource dataSource) {
			this.wishCartProperties = wishCartProperties;
			this.dataSource = dataSource;
			this.jpaProperties = jpaProperties;
		}

		protected Map<String, Object> getHibernateProperties(final String schemaBame) {
			Map<String, Object> vendorProperties = new LinkedHashMap<>();
			vendorProperties.putAll(getJpaProperties().getProperties());
			return vendorProperties;
		}

		protected LocalContainerEntityManagerFactoryBean buildEntityManagerFactory(EntityManagerFactoryBuilder builder,
				String unitName, String schemaName, Class<?>... basePackageClasses) {
			List<Class<?>> packagesToScan = new ArrayList<>(Arrays.asList(basePackageClasses));
			packagesToScan.add(Jsr310JpaConverters.class);
			return builder.dataSource(getDataSource()).persistenceUnit(unitName)
					.packages(packagesToScan.toArray(new Class<?>[] {})).properties(getHibernateProperties(SCHEMA_NAME))
					.build();
		}
	}
}
