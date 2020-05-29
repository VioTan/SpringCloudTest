package serviceribbon.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /*@HystrixCommand注解标注访问服务   */
     /*封装了getHelloContant()方法， 当它访问的SERVICE-HELLOWORLD失败达到阀值后，
     *将不会再调用SERVICE-HELLOWORLD， 取而代之的是返回由fallbackMethod定义的方法serviceFailure（）。*/
     /*断路器返回，注意点，配置需要一致*/
    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent(){
        /*restTemplate.getForObject方法会通过ribbon负载均衡机制， 自动选择一个Hello word服务*/
        return restTemplate.getForObject("http://service-helloworld/",String.class);
    }

    public  String serviceFailure(){
        return "hello world service is not available !";
    }
}
