package com.guoxin.common.util;

import org.apache.log4j.Logger;
import org.mybatis.caches.redis.ConfigWithHost;
import org.mybatis.caches.redis.RedisConfigurationBuilder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis连接池工厂
 * @author Rocye
 * @createTime 2015-05-22
 */
public class RedisConnectionFactory {
    private final static Logger logger = Logger.getLogger(RedisConnectionFactory.class.getName());
    
    private static JedisPool pool = null;
    private static int _dbNum = 0;
    
    public synchronized static JedisPool getPool(){
        if(pool == null){
            ConfigWithHost conf = RedisConfigurationBuilder.getInstance().parseConfiguration();
            _dbNum = conf.getDbnum();
            if(conf.getPass() == null){
                pool = new JedisPool(conf, conf.getHost(), conf.getPort(), conf.getTimeout());
            }else{
                pool = new JedisPool(conf, conf.getHost(), conf.getPort(), conf.getTimeout(), conf.getPass());
            }
        }
        return pool;
    }
    
    public static Jedis getJedisInstance(){
        Jedis jedis = null;
        try {
            getPool();
            if(pool != null){
                jedis = pool.getResource();
                jedis.select(_dbNum);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("从pool中获取链接时：" + ex.toString());
        }
        return jedis;
    }
    
    public static void returnResource(Jedis jedis) {
        if (jedis != null && jedis.isConnected()){
            pool.returnResource(jedis);
        }
    }
    
    public static void returnBrokenResource(Jedis jedis){
        if (jedis != null && jedis.isConnected()){
            pool.returnBrokenResource(jedis);
        }
    }
    
}

