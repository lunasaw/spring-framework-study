package org.springframework.luna.proxy;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenzhangyue
 * 2023/3/30
 */
@Data
public class Person implements Sound{


    public static void main(String[] args) {
		Person person = new Person();
		Sound proxy = (Sound) Proxy.newProxyInstance(Person.class.getClassLoader(),
				Person.class.getInterfaces(), new PersonProxy(person));
		System.out.println(proxy.soundMusic());
		System.out.println(proxy.soundGuitar("luna"));
	}

	@Override
	public String soundMusic() {
		return "person sound";
	}

	@Override
	public String soundGuitar(String user) {
		return  user + "play guitar";
	}

	static class PersonProxy implements InvocationHandler{

		private Object target;

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			return method.invoke(target, args);
		}

		public PersonProxy(Object target) {
			this.target = target;
		}
	}
}
interface Sound {
    String soundMusic();

	String soundGuitar(String user);
}
