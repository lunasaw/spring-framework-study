package org.springframework.luna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.luna.User;
import org.springframework.luna.domain.Address;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Configuration
public class CustomConfig {

	@Bean(initMethod = "init")
	public Address address() {
		return new Address();
	}

	@Bean
	public User user() {
		return new User();
	}
}
