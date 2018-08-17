package cn.net.dubboproviderdemo.redis;


import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class ObjectRedisTemplate extends RedisTemplate<String, Object> {

    public ObjectRedisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        ObjectRedisSerializer objectRedisSerializer = new ObjectRedisSerializer();
        this.setKeySerializer(stringSerializer);
        this.setValueSerializer(objectRedisSerializer);
        this.setHashKeySerializer(stringSerializer);
        this.setHashValueSerializer(objectRedisSerializer);
    }


    public ObjectRedisTemplate(RedisConnectionFactory connectionFactory) {
        this();
        this.setConnectionFactory(connectionFactory);
        this.afterPropertiesSet();
    }

    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        return new DefaultStringRedisConnection(connection);
    }
}
