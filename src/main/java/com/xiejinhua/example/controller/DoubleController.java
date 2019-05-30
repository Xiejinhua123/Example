package com.xiejinhua.example.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiejinhua.example.entity.Double;
import com.xiejinhua.example.server.DoubleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/double")
public class DoubleController {
	@Autowired
	private DoubleService service;

	@GetMapping("/putDouble")
	@ApiOperation("添加测试数据")
	public void putDouble() {
		long start = System.currentTimeMillis();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(150, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), Executors.defaultThreadFactory());
		int i = 0;
		int blue = 33;
		int red = 16;
		for (int b1 = 1; b1 <= blue; b1++) {
			if (b1 > 28 || b1 < 1)
				continue;
			for (int b2 = 1; b2 <= blue; b2++) {
				if (b2 > 29 || b2 < 2)
					continue;
				for (int b3 = 1; b3 <= blue; b3++) {
					if (b3 > 30 || b3 < 3)
						continue;
					for (int b4 = 1; b4 <= blue; b4++) {
						if (b4 > 31 || b4 < 4)
							continue;
						for (int b5 = 1; b5 <= blue; b5++) {
							if (b5 > 32 || b5 < 5)
								continue;
							for (int b6 = 1; b6 <= blue; b6++) {
								if (b6 < 6)
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
									i++;
//									pool.execute(() -> service.insertDouble(b1f,b2f,b3f,b4f,b5f,b6f,rf));
//									if (++i % 50 == 0)
//										try {
//											Thread.sleep(3000);
//										} catch (InterruptedException e) {
//											e.printStackTrace();
//										}
								}
							}
						}
					}
				}
			}
		}
		long start1 = System.currentTimeMillis();
		System.out.println(start1 - start);
		System.out.println(i);
	}

}
