package com.jwell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yb
 * @date 2020-12-01 09:19
 */
@Controller
@RequestMapping("/sys")
public class HelloController {

        @RequestMapping(value = "/hello" ,produces = "text/json;charset=utf-8",method = RequestMethod.GET)
        @ResponseBody
        public String sayHello(){
            System.out.println("你大爷的");
            return "嘿嘿";
        }


}
