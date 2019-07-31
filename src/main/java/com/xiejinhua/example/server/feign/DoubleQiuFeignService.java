package com.xiejinhua.example.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.xiejinhua.example.server.feign.fallback.DoubleQiuFeignServiceFallback;

import feign.Headers;

@FeignClient(value="DoubleQiuFeignService", url="http://www.cwl.gov.cn", fallback=DoubleQiuFeignServiceFallback.class)
public interface DoubleQiuFeignService {

	@GetMapping(value="/cwl_admin/kjxx/findDrawNotice?name=ssq&issueCount=5")
    @Headers({ "Referer : http://www.cwl.gov.cn/kjxx/ssq/" })
	public String getResult() throws Exception;

}
