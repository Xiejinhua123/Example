package com.xiejinhua.example.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiejinhua.example.dao.DoubleMapper;
import com.xiejinhua.example.server.DoubleService;

@Service
public class DoubleServiceImpl implements DoubleService {

	@Autowired private DoubleMapper doubleMapper;

	@Override
	public Object insertDouble(int b1, int b2, int b3, int b4, int b5, int b6, int r) {
		return this.doubleMapper.insertDouble(b1,b2,b3,b4,b5,b6,r);
	}
	
}
