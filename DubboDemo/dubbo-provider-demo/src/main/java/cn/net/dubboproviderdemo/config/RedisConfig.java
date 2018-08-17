package cn.net.dubboproviderdemo.config;



import cn.net.dubboproviderdemo.redis.ObjectRedisTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;


@Configuration
public class RedisConfig {


    @Bean
    public ObjectRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new ObjectRedisTemplate(redisConnectionFactory);
    }

}
