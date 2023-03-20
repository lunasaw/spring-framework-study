package org.springframework.luna.annoconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.luna.domain.Address;

import java.util.Arrays;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
public class AnnoContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
		context.register(CustomConfig.class);
		context.refresh();
		Address address = (Address) context.getBean("address");

		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
	}
}
