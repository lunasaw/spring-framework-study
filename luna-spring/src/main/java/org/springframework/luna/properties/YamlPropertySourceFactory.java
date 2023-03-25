package org.springframework.luna.properties;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author chenzhangyue
 * 2023/3/25
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @NotNull
	@Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
        // 创建一个YAML解析工厂。
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        // 设置资源。
        factory.setResources(encodedResource.getResource());

        // 获取解析后的Properties对象
        Properties properties = factory.getObject();
        // 返回。此时不能像默认工厂那样返回ResourcePropertySource对象 ，要返回他的父类PropertiesPropertySource对象。
        return name != null ? new PropertiesPropertySource(name, properties)
            : new PropertiesPropertySource(Objects.requireNonNull(encodedResource.getResource().getFilename()), properties);
    }
}
