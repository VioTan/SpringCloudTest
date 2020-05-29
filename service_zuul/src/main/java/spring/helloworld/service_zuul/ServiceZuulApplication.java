package spring.helloworld.service_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
@EnableZuulProxy
/*zuul路由网关注解 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulServer
public class ServiceZuulApplication {
/*
*  将/api-feign/**映射到我们之前创建feign-service,
*  将/api-ribbon/**映射到之前的ribbon-service服务。
* */
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

}
