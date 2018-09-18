package cn.willvi.springbootswaggerdemo.config;

import cn.willvi.springbootswaggerdemo.properties.Swagger2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program : springboot-swagger-demo
 * @Date : 2018/9/18 9:23
 * @Author : willvi
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Autowired
    Swagger2 swagger2Properties;

    @Bean
    public Docket api() {
        // 统一设置返回描述
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(400).message("请求参数有误").build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("未授权").build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("禁止访问").build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("请求路径不存在").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("string")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                // 禁用默认返回描述
                .useDefaultResponseMessages(false)
                // 启用新的返回描述
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PATCH, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                // 设置基本信息
                .apiInfo(apiInfo())
                .select()
                // 设置哪些api被扫描
                .apis(RequestHandlerSelectors.basePackage("cn.willvi.springbootswaggerdemo"))
                // 设置路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription())
                .version(swagger2Properties.getVersion())
                .termsOfServiceUrl(swagger2Properties.getTermsOfServiceUrl())
                .license(swagger2Properties.getLicense())
                .licenseUrl(swagger2Properties.getLicenseUrl())
                .build();
    }
}
