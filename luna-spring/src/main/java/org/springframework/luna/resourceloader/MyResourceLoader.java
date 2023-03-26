package org.springframework.luna.resourceloader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

/**
 * @author chenzhangyue
 * 2023/3/14
 */
public class MyResourceLoader {

    public static void main(String[] args) {

        String location = ResourceUtils.CLASSPATH_URL_PREFIX + "application.xml";

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource(location);
        Assert.isTrue(resource.exists(), "file exists false");

		
    }
}
