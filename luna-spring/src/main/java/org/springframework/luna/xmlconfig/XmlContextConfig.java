package org.springframework.luna.xmlconfig;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.luna.domain.xml.Phone;
import org.springframework.luna.domain.xml.User;
import org.springframework.luna.domain.xml.UserFactoryBean;

import java.util.Arrays;
import java.util.Map;

/**
 * @author chenzhangyue
 * ${DATE}
 */
@Slf4j
public class XmlContextConfig {



	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");

		String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
		ConfigurableEnvironment environment = classPathXmlApplicationContext.getEnvironment();
		// 系统配置项
		Map<String, Object> systemProperties = environment.getSystemProperties();

		Phone phone = (Phone) classPathXmlApplicationContext.getBean("phone");
		System.out.println(phone);

		// 这里使用了自定义bean name 生成器
		User user = (User) classPathXmlApplicationContext.getBean("custom_luna_user");
		System.out.println(JSON.toJSONString(user));

		User userFactoryBean = (User) classPathXmlApplicationContext.getBean("userFactoryBean");
		System.out.println(JSON.toJSON(userFactoryBean));
	}
}