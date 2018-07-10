package com.dj.wechat.aspect;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dj.wechat.util.AESUtil;

/**
 * @author guwei
 * @date 2018-07-10
 */
@Aspect
@Configuration
public class RequestParamsAspect {
	
	private static Logger logger = LoggerFactory.getLogger(RequestParamsAspect.class);
	
	// 定义切点 , controller包下所有类的所有方法都被拦截
	@Pointcut("execution(* com.dj.wechat.controller.*.*(..))")
	public void executeController() {
		
	}
	
	// 将第一个参数进行解密
	@Before("executeController()")
	public void  deBefore(JoinPoint joinPoint) throws Throwable{
		 // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();  
//        // 记录下请求内容  
//        System.out.println("URL : " + request.getRequestURL().toString());  
//        System.out.println("HTTP_METHOD : " + request.getMethod());  
//        System.out.println("IP : " + request.getRemoteAddr());  
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        
		//获取第一个参数值
		String params = (String) joinPoint.getArgs()[0];
        
        if(StringUtils.isNotBlank(params)) {
        	params = AESUtil.deCrypt(params);
        	request.setAttribute("params", params);
        }else {
        	request.setAttribute("params", null);
        }
	}
	
}
