package org.springframework.luna.alias;

import com.luna.common.utils.Assert;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



//编写测试代码
public class ExtendAnnotationTest {

	public static void main(String[] args) {
		// ExtendClass 竹节了
		AnnotationBase annotationBase = AnnotatedElementUtils.findMergedAnnotation(ExtendClass.class, AnnotationBase.class);
		assert annotationBase != null;
		Assert.isTrue(annotationBase.setValue().equals("setValue to extendValue and setValue"), "");
	}
}

//编写元注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotationBase {
	String setValue() default "";

}
//编写子注解，其中子注解打上了元注解@AnnotaionBase标识
@AnnotationBase
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotationChild {

	@AliasFor(annotation = AnnotationBase.class, attribute = "setValue")
	String extendValue() default "";
}


//编写测试类
@AnnotationChild(extendValue = "setValue to extendValue and setValue")
class ExtendClass {

}