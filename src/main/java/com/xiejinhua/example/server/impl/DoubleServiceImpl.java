package com.xiejinhua.example.server.impl;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiejinhua.example.dao.DoubleDataDao;
import com.xiejinhua.example.dao.DoubleMapper;
import com.xiejinhua.example.entity.DoubleData;
import com.xiejinhua.example.server.DoubleService;

@Service
public class DoubleServiceImpl implements DoubleService {

	@Autowired
	private DoubleMapper doubleMapper;

	@Autowired(required=true)
	private DoubleDataDao dao;

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

}
