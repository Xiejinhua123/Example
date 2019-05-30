package com.xiejinhua.example.config;

public class U8CommonResponse {

	private String result;//	成功T，失败F
	private String description;// 失败原因
	private String receiptNo;//	单号
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
}
