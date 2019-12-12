package com.xiejinhua.example.server;

import java.util.LinkedList;
import java.util.Map;

import com.xiejinhua.example.entity.DoubleData;
import com.xiejinhua.example.entity.LotteryData;

public interface DoubleService {

	public Object insertDouble(int b1, int b2, int b3, int b4, int b5, int b6, int r);
	
	public Object insertEs(DoubleData data);
	
	public void insertArrayEs(LinkedList<DoubleData> data);
	
	public void insertArray(LinkedList<LotteryData> data);

	public Map<String, Integer> group();

	public LotteryData getLotteryById(String id);

	public void save(LotteryData lottery);

	public void delete(String id);
	
	
}
