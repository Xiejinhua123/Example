package com.xiejinhua.example.config;

import java.io.Serializable;
import java.util.List;

/**
 * u8 其他入库入参
 * 
 * @author 解金化
 * @date 2018.10.26
 * @version 1.0
 */
public class U8_Rdrecord08SaveInParameter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String CVOUCHCODE;//	单号	必填
	private String DDATE;//	入库日期（格式2015-01-01）	必填
	private String CSTORENAME;//	公司（账套号）	必填
	private String CMAKER;//	制单人	必填
	private Double ITAXRATE;//	税率	必填
	private String CWHCODE;//	仓库	必填
	private String CMEMO;//	备注	
	private List<U8_Rdrecord08SaveInParameterDetail> DETAILLIST;//	其他入库单明细list
	
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
	public String getCMAKER() {
		return CMAKER;
	}
	public void setCMAKER(String cMAKER) {
		CMAKER = cMAKER;
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
	public String getCMEMO() {
		return CMEMO;
	}
	public void setCMEMO(String cMEMO) {
		CMEMO = cMEMO;
	}
	public List<U8_Rdrecord08SaveInParameterDetail> getDETAILLIST() {
		return DETAILLIST;
	}
	public void setDETAILLIST(List<U8_Rdrecord08SaveInParameterDetail> dETAILLIST) {
		DETAILLIST = dETAILLIST;
	}
}

/**
 * u8 其他入单入参 详情信息
 * 
 * @author 解金化
 * @date 2018.10.26
 * @version 1.0
 *
 */
class U8_Rdrecord08SaveInParameterDetail {

	private String CINVCODE;//	存货编码	必填
	private String CBATCH;//	批号	
	private String ITAXRATE;//	税率	必填
	private String DMADEDATE;//	生产日期（格式2018-01-01）	必填
	private Double IAMOUNT;//	含税金额	必填
	private Double IQUANTITY;//	数量	必填
	
	public String getCINVCODE() {
		return CINVCODE;
	}
	public void setCINVCODE(String cINVCODE) {
		CINVCODE = cINVCODE;
	}
	public String getCBATCH() {
		return CBATCH;
	}
	public void setCBATCH(String cBATCH) {
		CBATCH = cBATCH;
	}
	public String getITAXRATE() {
		return ITAXRATE;
	}
	public void setITAXRATE(String iTAXRATE) {
		ITAXRATE = iTAXRATE;
	}
	public String getDMADEDATE() {
		return DMADEDATE;
	}
	public void setDMADEDATE(String dMADEDATE) {
		DMADEDATE = dMADEDATE;
	}
	public Double getIAMOUNT() {
		return IAMOUNT;
	}
	public void setIAMOUNT(Double iAMOUNT) {
		IAMOUNT = iAMOUNT;
	}
	public Double getIQUANTITY() {
		return IQUANTITY;
	}
	public void setIQUANTITY(Double iQUANTITY) {
		IQUANTITY = iQUANTITY;
	}
}