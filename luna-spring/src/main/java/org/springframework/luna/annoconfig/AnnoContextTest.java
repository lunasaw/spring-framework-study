package org.springframework.luna.annoconfig;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.luna.aware.AwareConfig;
import org.springframework.luna.domain.Address;
import org.springframework.luna.domain.anno.Email;
import org.springframework.luna.messages.MessageSourceConfig;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
public class AnnoContextTest {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomConfig.class);
        context.register(MessageSourceConfig.class, AwareConfig.class);
        context.refresh();
        Address address = (Address)context.getBean("address");
		System.out.println(JSON.toJSONString(address));

		String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Email email = (Email)context.getBean("custom_luna_email");
        System.out.println(JSON.toJSONString(email));
        Object[] messageArgs = new Object[] {"小明"};

        String hi_zh = context.getMessage("hi", messageArgs, Locale.CHINA);
        assert "你好 我是小明".equals(hi_zh);
        String hi_en = context.getMessage("hi", messageArgs, Locale.ENGLISH);
        assert "hi I'm 小明".equals(hi_en);

		Resource[] resources = context.getResources("classpath*:META-INF/");
		String location = ResourceUtils.CLASSPATH_URL_PREFIX + "application.xml";
		Resource resource = context.getResource(location);
		assert resource.exists();

		String description = resource.getDescription();

		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		List<PropertySource<?>> sources = propertySources.stream().collect(Collectors.toList());
		PropertySource<?> propertySource = propertySources.get("application-prod.yml");
		System.out.println(JSON.toJSONString(propertySource));
		PropertySource<?> persistence = propertySources.get("class path resource [persistence-prod.properties]");
		System.out.println(JSON.toJSONString(persistence));

	}
}
