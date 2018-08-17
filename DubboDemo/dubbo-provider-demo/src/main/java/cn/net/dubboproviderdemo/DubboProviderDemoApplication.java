package cn.net.dubboproviderdemo;



import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDubbo
//@MapperScan("cn.net.dubboproviderdemo.dao")
public class DubboProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderDemoApplication.class, args);

    }
}
