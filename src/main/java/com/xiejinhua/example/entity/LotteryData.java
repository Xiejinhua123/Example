package com.xiejinhua.example.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "lottery",type = "lottery")
public class LotteryData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Field(index = true)
    private Integer b1;
	
	@Field(index = true)
    private Integer b2;
	
	@Field(index = true)
    private Integer b3;
	
	@Field(index = true)
    private Integer b4;
	
	@Field(index = true)
    private Integer b5;
	
	@Field(index = true)
    private Integer b6;
	
	@Field(index = true)
    private Integer r1;

	public Integer getB1() {
		return b1;
	}

	public void setB1(Integer b1) {
		this.b1 = b1;
	}

	public Integer getB2() {
		return b2;
	}

	public void setB2(Integer b2) {
		this.b2 = b2;
	}

	public Integer getB3() {
		return b3;
	}

	public void setB3(Integer b3) {
		this.b3 = b3;
	}

	public Integer getB4() {
		return b4;
	}

	public void setB4(Integer b4) {
		this.b4 = b4;
	}

	public Integer getB5() {
		return b5;
	}

	public void setB5(Integer b5) {
		this.b5 = b5;
	}

	public Integer getB6() {
		return b6;
	}

	public void setB6(Integer b6) {
		this.b6 = b6;
	}

	public Integer getR1() {
		return r1;
	}

	public void setR1(Integer r1) {
		this.r1 = r1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}