package com.pik.expenses.config;

import static com.google.common.base.Predicates.not;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo("1.1")).select().apis(RequestHandlerSelectors
                .basePackage("com.pik.expenses")).apis(not(RequestHandlerSelectors.basePackage("org.springframework")))
                .paths(PathSelectors.any()).build().forCodeGeneration(true);
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder().title("Expenses Service").description(
                "This is the service provided by PIK to complete the Expenses process").license("pik.com/terms/")
                .version(
                        version).contact(new Contact("", "", "test@pik.com")).build();
    }
}
