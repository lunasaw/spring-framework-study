package org.springframework.luna.domain.anno;

import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Component
public class Email {


	private Integer number;

	public Email() {
		System.out.println("email empty constructor");
	}
}
