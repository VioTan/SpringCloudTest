package springcloud.helloworld.feign.service.service_feign_pplication;

import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/*用于通知Feign组件对该接口进行代理(不需要编写接口实现)，使用者可直接通过@Autowired注入; 该接口通过value定义了需要
调用的SERVICE-HELLOWORLD服务（通过服务中心自动发现机制会定位具体URL）; @RequestMapping定义了Feign需要
访问的SERVICE-HELLOWORLD服务的URL*/
/*@ FeignClient（“服务名”），来指定调用哪个服务，使用的接口*/
@FeignClient(value = "service-helloworld", fallback = HelloWorldServiceFailure.class)
public interface HelloWorldService {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String sagHello();
}

