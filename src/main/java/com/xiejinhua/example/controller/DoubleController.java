package com.xiejinhua.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.xiejinhua.example.entity.DoubleData;
import com.xiejinhua.example.entity.LotteryData;
import com.xiejinhua.example.server.DoubleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import main.FileUtil;

@RestController
@RequestMapping("/double")
public class DoubleController {
	@Autowired
	private DoubleService service;

	@Resource(name = "xiejinhuaThreadPool")
	private ExecutorService pool;

	@GetMapping("/select")
	@ApiOperation("查询")
	public Map<String, Integer> select() {
		Map<String, Integer> map =  this.service.group();
		return map;
	}
	
	@PutMapping("/inputLottery")
	@ApiOperation("添加某期数据")
	public String inputLottery( @RequestBody LotteryData lottery ) {
		
		if ( lottery == null || StringUtils.isEmpty(lottery.getId()) )
			return "fail: param is error!";
		
		LotteryData data = this.service.getLotteryById( lottery.getId() );
		if ( data == null )
			this.service.save( lottery );
		
		return "success";
	}
	
	@DeleteMapping("/deleteById")
	@ApiOperation("删除某期数据")
	public String deleteById( @ApiParam(name="id", value="主键", required=true) @RequestParam(name="id", required=true) String id ) {
		this.service.delete(id);
		return "success";
	}
	
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
								Set<Integer> result = new HashSet<Integer>();
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
									sb.append(b1f);
									sb.append(b2f);
									sb.append(b3f);
									sb.append(b4f);
									sb.append(b5f);
									sb.append(b6f);
									sb.append(rf);
									data.setId(sb.toString());
									data.setB1(b1f);
									data.setB2(b2f);
									data.setB3(b3f);
									data.setB4(b4f);
									data.setB5(b5f);
									data.setB6(b6f);
									data.setR1(rf);
									datas.add(data);
									if (datas.size() >= 10000) {
										// this.service.insertArrayEs(datas);
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

	@GetMapping("/putDoublez")
	@ApiOperation("添加中奖数据")
	public void putDoublez() {

		File file = new File("D:\\a.html");
		StringBuilder sb = null;
		try {
			sb = FileUtil.readFile(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (sb == null)return;
		String str = sb.toString();
		String[] strs = str.split("<tr");

		LinkedList<LotteryData> jsons = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			if (s == null || s.length() <= 0)
				continue;
			String[] ss = s.split("<td");
			LotteryData data = new LotteryData();
			for (int j = 2; j < 10; j++) {
				String sj = ss[j].replaceFirst("</td", "").replaceAll("class=\"t_cfont2\">", "")
						.replaceAll("class=\"t_cfont4\">", "").replaceAll(" ", "");
				String[] sjs = sj.split(">");
				for (int k = 1; k < sjs.length; k++) {
					data.setId(sjs[k]);
				}
				Integer tmp = null;
				try {
					tmp = Integer.valueOf(sjs[0]);
				} catch (Exception e) {
					continue;
				}
				if (tmp != null)
					switch (j) {
					case 3:
						data.setB1(tmp);
						break;
					case 4:
						data.setB2(tmp);
						break;
					case 5:
						data.setB3(tmp);
						break;
					case 6:
						data.setB4(tmp);
						break;
					case 7:
						data.setB5(tmp);
						break;
					case 8:
						data.setB6(tmp);
						break;
					case 9:
						data.setR1(tmp);
						break;
					}
			}
			jsons.add(data);
		}
		this.service.insertArray(jsons);
	}
}
