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
		System.out.println("-------调用工厂Bean获取bean");
		User user = new User();
		user.setName("luna's phone");
		user.setPhone(phone);
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
