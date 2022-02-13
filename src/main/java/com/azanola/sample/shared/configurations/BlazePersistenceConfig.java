package com.azanola.sample.shared.configurations;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.blazebit.persistence.spring.data.impl.repository.BlazePersistenceRepositoryFactoryBean;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Configuration
@EnableJpaRepositories(
		repositoryFactoryBeanClass = BlazePersistenceRepositoryFactoryBean.class,
		basePackages = {"com.azanola.sample.database"}
)
@EnableEntityViews("com.azanola.sample.shared.views")
public class BlazePersistenceConfig {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Lazy(false)
	public CriteriaBuilderFactory createCriteriaBuilderFactory() {
		CriteriaBuilderConfiguration config = Criteria.getDefault();
		// do some configuration
		return config.createCriteriaBuilderFactory(entityManagerFactory);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Lazy(false)
	// inject the criteria builder factory which will be used along with the entity view manager
	public EntityViewManager createEntityViewManager(CriteriaBuilderFactory cbf, EntityViewConfiguration entityViewConfiguration) {
		return entityViewConfiguration.createEntityViewManager(cbf);
	}
}
