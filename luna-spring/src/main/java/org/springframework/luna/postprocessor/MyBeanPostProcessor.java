package org.springframework.luna.postprocessor;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author chenzhangyue
 * 2023/3/14
 */
public interface MyBeanPostProcessor {

	void invoke();
}
class UserBeanPostProcessor implements  MyBeanPostProcessor{

	@Override
	public void invoke() {
		System.out.println("invoke UserBeanPostProcessor");
	}
}

@Data
class Context{

	private List<MyBeanPostProcessor> myBeanPostProcessors = Lists.newArrayList();
}
class Main{
	public static void main(String[] args) {
		Context context = new Context();
		List<MyBeanPostProcessor> myBeanPostProcessors = context.getMyBeanPostProcessors();
		myBeanPostProcessors.add(new UserBeanPostProcessor());
		for (MyBeanPostProcessor myBeanPostProcessor : myBeanPostProcessors) {
			myBeanPostProcessor.invoke();
		}
	}
}