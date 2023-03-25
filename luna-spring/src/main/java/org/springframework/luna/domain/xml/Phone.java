package org.springframework.luna.domain.xml;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Data
// @Component
public class Phone implements InitializingBean {
    private String number;

    public void init() {
        System.out.println("init Phone");
    }

	public void destroy() {
		System.out.println("destroy Phone");
	}

    public Phone() {
        System.out.println("empty constructor");
    }

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
		System.out.println("初始化后执行： InitializingBean");
    }
}
