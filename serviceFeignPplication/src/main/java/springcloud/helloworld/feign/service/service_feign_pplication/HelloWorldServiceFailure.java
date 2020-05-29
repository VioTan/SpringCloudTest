package springcloud.helloworld.feign.service.service_feign_pplication;

import org.springframework.stereotype.Component;

/*Feign应用中使用断路器*/
@Component
public class HelloWorldServiceFailure implements  HelloWorldService {
    @Override
    public String sagHello() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available -- Feign !";
    }
}
