package org.springframework.luna.domain;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor 被处理为统一bean后置处理，因为每个bean的初始化都会回调用这个
 * @author chenzhangyue
 * 2023/3/10
 */
@Data
public class Address implements InitializingBean, BeanPostProcessor {

    /**
	 * BeanPostProcessor加入会失效
     * 这是因为BeanPostProcessor接口是一个回调接口，它允许您在Spring容器实例化bean之后修改bean实例。
	 * 但是，当您实现BeanPostProcessor接口时，Spring将在 bean实例化之后立即调用postProcessBeforeInitialization()和postProcessAfterInitialization()方法。
	 * 在这些方法中，您可以修改bean实例的属性，但是在此过程中，@Value注释不会被处理。
	 * 要解决这个问题，您可以使用PropertySourcesPlaceholderConfigurer类。这个类可以在Spring容器实例化bean之前解析属性占位符，
	 * 包括@Value注释中的占位符。这样，当您实现BeanPostProcessor接口时，@Value注释也会被正确处理
     */
    @Value("${luna.user.address}")
    private String address;

    public void init() {
        System.out.println("Address init address");
    }

    /**
     * 属性初始化后
     * 
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Address execute InitializingBean afterPropertiesSet");
    }

	/**
	 * 任何bean的初始化 都会回调这个
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " execute BeanPostProcessor postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " execute BeanPostProcessor postProcessAfterInitialization");
        return bean;
    }
}
