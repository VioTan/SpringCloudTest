package spring.helloworld.service_zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class DemoFilter extends ZuulFilter {

    private  static Logger log=  log = LoggerFactory.getLogger(DemoFilter.class);

    @Override
    public String filterType() {
        /*返回1个字符串代表1个过滤器的类型，定义了四种不同生命周几的
        * pre: 路由之前
        * routing: 路由之时
        * post: 路由之后
        * error: 发送错误调用
        * */

        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤的优先级数字越大，优先级越大
        return 0;
    }

    public boolean shouldFilter() {
        //shouldFilter，可以写判断逻辑，true，表示永远过滤
        return true;
    }

    public Object run() {
        //过滤器的具体逻辑，这里简单的将请求的URL写到日志中
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s",request.getMethod(),request.getRequestURI().toString());
        log.info(s);
        return null;
    }
}
