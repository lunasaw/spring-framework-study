package org.springframework.luna.postprocessor;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;

/**
 * @author chenzhangyue
 * 2023/3/14
 */
public interface MyBeanPostProcessor {

	void invoke();
}
class UserBeanPostProcessor implements  MyBeanPostProcessor, BeanFactoryPostProcessor {

	@Override
	public void invoke() {
		System.out.println("invoke UserBeanPostProcessor");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition phone = beanFactory.getBeanDefinition("phone");
		System.out.println(phone);
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
