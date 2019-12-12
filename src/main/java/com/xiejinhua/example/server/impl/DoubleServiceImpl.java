package com.xiejinhua.example.server.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiejinhua.example.dao.DoubleDataDao;
import com.xiejinhua.example.dao.DoubleDataZDao;
import com.xiejinhua.example.dao.DoubleMapper;
import com.xiejinhua.example.entity.DoubleData;
import com.xiejinhua.example.entity.LotteryData;
import com.xiejinhua.example.server.DoubleService;

@Service
public class DoubleServiceImpl implements DoubleService {

	@Autowired
	private DoubleMapper doubleMapper;

	@Autowired(required=true)
	private DoubleDataDao dao;
	
	@Autowired(required=true)
	private DoubleDataZDao zdao;

	@Override
	public Object insertDouble(int b1, int b2, int b3, int b4, int b5, int b6, int r) {
		return this.doubleMapper.insertDouble(b1, b2, b3, b4, b5, b6, r);
	}

	@Override
	public Object insertEs(DoubleData data) {
		this.dao.save(data);
		return null;
	}

	@Override
	public void insertArrayEs(LinkedList<DoubleData> data) {
		this.dao.saveAll(data);
	}

	@Override
	public void insertArray(LinkedList<LotteryData> data) {
		this.zdao.saveAll(data);		
	}

	@Override
	public Map<String, Integer> group() {
		Iterator<LotteryData> iterator = this.zdao.findAll().iterator();
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		while (iterator.hasNext()) {
			LotteryData data = (LotteryData) iterator.next();
			if (map.containsKey(data.getId())) {
				map.put(data.getId(), map.get(data.getId())+1);
			}else {
				map.put(data.getId(), 1);
			}
		}
		return map;
	}

	@Override
	public LotteryData getLotteryById(String id) {
		Optional<LotteryData> option = this.zdao.findById(id);
		return option.isPresent() ? option.get():null;
	}

	@Override
	public void save(LotteryData lottery) {
		this.zdao.save(lottery);
	}
	
	@Override
	public void delete( String id ) {
		this.zdao.deleteById(id);
	}

}
