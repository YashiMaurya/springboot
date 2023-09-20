package com.jpa.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @RequestMapping("/test")
    public  String test(){
        int a=90;
        int b=79;
        int v=70;
        return "this is just testing sum of a and b ,c is "+ (a+b+v);
    }

}
