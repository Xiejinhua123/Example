package com.xiejinhua.example.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 自定义 线程池 配置为bean
 * 
 * @author 解金化
 * @date 2019年6月24日
 * @update 解金化
 * @version 1.0
 */
@Configuration
public class TreadPoolConfig {

	/**
	 * 消费队列线程
	 * 
	 * @return
	 */
	@Bean(value = "xiejinhuaThreadPool")
	public ExecutorService buildConsumerQueueThreadPool() {
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("xiejinhua-thread_pool-%d").build();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), namedThreadFactory);
		return pool;
	}

}
