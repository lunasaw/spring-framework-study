package org.springframework.luna;


import lombok.Data;

/**
 * @author chenzhangyue
 * 2023/3/8
 */
@Data
public class User {

	private String name;


	public void setName(String name) {
		System.out.println("this.is:" + name);
		this.name = name;
	}
}
