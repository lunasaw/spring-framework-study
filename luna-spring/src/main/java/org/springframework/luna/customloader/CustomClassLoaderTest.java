package org.springframework.luna.customloader;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class CustomClassLoaderTest {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/weidian/my-project/spring-framework/luna-spring/src/main/java");
        Class<?> clazz = myClassLoader.loadClass("org.springframework.luna.UserTemp");
        Object o = clazz.getDeclaredConstructor().newInstance();
		for (Field declaredField : clazz.getDeclaredFields()) {
			System.out.println(declaredField.getName());
		}
		Method[] declaredMethods = clazz.getDeclaredMethods();
		System.out.println(Arrays.toString(declaredMethods));


		Method say = clazz.getDeclaredMethod("setName", String.class);
        say.invoke(o,"set Name is li hua");


		String cp = System.getProperty("java.class.path");
		if (cp == null || cp.isEmpty()) {
			String initialModuleName = System.getProperty("jdk.module.main");
			cp = (initialModuleName == null) ? "" : null;
			System.out.println("initialModuleName: " + initialModuleName);
		}

		List<String> classPathList = Splitter.on(":").splitToList(cp);
		System.out.println("class path:" + JSON.toJSONString(classPathList));

		Properties properties = System.getProperties();
		Set<String> strings = properties.stringPropertyNames();
		List<PropertyDTO> propertyDTOS = new ArrayList<>();
		for (String string : strings) {
			String property = System.getProperty(string);
			propertyDTOS.add(new PropertyDTO(string, property));
		}

		System.out.println(JSON.toJSONString(propertyDTOS));
	}

	@Data
	@AllArgsConstructor
	private static class PropertyDTO{
		private String key;

		private String value;
	}
}
