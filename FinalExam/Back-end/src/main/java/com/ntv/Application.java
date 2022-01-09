package com.ntv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Server is running...");
        //Using generated security password: cc08caff-5313-4670-9457-26f16a6617e8
    }

    @Bean
    @SuppressWarnings("deprecation")
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurerAdapter() {
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
