package com.xiejinhua.example.controller;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xiejinhua.example.server.UserServer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
public class TestController {

	private Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired private UserServer userServer;
	
	@Autowired private StringRedisTemplate redisTemplate;
	
//	@Autowired private RedisSentinelConfiguration redisSentinelConfiguration;
	
	@Autowired private RestTemplate restTemplate;
	
	@ApiOperation("添加测试数据")
	@PostMapping("/add")
	public String add( @RequestParam("name") String name ) {
		if ( name == null || name.length() <= 0 )
			return "添加失败1";
		else {
			try {
				int count = this.userServer.insert(name);
				if ( count <= 0 )
					return "添加失败2";
				else
					return "添加成功";
			} catch (Exception e) {
				e.printStackTrace();
				log.info("添加员工失败：-------------" + e.getMessage() );
				return "添加失败3";
			}
		}
	}
	
	@ApiOperation("获取总数量")
	@GetMapping("/getCount")
	public int getCount() {
		
		Integer count = this.userServer.getUserCount();
		if ( count == null )
			return 0;
		else
			return count;
	}
	
	@ApiOperation("测试redis")
	@GetMapping("/redisGet")
	public String redisGet() {
		long old = System.currentTimeMillis();
		this.redisTemplate.expire("a0", 500, TimeUnit.SECONDS);
		long old1 = System.currentTimeMillis();
		String a = (String) this.redisTemplate.opsForValue().get("a0");
		System.out.println(a);
		long old2 = System.currentTimeMillis();
		System.out.println("休眠耗时	：" + (old1-old));
		System.out.println("获取耗时	：" + (old2 - old1));
		System.out.println("总耗	时	：" + (old2 - old));
		return a;
	}
	
	
	@ApiOperation("向redis中添加1000000key")
	@GetMapping("/addRedis")
	public void addRedis() {
//		this.redisSentinelConfiguration.setDatabase(10);
		for( int i = 0; i < 10; i++ ) {
			this.redisTemplate.opsForValue().set("a" + i, "15a" + i);
		}
	}
	
	@ApiOperation("测试springboot servlet线程")
	@GetMapping("/testThread")
	public void testThread() {
		System.out.println("当前线程：" + Thread.currentThread().getName());
	}
	
	@ApiOperation("测试resttemplate")
	@GetMapping("/testRestTemplate")
	public void testRestTemplate() {
		String a = this.restTemplate.getForObject("http://127.0.0.1:8188/example/test/redisGet", String.class);
		System.out.println(a);
	}
	
	@ApiOperation("测试json封装后返回")
	@GetMapping("/testRestfull")
	public String testRestfull() {
		String result = this.restTemplate.getForObject("http://www.kuaidi100.com/query?type=yuantong&postid=11111111111", String.class);
		return result;
	}
}
