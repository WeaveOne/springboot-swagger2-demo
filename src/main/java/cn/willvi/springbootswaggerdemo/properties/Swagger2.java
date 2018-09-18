package cn.willvi.springbootswaggerdemo.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program : springboot-swagger-demo
 * @Date : 2018/9/18 9:35
 * @Author : willvi
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PropertySource(value = "classpath:swagger2.properties",encoding = "utf-8")
@Component
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2 {
    private String title;
    private String description;
    private String version;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
}
