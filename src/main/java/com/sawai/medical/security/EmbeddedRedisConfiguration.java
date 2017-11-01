package com.sawai.medical.security;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

@Configuration 
@EnableRedisHttpSession
public class EmbeddedRedisConfiguration {
    private static  RedisServer redisServer;
    private static JedisConnectionFactory connectionFactory=null;
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Bean
    public JedisConnectionFactory connectionFactory() throws IOException, URISyntaxException {
    	redisServer = new RedisServer(Protocol.DEFAULT_PORT);
    	try {
    		redisServer.start();
    	} catch(Exception e){}
    		connectionFactory=new JedisConnectionFactory();
    		return connectionFactory;
    }
    
    @PreDestroy
    public void destroy() throws Exception {
    	redisServer.stop();
    	redisServer.start();
    }
}
