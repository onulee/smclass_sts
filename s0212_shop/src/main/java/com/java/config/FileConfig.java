package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//web구축시 사용되는 images 위치를 지정
//		registry.addResourceHandler("/images/**")
//		.addResourceLocations("file:///c:/upload/");
		
		//파일업로드에서 파일위치를 지정
		registry.addResourceHandler("/upload/board/**")
		.addResourceLocations("file:///c:/upload/board/");
		
		
	}

}
