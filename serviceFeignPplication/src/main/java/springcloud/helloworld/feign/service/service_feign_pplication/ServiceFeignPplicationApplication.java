package springcloud.helloworld.feign.service.service_feign_pplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

@EnableCircuitBreaker
/*断路器指标必须加注解*/
@EnableHystrixDashboard
/*需要特别注意的是我们之前的Feign服务由于内置断路器支持，
 所以没有@EnableCircuitBreaker注解，但要使用Dashboard则必须加，
 如果不加，Dashboard无法接收到来自Feign内部断路器的监控数据，
 会报“Unable to connect to Command Metric Stream”错误*/

public class ServiceFeignPplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignPplicationApplication.class, args);
    }

}
