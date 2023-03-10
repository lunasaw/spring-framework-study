package org.springframework.luna.config;

import com.luna.common.anno.MyValid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.luna.componentscan.LunaTypeFilter;
import org.springframework.luna.domain.Address;
import org.springframework.stereotype.Component;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
@Configuration
@ComponentScan(basePackages = {"org.springframework.luna.domain.anno"}, useDefaultFilters = false,
		// 过滤指定注解 所有条件取交集
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {MyValid.class})},
		includeFilters = {@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "org.springframework.luna.domain.**"),
				@ComponentScan.Filter(type = FilterType.CUSTOM, classes = LunaTypeFilter.class)}, lazyInit = true
)
public class CustomConfig {

	@Bean(initMethod = "init")
	public Address address() {
		return new Address();
	}
}
