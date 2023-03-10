package org.springframework.luna.domain;

import lombok.Data;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Data
public class Address {
	private String address;

	public void init() {
		System.out.println("init address");
	}
}
