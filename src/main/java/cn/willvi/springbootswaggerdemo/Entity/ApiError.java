package cn.willvi.springbootswaggerdemo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program : springboot-swagger-demo
 * @Date : 2018/9/18 10:49
 * @Author : willvi
 * @Description:
 */
@ApiModel
public class ApiError {
    @ApiModelProperty(value = "123")
    String code;
    String deleloperMessage;
    String message;
    String status;
}
