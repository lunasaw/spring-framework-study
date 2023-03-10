package org.springframework.luna.domain.xml;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Data
//@Component
public class Phone {
	private String number;

	public void init() {
		System.out.println("init address");
	}

	public Phone() {
		System.out.println("empty constructor");
	}

	public Phone(String number) {
		this.number = number;
	}
}
