package org.springframework.luna.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.luna.domain.Address;

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
	}
}
