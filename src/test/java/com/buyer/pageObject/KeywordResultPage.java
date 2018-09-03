package com.buyer.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;
import com.essa.framework.Model;

/**
 * 关键字查询结果页
 * @author Administrator
 *
 */
public class KeywordResultPage extends BasePage {
	public KeywordResultPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * 元素定位
	 */
	//加入购物车
	@FindBy (xpath ="//*[@id='product-list']/ul[1]/div[1]/li[1]/div[1]/div[1]/div[4]/div[2]")
	WebElement addToCart;
	
	@FindBy (xpath ="//*[@id='product-list']/ul[1]/div[1]/li[1]/div[2]/div[3]/div[1]")
	WebElement confirmAdd;
	
	//添加购物车时，提示加入一款成功toast
	@FindBy (xpath ="//*[@class='util-bill-pd']")
	WebElement toast;
	
	//右上角购物车
	@FindBy (xpath ="//*[@id='miniCart']")
	WebElement minicart;
	
	//订购量
	@FindBy (xpath="//*[contains(text(),'quantity')]/../span[2]/input")
	WebElement count;
	
	//活动商品-添加购物车
	@FindBy (xpath ="//*[text()='Add to Cart']")
	WebElement addToCart1;
	
	/*
	 * 页面方法
	 */
	/**
	 * 加入到购物车中，且会进入购物车校验是否加入成功
	 * @return ShoppingCartPage
	 */
	public ShoppingCartPage addToCart() {
		//判断商品是活动中还是非活动中，此处有坑，活动如果满足要求要走代办
		if (Model.getIsactivity() == 0) {
			click(addToCart);
			forceWait(1000);
			click(count);
			sendKeys(count, "50");
		}else if (Model.getIsactivity() == 1) {
			click(addToCart1);
			forceWait(1000);
			click(count);
			sendKeys(count, "200");
		}
		
		click(confirmAdd);
		while(!isVisibility(By.xpath("//*[@class='util-bill-pd']"))) {
			forceWait(1000);
		}
		forceWait(1000);
		click(minicart);
		return new ShoppingCartPage(driver);
	}
	/**
	 * 由于操作过快，系统会提示：有人正在操作
	 * sku加入到购物车，但不进入购物车，防止无法操作后续的拼柜
	 * 
	 */
	public void addSku() {
		if (Model.getIsactivity() == 0) {
			click(addToCart);
			forceWait(1000);
			click(count);
			sendKeys(count, "50");
		}else if (Model.getIsactivity() == 1) {
			click(addToCart1);
			forceWait(1000);
			click(count);
			sendKeys(count, "200");
		}
		click(confirmAdd);
		while(!isVisibility(By.xpath("//*[@class='util-bill-pd']"))) {
			forceWait(1000);
		}
		forceWait(1000);
	}
}
