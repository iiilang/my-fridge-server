package com.ilang.myfridge.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "마이냉장고 API 명세서", description = "API 명세서", version = "0.1"))
@Configuration
public class OpenApiConfig {
  @Bean
  public GroupedOpenApi fridgeApis() {
    return GroupedOpenApi.builder().setGroup("fridges").pathsToMatch("/**/fridges/**").build();
  }

  @Bean
  public GroupedOpenApi foodApis() {
    return GroupedOpenApi.builder().setGroup("foods").pathsToMatch("/**/foods/**").build();
  }

  @Bean
  public GroupedOpenApi userApis() {
    return GroupedOpenApi.builder().setGroup("user").pathsToMatch("/**/user/**").build();
  }
}
