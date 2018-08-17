package cn.net.dubboproviderdemo.service;

import cn.starnet.Hi;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;


@Service(interfaceClass = Hi.class)
public class DefaultDemoService implements Hi {

    @Value("${server.port}")
    private int port;

    @Override
    public String sayHi(String name) {
        return "Hi, " +name + " port:" + port;
    }
}
