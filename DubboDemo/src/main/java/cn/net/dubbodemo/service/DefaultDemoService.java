package cn.net.dubbodemo.service;

public class DefaultDemoService implements DemoService {
    @Override
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
