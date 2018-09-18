package cn.willvi.springbootswaggerdemo.controller;

import cn.willvi.springbootswaggerdemo.Entity.Person;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program : springboot-swagger-demo
 * @Date : 2018/9/18 9:32
 * @Author : willvi
 * @Description:
 */

/**
 * value                 url路径值（汉化后不起作用） http://xxx/swagger-ui.html#/demo-controller中的 demo-controller即为value
 * tags                  设置这个值、value的值会被覆盖（汉化后有bug最好不写）
 * description           对api资源的描述
 * basePath              基本路径可以不配置
 * position              如果配置多个Api 想改变显示的顺序位置
 * produces              For example, "application/json, application/xml"  页面上的 Response Content Type (响应Content Type)
 * consumes              For example, "application/json, application/xml"
 * protocols             Possible values: http, https, ws, wss.
 * authorizations        高级特性认证时配置
 * hidden                配置为true 将在文档中隐藏
 */
@Api(value = "Swagger 注解使用",description = "123")

@RestController
@RequestMapping("/")


public class DemoController {
    @PostMapping("/postHello")
    /**
     * value               页面tab右侧值
     * tags                如果设置这个值、value的值会被覆盖
     * description         对api资源的描述
     * basePath            基本路径可以不配置
     * position            如果配置多个Api 想改变显示的顺序位置
     * produces            For example, "application/json, application/xml"
     * consumes            For example, "application/json, application/xml"
     * protocols           Possible values: http, https, ws, wss.
     * authorizations      高级特性认证时配置
     * hidden              配置为true 将在文档中隐藏
     * response            返回的对象
     * responseContainer   这些对象是有效的 "List", "Set" or "Map".，其他无效
     * httpMethod  "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" and "PATCH"
     * code                http的状态码 默认 200
     * extensions          扩展属性
     */
    @ApiOperation(
            value = "post",
            notes = "这是一个小demo",
            produces = "application/json",
            response = Person.class
    )
    /**
     * code                http的状态码
     * message             描述
     * response            默认响应类 Void
     * reference           参考ApiOperation中配置
     * responseHeaders     参考 ResponseHeader 属性配置说明
     * responseContainer   参考ApiOperation中配置
     */
    @ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = String.class)})
    public ResponseEntity<Person> postHello(@RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @GetMapping("/hello/{name}")
    @ApiOperation(
            value = "hello world",
            notes = "这是一个小demo"
    )
    /**
     * @ApiImplicitParam
     * 当dataType不是对象时可以使用
     * paramType：参数放在哪个地方
     * name：参数代表的含义
     * value：参数名称
     * dataType： 参数类型，有String/int，无用
     * required ： 是否必要
     * defaultValue：参数的默认值
     */
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name",value = "name",paramType ="path", dataType = "String")
    )
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
}
