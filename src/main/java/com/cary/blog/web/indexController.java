package com.cary.blog.web;
import com.cary.blog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
//        int i=9/0;
//        String blog =null;
        //如果博客不存在，抛出自定义的NotFound异常，这个异常带有注解，在handler中我们规定
        //不去拦截带有@ResponseStatus的异常，使用springboot默认碰到runtime异常跳转到404
//        if(blog ==null){
//            throw new NotFoundException("博客不存在");
//        }
//        System.out.println("--------index---------");
        return "index";
    }


    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
