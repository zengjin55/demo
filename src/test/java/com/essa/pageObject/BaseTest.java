package com.essa.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.essa.framework.BrowserEngine;
import com.essa.pageObject.LoginPage;

public class BaseTest {
	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * bpms调用浏览器，打开要测试的网页
	 */
	public void initsetUp() {
		BrowserEngine browserEngine = new BrowserEngine();
		try {
			browserEngine.initConfigData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = browserEngine.getBrowser();
	}
	
	/**
	 * buyer调用浏览器，将访问buyer的地址
	 */
	public void initBuyer() {
		BrowserEngine browserEngine = new BrowserEngine();
		try {
			browserEngine.initConfigData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = browserEngine.buyerGetBrowser();
	}

	/**
	 * bpms初始化登录页面，登录
	 * @param account
	 */
	public void loginValid(String account) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(account, "essa123");
	}
}

