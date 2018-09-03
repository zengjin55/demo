package com.buyer.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;

/**
 * @author Administrator
 *设置贴纸页
 */
public class SettingStickerPage extends BasePage {
	public SettingStickerPage(WebDriver driver) {
		super(driver);
	}
	//不应用贴纸
	@FindBy (xpath ="//*[@title='No stickers for these products']")
	WebElement noNeedSticker;
	
	//下一步
	@FindBy (xpath ="//*[text()='Next step']")
	WebElement next;
	
	//弹框提示-确定
	@FindBy (xpath ="//*[text()='OK']")
	WebElement ok;
	
	/**
	 * 设置贴纸：不应用贴纸
	 * @return OrderPreviewPage
	 */
	public OrderPreviewPage setSticker() {
		while (!(isVisibility(By.xpath("//*[@title='No stickers for these products']")))) {
			forceWait(1000);
		}
		click(noNeedSticker);
		click(next);
		click(ok);
		return new OrderPreviewPage(driver);
	}
}
