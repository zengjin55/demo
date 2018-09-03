package com.essa.pageObject.productDev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;

/**
 * @author Administrator
 *新增项目立项书
 */
public class AddProjectPage extends BasePage {
	public AddProjectPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * 元素定位
	 */
	//改版类型
	@FindBy (xpath ="//*[@dic-list='改版类型']")
	WebElement revisonType;
	
	//项目名称
	@FindBy (xpath ="//*[@ng-model='model.name']")
	WebElement projectName;
	
	//项目负责人
	@FindBy (xpath ="//*[@ng-model='model.leaderId']/input")
	WebElement projectLeader;
	
	//项目负责人-林荣
	@FindBy (xpath ="//*[@id='role-user-select-box']/ul/li[3]/span")
	WebElement linrong;
	
	//开发程度
	@FindBy (xpath ="//*[@dic-list='开发程度']")
	WebElement devLevel;
	
	//开发系列
	@FindBy (xpath ="//*[@ng-model='model.serialId']")
	WebElement devSerial;
	
	//团队成员-新增
	@FindBy (xpath ="//button[text()='新增']")
	WebElement addMember;
	
	//任务处理人 -第一个
	@FindBy (xpath ="//*[@class='col-md-14']/table/tbody/tr[1]/td[2]/div/input")
	WebElement Transactor1;
	
	//处理人-linrong
	@FindBy (xpath ="//*[@id='role-user-select-box']/ul/li[3]/span")
	WebElement linrong1;
	
	//任务处理人 -第二个
	@FindBy (xpath ="//*[@class='col-md-14']/table/tbody/tr[2]/td[2]/div/input")
	WebElement Transactor2;
	
	//成员角色 -第一个
	@FindBy (xpath ="//*[@class='col-md-14']/table/tbody/tr[1]/td[3]/select")
	WebElement role1;
	
	//成员角色 -第二个
	@FindBy (xpath ="//*[@class='col-md-14']/table/tbody/tr[2]/td[3]/select")
	WebElement role2;
	
	//选择改版商品信息
	@FindBy (xpath ="//*[text()='选择']")
	WebElement selectGoods;
	
	//保存
	@FindBy (xpath ="//*[contains(text(),'保存')]")
	WebElement save;
}
