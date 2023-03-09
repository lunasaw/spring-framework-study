package org.springframework.luna.properties;

import java.util.Map;

/**
 * @author chenzhangyue
 * 2023/3/9
 */
public class SysPropertiesTest {
	public static void main(String[] args) {
		Map properties = System.getProperties();
		System.out.println(properties);
	}
}
