package org.springframework.luna;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenzhangyue
 * ${DATE}
 */
public class Main {


	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		User user = (User) classPathXmlApplicationContext.getBean("user");
		System.out.println(user);
	}
}