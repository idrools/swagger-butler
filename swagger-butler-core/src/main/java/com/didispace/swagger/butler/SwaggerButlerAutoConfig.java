package com.didispace.swagger.butler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 程序猿DD/翟永超 on 2018/5/24.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerButlerProperties.class)
public class SwaggerButlerAutoConfig {

    @Bean
    @ConditionalOnProperty(name = {"swagger.butler.mode"}, havingValue = "zuul")
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProcessor() {
        return new SwaggerResourcesZuulProcessor();
    }
    @Bean
    @ConditionalOnProperty(name = {"swagger.butler.mode"}, havingValue = "gateway")
    @Primary
    public SwaggerResourcesProvider swaggerResourcesGatewayProcessor() {
        return new SwaggerResourcesGatewayProcessor();
    }

}
