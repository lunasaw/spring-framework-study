package org.springframework.luna.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.context.LyaAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.metrics.ApplicationStartup;

/**
 * @author chenzhangyue
 * 2023/3/30
 */
@Configuration
public class AwareConfig implements BeanNameAware, ApplicationContextAware, BeanFactoryAware, ApplicationStartupAware, LyaAware {

    private BeanFactory        beanFactory;

    private String             beanName;

    private ApplicationContext applicationContext;

    private ApplicationStartup applicationStartup;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println(beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("beanName: " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        this.applicationStartup = applicationStartup;
    }

	@Override
	public void setLunaContext() {
		System.out.println("luna LyaAware invoke callback");
	}
}
