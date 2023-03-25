package org.springframework.luna.domain.xml;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/8
 */
@Data
@Component
public class User {

	private Phone phone;

	@Value("${bean.name}")
	private String name;


	@Autowired
	public User(Phone phone) {
		this.phone = phone;
	}


	public User(Phone phone, String name) {
		this.phone = phone;
		this.name = name;
	}

	public User() {
	}
}
