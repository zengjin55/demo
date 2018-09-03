package com.essa.framework;

/**
 * @author Administrator
 *pojo对象，用于存储一些运行过程中的变量
 */
public class Model {

	public static String skuNo;//商品编号
	public static String buyerNo;//采购商编号
	public static String supplierName;//供应商名称
	public static String picPath;//图片路径
	public static String email = "buyer"+Tools.getTime()+"@essa.cn";//采购商邮箱
	public static String invateCode;//邀请码
	public static String env;//所选环境
	public static String buyerAccount;//采购商账号
	public static String buyerPassword;//采购商密码
	public static String poNum;//po单号
	public static int isactivity;//是否是活动商品 1：是 0：否 
	
	
	public static int getIsactivity() {
		return isactivity;
	}

	public static void setIsactivity(int isactivity) {
		Model.isactivity = isactivity;
	}

	public static String getPoNum() {
		return poNum;
	}

	public static void setPoNum(String poNum) {
		Model.poNum = poNum;
	}

	public static String getBuyerAccount() {
		return buyerAccount;
	}

	public static void setBuyerAccount(String buyerAccount) {
		Model.buyerAccount = buyerAccount;
	}

	public static String getBuyerPassword() {
		return buyerPassword;
	}

	public static void setBuyerPassword(String buyerPassword) {
		Model.buyerPassword = buyerPassword;
	}

	public static String getEnv() {
		return env;
	}

	public static void setEnv(String env) {
		Model.env = env;
	}

	public static String getInvateCode() {
		return invateCode;
	}

	public static void setInvateCode(String invateCode) {
		Model.invateCode = invateCode;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Model.email = email;
	}

	public static String getPicPath() {
		return picPath;
	}

	public static void setPicPath(String picPath) {
		Model.picPath = picPath;
	}

	public static String getSupplierName() {
		return supplierName;
	}

	public static void setSupplierName(String supplierName) {
		Model.supplierName = supplierName;
	}

	public static String getBuyerNo() {
		return buyerNo;
	}

	public static void setBuyerNo(String buyerNo) {
		Model.buyerNo = buyerNo;
	}

	public static String getSkuNo() {
		return skuNo;
	}

	public static void setSkuNo(String No) {
		skuNo = No;
	}
	
}
