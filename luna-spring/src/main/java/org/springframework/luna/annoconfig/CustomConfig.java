package org.springframework.luna.annoconfig;

import com.luna.common.anno.MyValid;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.luna.componentscan.LunaTypeFilter;
import org.springframework.luna.componentscan.MyCustomBeanNameGenerator;
import org.springframework.luna.domain.Address;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Configuration
@ComponentScan(basePackages = {"org.springframework.luna.domain.anno"}, useDefaultFilters = false,
    // 过滤指定注解 所有条件取交集
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {MyValid.class})},
    includeFilters = {@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "org.springframework.luna.domain.anno.**"),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = LunaTypeFilter.class)},
    lazyInit = true, nameGenerator = MyCustomBeanNameGenerator.class)
public class CustomConfig {

    @Bean(initMethod = "init")
    public Address address() {
        return new Address();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return beanFactory -> {
            BeanDefinition address = beanFactory.getBeanDefinition("address");
            System.out.println(address);
        };
    }
}
