package com.xiejinhua.example.controller;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiejinhua.example.entity.DoubleData;
import com.xiejinhua.example.server.DoubleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/double")
public class DoubleController {
	@Autowired
	private DoubleService service;
	
	@Resource(name="xiejinhuaThreadPool")
	private ExecutorService pool;
	
	@GetMapping("/putDouble")
	@ApiOperation("添加测试数据")
	public void putDouble() {
		LinkedList<DoubleData> datas = new LinkedList<>();
		int blue = 33;
		int red = 16;
		for (int b1 = 1; b1 <= blue; b1++) {
			if (b1 > 28 || b1 < 1)
				continue;
			for (int b2 = 1; b2 <= blue; b2++) {
				if (b2 > 29 || b2 < 2 || b2 < b1)
					continue;
				for (int b3 = 1; b3 <= blue; b3++) {
					if (b3 > 30 || b3 < 3 || b3 < b2)
						continue;
					for (int b4 = 1; b4 <= blue; b4++) {
						if (b4 > 31 || b4 < 4 || b4 < b3)
							continue;
						for (int b5 = 1; b5 <= blue; b5++) {
							if (b5 > 32 || b5 < 5 || b5 < b4)
								continue;
							for (int b6 = 1; b6 <= blue; b6++) {
								if (b6 < 6 || b6 < b5)
									continue;
								Set<Integer> result =  new HashSet<Integer>();
								result.add(b1);
								result.add(b2);
								result.add(b3);
								result.add(b4);
								result.add(b5);
								result.add(b6);
								if (result.size() != 6)
									continue;
								for (int r = 1; r <= red; r++) {
									final int b1f = b1;
									final int b2f = b2;
									final int b3f = b3;
									final int b4f = b4;
									final int b5f = b5;
									final int b6f = b6;
									final int rf = r;
									DoubleData data = new DoubleData();
									StringBuilder sb = new StringBuilder();
									sb.append(b1f);sb.append(b2f);sb.append(b3f);sb.append(b4f);sb.append(b5f);sb.append(b6f);sb.append(rf);
									data.setId( sb.toString() );
									data.setB1(b1f);
									data.setB2(b2f);
									data.setB3(b3f);
									data.setB4(b4f);
									data.setB5(b5f);
									data.setB6(b6f);
									data.setR1(rf);
									datas.add(data);
									if (datas.size() >= 10000) {
//										this.service.insertArrayEs(datas);
										datas.clear();
									}
								}
							}
						}
					}
				}
			}
		}
		if (datas.size() > 0) {
			this.service.insertArrayEs(datas);
		}
	}
}
