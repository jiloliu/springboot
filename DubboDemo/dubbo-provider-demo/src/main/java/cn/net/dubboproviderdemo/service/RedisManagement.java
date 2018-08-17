package cn.net.dubboproviderdemo.service;



import cn.net.dubboproviderdemo.redis.ObjectRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisManagement {

    @Autowired
    private ObjectRedisTemplate objectRedisTemplate;

    public void set(String key, Object value){
        this.objectRedisTemplate.opsForValue().set(key, value);

    }

    public Object get(String key){
        return this.objectRedisTemplate.opsForValue().get(key);
    }

}
