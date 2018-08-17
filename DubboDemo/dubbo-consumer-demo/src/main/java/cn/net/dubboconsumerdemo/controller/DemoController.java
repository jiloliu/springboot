package cn.net.dubboconsumerdemo.controller;


import cn.starnet.Hi;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference
    private Hi demoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello docker!!";
    }

    @RequestMapping(value = "/sayHi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){

        return demoService.sayHi(name);
    }

}
