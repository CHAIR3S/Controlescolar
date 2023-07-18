package com.utng.controlescolar.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class CorsConfig {
	
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		
		
    	return new WebMvcConfigurer() {
    		
    		@Override
    		public void addCorsMappings(CorsRegistry registry) {
    			// TODO Auto-generated method stub
    			
    			registry.addMapping("/**")
    					.allowedOrigins("http://localhost:4200")
    					.allowedMethods("*")
    					.exposedHeaders("*");
    			

    		}
		}; 
    		
    		

		};
	
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
    	
}
    	
    	
    	
    	
    	
		
//		return new WebMvcConfigurer() {
//			
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				
////				registry.addMapping("/login")
////						.allowedOrigins("http://localhost:4200")
////						.allowedMethods("*")
////						.exposedHeaders("*");
////				
////				
////				registry.addMapping("/**")
////						.allowedOrigins("http://localhost:4200/")
////						.allowedMethods("*");
//				
//				
////				registry.addMapping("/**")
////			    		.allowedOrigins("http://localhost:4200")
////			    		.allowedMethods("*");
//
//			}
//		};
//	}
    
    
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }






