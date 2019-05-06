package com.springmvcDemo.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //记录日志;
        e.printStackTrace();
        //错误消息
        String msg = "很抱歉，系统发生异常了，请联系管理员";
        ModelAndView mav=new ModelAndView();
        //返回错误消息
        mav.addObject("msg", msg);
        //响应错误提示页面
        mav.setViewName("msg");
        return mav;
    }
}
