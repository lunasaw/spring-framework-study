package org.springframework.luna.componentscan;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author chenzhangyue
 * 2023/3/15
 */
public class MyCustomBeanNameGenerator extends AnnotationBeanNameGenerator {

	@NotNull
	@Override
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return "custom_luna_" + super.generateBeanName(definition, registry);
	}
}
