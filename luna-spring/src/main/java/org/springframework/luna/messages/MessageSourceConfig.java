package org.springframework.luna.messages;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

/**
 * @author chenzhangyue
 * 2023/3/26
 */
@Configuration
public class MessageSourceConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		// 用于文件夹区分
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());

		return messageSource;
	}
}
