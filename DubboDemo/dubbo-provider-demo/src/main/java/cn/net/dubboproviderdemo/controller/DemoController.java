package cn.net.dubboproviderdemo.controller;



import cn.net.dubboproviderdemo.model.Person;
import cn.net.dubboproviderdemo.model.Reply;
import cn.net.dubboproviderdemo.service.RedisManagement;
import cn.net.dubboproviderdemo.service.TestService;
import cn.starnet.PortInfo;
import com.alibaba.dubbo.config.annotation.Reference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @Reference
    private PortInfo portInfo;

    @Autowired
    private TestService testService;

    @Autowired
    private RedisManagement redisManagement;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String getInfo(@RequestParam String name){
        int port = portInfo.port(0);
        System.out.println(port);

        return name + "I am from port:" + port;

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Person getPerson(@RequestParam int id){
        return testService.getPerson(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPerson(@RequestParam int id, @RequestParam String username, @RequestParam int age, @RequestParam String sex){
        Person person = new Person(id, username, age, sex);
        testService.addPerson(person);
         return "<<=====add=====>>\n" + person;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePerson(@RequestParam int id, @RequestParam String username, @RequestParam int age, @RequestParam String sex){
        Person person = new Person(id, username, age, sex);
        testService.updatePerson(person);
        return "<<=====update=====>>\n" + person;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePerson(@RequestParam int id){
        testService.deletePerson(id);
        return "<<=====delete=====>>\n";
    }

    @RequestMapping("/setSession")
    public Reply setSession(@RequestParam("key")String key, @RequestParam("value")String value, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        Map<String,Object> info = new HashMap<>();
        info.put("status", "success");
        info.put("key", key);
        info.put("value", value);
        Reply reply = new Reply("SetSession", info);
        return reply;
    }

    @RequestMapping("/getSession")
    public Reply getSession(@RequestParam("key")String key, HttpServletRequest request){
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(key);
        Map<String,Object> info = new HashMap<>();
        info.put("status", "success");
        info.put("key", key);
        info.put("value", value);
        Reply reply = new Reply("getSession", info);
        return reply;
    }

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public Reply set(@RequestParam int id){

        Person person = new Person(id, "李哥", 100,"男");
        redisManagement.set(String.valueOf(id), person);
        Map<String,Object> info = new HashMap<>();
        info.put("status", "success");
        info.put("key", id);
        info.put("value", person);
        Reply reply = new Reply("set", info);
        return reply;
    }

    @RequestMapping("/get")
    public Reply get(@RequestParam("name")String id){
        Person person = (Person) redisManagement.get(id);
        Map<String,Object> info = new HashMap<>();
        info.put("status", "success");
        info.put("key", id);
        info.put("value", person.getId());
        Reply reply = new Reply("get", info);
        return reply;


    }

}
