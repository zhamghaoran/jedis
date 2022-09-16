package com.zhrf.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        //创建一个jedis对线
        String ping;
        Jedis jedis = new Jedis("localhost", 6379);
        // 测试
        //String
        jedis.mset("str1","v1","str2","v2");
        System.out.println(jedis.mget("str1","str2","str3"));
        // List
        jedis.lpush("mylist","1","2","3","4","5","6");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // set
        jedis.sadd("orders","order00");
        jedis.sadd("orders","order01");
        jedis.sadd("orders","order02");
        jedis.sadd("orders","order03");
        Set<String> orders = jedis.smembers("orders");
        System.out.println(orders);

        //hash
        jedis.hset("hash1","username","lisi");
        System.out.println(jedis.hget("hash1","username"));
        HashMap<String , String > map = new HashMap<>();
        map.put("telephone","123456789");
        map.put("address","12316454512");
        map.put("asfgasg","ashjaiskrh");
        jedis.hmset("hash2",map);
        List<String> hmget = jedis.hmget("hash2", "telephone", "asfgasg");
        System.out.println(hmget);
        //zset
        jedis.zadd("test1", 0d,"cai");
        jedis.zadd("test1", 100d,"abc");
        jedis.zadd("test1",90d,"xiaozhang");
        Set<String> test1 = jedis.zrange("test1", 0, -1);
        System.out.println(test1);
        jedis.flushDB();
    }
}
