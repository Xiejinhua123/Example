package com.xiejinhua.example.server.feign.fallback;

import org.springframework.stereotype.Component;

import com.xiejinhua.example.server.feign.DoubleQiuFeignService;

@Component
public class DoubleQiuFeignServiceFallback implements DoubleQiuFeignService {

	@Override
	public String getResult() throws Exception {
		return "请求错误";
	}

}
