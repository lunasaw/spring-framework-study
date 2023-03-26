package org.springframework.luna.beandefinition;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.luna.annoconfig.CustomConfig;
import org.springframework.luna.domain.Address;

import java.util.List;
import java.util.Map;

/**
 * @author chenzhangyue
 * 2023/3/26
 */
public class BeanDefinitionTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition beanDefinition =
            BeanDefinitionBuilder.genericBeanDefinition(CustomConfig.class).setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();

        // 容器注入Bean信息
        beanFactory.registerBeanDefinition(CustomConfig.class.getSimpleName(), beanDefinition);

        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println(JSON.toJSON(definitionNames));

        // 注入内置后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        definitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println(JSON.toJSON(definitionNames));

        // 获取内置处理器执行 解析注解
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beanFactoryPostProcessorMap.forEach((s, beanFactoryPostProcessor) -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));

        // 手动执行bean的后置处理器
        List<BeanPostProcessor> processors = beanFactory.getBeanPostProcessors();
        Address bean = beanFactory.getBean(Address.class);
        for (BeanPostProcessor processor : processors) {
            processor.postProcessAfterInitialization(bean, "address");
        }

        // 添加统一回调
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
		beanFactory.addBeanPostProcessors(beanPostProcessorMap.values());

		definitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println(JSON.toJSON(definitionNames));

		Address address = beanFactory.getBean(Address.class);
	}

}