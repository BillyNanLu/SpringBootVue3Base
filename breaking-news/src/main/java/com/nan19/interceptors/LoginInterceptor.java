package com.nan19.interceptors;

import com.nan19.pojo.Result;
import com.nan19.utils.JwtUtil;
import com.nan19.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        // TODO: token校验
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);

            // 把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 校验通过
            return true;
        } catch (Exception e) {
            // http状态码 401
            response.setStatus(401);
            // 校验失败
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO: 清理ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
