/**
 * Project Name:credit-sdk
 * File Name:MyWebConfig.java
 * Package Name:com.huarong.credit.sdk.config
 * Date:2020年7月30日下午6:16:58
 * Copyright (c) 2020, hejiahua@szhuarong.com All Rights Reserved.
 *
*/

package com.huarong.credit.sdk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:MyWebConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2020年7月30日 下午6:16:58 <br/>
 * 
 * @author hejiahua
 * @version
 * @see
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
