package org.springframework.luna.domain.xml;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Component
public class UserFactoryBean implements FactoryBean {

	@Autowired
	private Phone phone;

	@Override
	public Object getObject() throws Exception {
		return new User(phone, "factory bean name");
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
