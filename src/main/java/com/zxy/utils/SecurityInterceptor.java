package com.zxy.utils;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequiresGuest methodAnnotation = handlerMethod.getMethodAnnotation(RequiresGuest.class);
        if(methodAnnotation!=null){
            return true;
        }else{
            Class<?> beanType = handlerMethod.getBeanType();
            RequiresGuest classAnnotation = beanType.getAnnotation(RequiresGuest.class);
            if(classAnnotation != null){
                return true;
            }
        }
        return true;
    }
}
