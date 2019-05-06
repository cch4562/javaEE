package com.springmvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("hello")
    public ModelAndView helloController(){
        System.out.println("helloSpringmvc");
        //创建ModelAndView对象
        ModelAndView mav=new ModelAndView();
        //设置模型数据--将后台的信息传递到模型
        mav.addObject("msg","helloThankyou!");
        //设置模型名字---要传递到某个页面
        mav.setViewName("index");
        return mav;
    }
}
