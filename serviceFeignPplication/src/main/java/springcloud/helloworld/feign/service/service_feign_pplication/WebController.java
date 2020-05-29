package springcloud.helloworld.feign.service.service_feign_pplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    HelloWorldService helloWorldService;
    //出现警告，因为注入的类型有其他的实现类
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return helloWorldService.sagHello();
    }
}
