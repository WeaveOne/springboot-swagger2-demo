package cn.willvi.springbootswaggerdemo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program : springboot-swagger-demo
 * @Date : 2018/9/18 10:24
 * @Author : willvi
 * @Description:
 */
// 描述一个Model的信息
@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @ApiModelProperty(value = "姓名",name = "name")
    String name;
    int age;
}
