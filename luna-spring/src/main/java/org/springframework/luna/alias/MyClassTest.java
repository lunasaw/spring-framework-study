package org.springframework.luna.alias;

import com.luna.common.utils.Assert;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

public class MyClassTest {

	public static void main(String[] args) throws NoSuchMethodException {
		Consumer<MyAliasAnnotation> logic = a -> {
			Assert.isTrue("这是值".equals(a.value()), "");
			Assert.isTrue(a.value().equals(a.location()), "");
		};

		MyAliasAnnotation aliasAnnotation = AnnotationUtils.findAnnotation(MyClass.class.getMethod("one"), MyAliasAnnotation.class);
		logic.accept(aliasAnnotation);

		MyAliasAnnotation aliasAnnotation2 = AnnotationUtils.findAnnotation(MyClass.class.getMethod("one2"), MyAliasAnnotation.class);
		logic.accept(aliasAnnotation2);
	}

	public static class MyClass {

		@MyAliasAnnotation(location = "这是值")
		public static void one() {
		}

		@MyAliasAnnotation(value = "这是值")
		public static void one2() {
		}
	}

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAliasAnnotation {

	@AliasFor(value = "location")
	String value() default "";

	@AliasFor(value = "value")
	String location() default "";
}

