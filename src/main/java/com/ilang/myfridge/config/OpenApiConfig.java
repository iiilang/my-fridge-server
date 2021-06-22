package com.ilang.myfridge.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "마이냉장고 API 명세서", description = "API 명세서", version = "0.1"))
@Configuration
public class OpenApiConfig {
  @Bean
  public GroupedOpenApi fridgeApis() {
    return GroupedOpenApi.builder().setGroup("fridge").pathsToMatch("/**/fridge/**").build();
  }

  @Bean
  public GroupedOpenApi foodApis() {
    return GroupedOpenApi.builder().setGroup("food").pathsToMatch("/**/food/**").build();
  }

  @Bean
  public GroupedOpenApi userApis() {
    return GroupedOpenApi.builder().setGroup("user").pathsToMatch("/**/users/**").build();
  }
}
