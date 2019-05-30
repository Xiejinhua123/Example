package com.xiejinhua.example.entity;

public class Double {
	private int b1;
	private int b2;
	private int b3;
	private int b4;
	private int b5;
	private int b6;
	private int r;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append(b1 + ",");
		sb.append(b2 + ",");
		sb.append(b3 + ",");
		sb.append(b4 + ",");
		sb.append(b5 + ",");
		sb.append(b6 + ",");
		sb.append(r);
		sb.append("]");
		return sb.toString();
	}
	
	public int getB1() {
		return b1;
	}
	public void setB1(int b1) {
		this.b1 = b1;
	}
	public int getB2() {
		return b2;
	}
	public void setB2(int b2) {
		this.b2 = b2;
	}
	public int getB3() {
		return b3;
	}
	public void setB3(int b3) {
		this.b3 = b3;
	}
	public int getB4() {
		return b4;
	}
	public void setB4(int b4) {
		this.b4 = b4;
	}
	public int getB5() {
		return b5;
	}
	public void setB5(int b5) {
		this.b5 = b5;
	}
	public int getB6() {
		return b6;
	}
	public void setB6(int b6) {
		this.b6 = b6;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
}
