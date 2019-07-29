package com.xiejinhua.example.server;

import java.util.LinkedList;

import com.xiejinhua.example.entity.DoubleData;

public interface DoubleService {

	public Object insertDouble(int b1, int b2, int b3, int b4, int b5, int b6, int r);
	
	public Object insertEs(DoubleData data);
	
	public void insertArrayEs(LinkedList<DoubleData> data);
	
	
}
