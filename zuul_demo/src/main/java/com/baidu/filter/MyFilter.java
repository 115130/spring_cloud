package com.baidu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取Zuul的上下文对象
        RequestContext context = RequestContext.getCurrentContext();

        // 通过zuul的上下文获取HttpServletRequest对象
        HttpServletRequest request = context.getRequest();

        // 获取请求参数token,参数名称根据实际情况定，不一定叫token
        String token = request.getParameter("token");
        System.out.println("token: " + token);

        if ((token != null) && (token.equals("1234")))
        {
            // 表示验证通过
            return null;
        }
        else
        {
            // 表示验证不通过
            // 设置为false:表示不通过，不再转发请求到目标服务
            context.setSendZuulResponse(false);

            // 401代表用户没有访问权限，需要进行身份认证
            context.setResponseStatusCode(401);

            // 设置响应，表示验证失败的提示信息
            context.setResponseBody("token failed, error");

            return null;
        }
    }
}
