package org.springframework.luna;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author chenzhangyue
 * ${DATE}
 */
@Slf4j
public class Main {



	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		ConfigurableEnvironment environment = classPathXmlApplicationContext.getEnvironment();
		Map<String, Object> systemProperties = environment.getSystemProperties();
		System.out.println(JSON.toJSONString(systemProperties));
		User user = (User) classPathXmlApplicationContext.getBean("user");
		log.info("user: {}", user);
	}
}