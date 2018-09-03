package com.essa.pageObject.inquiryManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;
import com.essa.framework.Model;

/**
 * @author Administrator
 *成品询价任务列表
 */
public class ProductInquiryTask extends BasePage {
	public ProductInquiryTask(WebDriver driver) {
		super(driver);
	}
	/*
	 * 元素定位
	 */
	//高级查询
	@FindBy (xpath ="//*[contains(text(),'高级查询')]")
	WebElement advancedQuery;
	
	//商品编码查询
	@FindBy (xpath="//*[text()='商品编码']/../div/input")
	WebElement skuNoQuery;
	
	//高级查询-查询按钮
	@FindBy (xpath="//*[@name='advSearch']/div[12]/button[1]")
	WebElement search;
	
	//列表第一行数据
	@FindBy (xpath ="//*[@ng-table='tableParams1']/tbody/tr[1]")
	WebElement firstRow;
	
	//询价反馈
	@FindBy (xpath ="//*[contains(text(),'询价反馈')]")
	WebElement feedBack;
	
	//暂无数据--用于检查是否已经成功
	@FindBy (xpath="//*[text()='暂无数据']")
	WebElement isSucceed;
	/*
	 * 页面方法
	 */
	/**
	 * 查出要成品询价的商品，进入成品询价反馈页面
	 * @return ProductInquiryFeedback
	 */
	public ProductInquiryFeedback toFeedback() {
//		mywait(firstRow);
		click(advancedQuery);
		sendKeys(skuNoQuery, Model.getSkuNo());
		click(search);
		mywait(firstRow);
		click(firstRow);
		click(feedBack);
		return new ProductInquiryFeedback(driver);
	}
	
	/**
	 * 判断页面是否查询不到该商品
	 * @return boolean
	 */
	public boolean isSucceed() {
		click(advancedQuery);
		sendKeys(skuNoQuery, Model.getSkuNo());
		click(search);
		forceWait(1000);
		return isVisibility(By.xpath("//*[text()='暂无数据']"));
	}
}
