package com.accp.cfg;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@ServletComponentScan
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 设置允许跨域的路径
		registry.addMapping("/**")
				// 设置允许跨域请求的域名
				.allowedOrigins("*").allowedHeaders("*")
				// 是否允许证书 不再默认开启
				.allowCredentials(true)
				// 设置允许的方法
				.allowedMethods("*");
	}
	
	/**
	 * 
	* @title: serverEndpointExporter 
	* @description: 注册WebSocket endpoint站点服务,单元测试的时候需要注释这个配置【非常重要】
	* @return
	 */
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}