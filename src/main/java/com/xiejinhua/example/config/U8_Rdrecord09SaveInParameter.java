package com.xiejinhua.example.config;

import java.io.Serializable;
import java.util.List;

/**
 * u8 其他出库单 入参
 * @author 解金化
 * @date 2018.10.26
 * @version 1.0
 *
 */
public class U8_Rdrecord09SaveInParameter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String CVOUCHCODE;//	单号	必填
	private String DDATE;//	出库日期（格式2015-01-01）	必填
	private String CSTORENAME;//	公司（账套号）	必填
	private Double ITAXRATE;//	税率	必填
	private String CWHCODE;//	仓库	必填
	private String CMAKER;//	制单人	
	private String CMEMO;//	备注	
	private List<U8_Rdrecord09SaveInParameterDetail> DETAILLIST;//	其他出库单明细list
	public String getCVOUCHCODE() {
		return CVOUCHCODE;
	}
	public void setCVOUCHCODE(String cVOUCHCODE) {
		CVOUCHCODE = cVOUCHCODE;
	}
	public String getDDATE() {
		return DDATE;
	}
	public void setDDATE(String dDATE) {
		DDATE = dDATE;
	}
	public String getCSTORENAME() {
		return CSTORENAME;
	}
	public void setCSTORENAME(String cSTORENAME) {
		CSTORENAME = cSTORENAME;
	}
	public Double getITAXRATE() {
		return ITAXRATE;
	}
	public void setITAXRATE(Double iTAXRATE) {
		ITAXRATE = iTAXRATE;
	}
	public String getCWHCODE() {
		return CWHCODE;
	}
	public void setCWHCODE(String cWHCODE) {
		CWHCODE = cWHCODE;
	}
	public String getCMAKER() {
		return CMAKER;
	}
	public void setCMAKER(String cMAKER) {
		CMAKER = cMAKER;
	}
	public String getCMEMO() {
		return CMEMO;
	}
	public void setCMEMO(String cMEMO) {
		CMEMO = cMEMO;
	}
	public List<U8_Rdrecord09SaveInParameterDetail> getDETAILLIST() {
		return DETAILLIST;
	}
	public void setDETAILLIST(List<U8_Rdrecord09SaveInParameterDetail> dETAILLIST) {
		DETAILLIST = dETAILLIST;
	}
}

/**
 * U8 其他出库单详情
 * 
 * @author 解金化
 * @date 2018.10.26
 * @version 1.0
 *
 */
class U8_Rdrecord09SaveInParameterDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String CINVCODE;//	存货编码	必填
	private Double IQUANTITY;//	数量	必填
	private String CBATCH;//	批号	
	private String DMADEDATE;//	生产日期（格式2018-01-01）	必填
	private Double ITAXRATE;//	税率	必填
	private Double IAMOUNT;//	含税金额	
	
	public String getCINVCODE() {
		return CINVCODE;
	}
	public void setCINVCODE(String cINVCODE) {
		CINVCODE = cINVCODE;
	}
	public Double getIQUANTITY() {
		return IQUANTITY;
	}
	public void setIQUANTITY(Double iQUANTITY) {
		IQUANTITY = iQUANTITY;
	}
	public String getCBATCH() {
		return CBATCH;
	}
	public void setCBATCH(String cBATCH) {
		CBATCH = cBATCH;
	}
	public String getDMADEDATE() {
		return DMADEDATE;
	}
	public void setDMADEDATE(String dMADEDATE) {
		DMADEDATE = dMADEDATE;
	}
	public Double getITAXRATE() {
		return ITAXRATE;
	}
	public void setITAXRATE(Double iTAXRATE) {
		ITAXRATE = iTAXRATE;
	}
	public Double getIAMOUNT() {
		return IAMOUNT;
	}
	public void setIAMOUNT(Double iAMOUNT) {
		IAMOUNT = iAMOUNT;
	}
}