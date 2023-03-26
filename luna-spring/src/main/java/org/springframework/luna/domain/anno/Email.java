package org.springframework.luna.domain.anno;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.luna.properties.YamlPropertySourceFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PropertyKey;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Component
@Data
/**
 * spring 读取yaml 需要配合 YamlPropertySourceFactory {@See PropertySourceAnnotationTests}
 */
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@PropertySource(value = "classpath:application-prod.yml", factory = YamlPropertySourceFactory.class)
@PropertySource(value = "classpath:application.properties")
@PropertySource({
		"classpath:persistence-${serve.active}.properties"
})
public class Email implements InitializingBean {

	@Value("${luna.email.user-name}")
	private String userName;

	@Value("${email.number:dev@inject.com}")
	private String number;

	public Email() {
		System.out.println("email empty constructor");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Email初始化后执行 InitializingBean");
	}


}
