package cn.net.dubboconsumerdemo.service;


import cn.starnet.PortInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(interfaceClass = PortInfo.class)
public class DemoPortInfo implements PortInfo {

    @Value("${server.port}")
    private int p;

    @Override
    public int port(int i) {
        return p + i;
    }
}
