package com.essa.pageObject.GoodsManage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;

/**
 * @author Administrator
 *审核原厂商品页面
 */
public class AuditOriginalOpreatePage extends BasePage {
	public AuditOriginalOpreatePage(WebDriver driver) {
		super(driver);
	}
	/*
	 * 元素定位
	 */
	
	//审核通过
	@FindBy(xpath="//*[text()='审核通过']")
	WebElement pass;
	
	//审核通过提示语
	@FindBy(xpath="//*[text()='商品审核已通过'")
	WebElement succeedMessage;
	
	/*
	 * 页面方法
	 */
	
	/**
	 * 挪动滚动条至底部，点击审核通过
	 * @return AuditOriginalGoodsPage
	 */
	public AuditOriginalGoodsPage auditPass() {
		forceWait(2000);
		moveHeightScroll("100");
		click(pass);
		return new AuditOriginalGoodsPage(driver);
	}
	
	/**
	 * 用于断言商品审核是否通过
	 * @return boolean
	 */
	public boolean isSucceed() {
		return isElementExist(succeedMessage);
	}
	
}
