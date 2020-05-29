package serviceribbon.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
/*向服务中心注册，并且注册了一个叫restTemplate的bean*/
@SpringBootApplication

@EnableHystrixDashboard
/*断路器指标数据监控*/
@EnableCircuitBreaker
/*在Ribbon应用中使用断路器*/

public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    /*注册表明，这个restRemplate是需要做负载均衡的*/
    RestTemplate restTemplate(){
       return new RestTemplate();
    }

}
