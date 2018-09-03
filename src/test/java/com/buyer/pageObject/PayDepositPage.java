package com.buyer.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.essa.framework.BasePage;
import com.essa.framework.Model;

/**
 * @author Administrator
 *支付定金页
 */
public class PayDepositPage extends BasePage {
	public PayDepositPage(WebDriver driver) {
		super(driver);
	}
	
	//PO信息
	@FindBy (xpath="//*[contains(text(),'PO information')]")
	WebElement POInfo;
	
	//查看资金详情---可用资金不足
	@FindBy (xpath ="//button[@class='submit-payment-deposit-button btn btn-primary']")
	WebElement FundDetail;
	
	//免定金模式--确认按钮
	@FindBy (xpath ="//*[@ng-click='submit()']")
	WebElement ok;
	
	//po单号
	@FindBy (xpath ="//*[contains(text(),'PO number:')]/../../td[2]/span")
	WebElement poNum;
	
	/**
	 * 查看资金详情
	 * @return AssetManagementPage
	 */
	public AssetManagementPage toAssetManagementPage() {
		click(FundDetail);
		return new AssetManagementPage(driver);
	}
	
	/**
	 * 确认PO
	 * @return MyOrderPage
	 */
	public MyOrderPage confirm() {
		click(ok);
		return new MyOrderPage(driver);
	}
	
	public void operate() {
		while (!(isVisibility(By.xpath("//*[contains(text(),'PO information')]")))) {
			forceWait(1000);
		}
		Model.setPoNum(poNum.getText());
		if (isVisibility(By.xpath("//button[@class='submit-payment-deposit-button btn btn-primary']"))) {
			//如果是可用资金不足，跳转到资金管理
			toAssetManagementPage();
		}else if (isVisibility(By.xpath("//*[@ng-click='submit()']"))) {
			//免定金模式，确认po，跳转到我的订单列表
			confirm();
		}
		forceWait(2000);
	}
}
