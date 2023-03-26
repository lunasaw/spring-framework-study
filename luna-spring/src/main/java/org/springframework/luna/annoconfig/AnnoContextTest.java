package org.springframework.luna.annoconfig;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.luna.domain.Address;
import org.springframework.luna.domain.anno.Email;
import org.springframework.luna.messages.MessageSourceConfig;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
public class AnnoContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomConfig.class);
        context.register(MessageSourceConfig.class);
        context.refresh();
        Address address = (Address)context.getBean("address");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        Email email = (Email)context.getBean("custom_luna_email");
        System.out.println(JSON.toJSONString(email));
		Object[] messageArgs = new Object[] {"Hello"};

		String hi = context.getMessage("hi",  messageArgs, Locale.CHINA);
//		String luna = MessageFormat.format(hi, "luna");
		System.out.println(hi);
        // System.out.println(hi);
        // String hi_en = context.getMessage("hi", null, Locale.ENGLISH);
    }
}
