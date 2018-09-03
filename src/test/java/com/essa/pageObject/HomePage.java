package com.essa.pageObject;  
  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.support.FindBy;
import com.essa.framework.BasePage;
import com.essa.pageObject.GoodsManage.AddOriginalGoodsPage;
import com.essa.pageObject.GoodsManage.AuditMarketGoodsPage;
import com.essa.pageObject.GoodsManage.AuditOriginalGoodsPage;
import com.essa.pageObject.GoodsManage.GoodsBankPage;
import com.essa.pageObject.GoodsManage.GoodsRelesePage;
import com.essa.pageObject.GoodsManage.MarketGoodsRelesePage;
import com.essa.pageObject.buyPlaneManage.SkuCategoryManagerCongfigPage;
import com.essa.pageObject.buyerManage.InvateCodePage;
import com.essa.pageObject.inquiryManage.ProductInquiryTask;
import com.essa.pageObject.marketingManage.GroupControlPage;
import com.essa.pageObject.marketingManage.GroupSettingPage;  
  
/**
 * @author Administrator
 *bpms后台首页
 */
public class HomePage extends BasePage{  
    public HomePage(WebDriver driver) {  
        super(driver);  
    }  
    
    /*
     * 元素定位
     */
    
    //退出
    @FindBy (xpath="//*[text()='退出']")
    WebElement logout;
    
    //左上角图标--用于回到首页
    @FindBy (xpath="//*[@class='logo-text']")
    WebElement essaIcon;
    
    //供应商管理
    @FindBy (xpath="//*[text()='供应商管理']")
    WebElement supplier;
    
    //平台运营跟进管理
    @FindBy (xpath="//*/a[contains(text(),'平台运营跟进管理')]")
    WebElement operationsTrack;
    
    //供应商查询
    @FindBy (xpath="//*[text()='供应商查询']")
    WebElement searchSuppliers;
    
    //商品管理
    @FindBy (xpath="//*[text()='商品管理']")
    WebElement goodsManage;
    
    //商品库
    @FindBy (xpath="//*[text()='商品库']")
    WebElement goodBank;
    
    //原厂商品发布
    @FindBy (xpath="//*[text()='原厂商品发布']")
    WebElement addOriginalGoods;
    
    //市场商品发布
    @FindBy (xpath="//*[text()='市场商品发布']")
    WebElement marketGoodsRelese;
    
    //商品发布管理-子元素
    @FindBy(xpath="//*[@name='child.text' and text()='商品发布管理']")
    WebElement goodsPublish;
    
    //原厂商品发布审核
    @FindBy(xpath="//*[text()='原厂商品发布审核']")
    WebElement auditOriginal;
    
    //市场商品发布审核
    @FindBy(xpath="//*[text()='市场商品发布审核']")
    WebElement auditMarket;
    
    //采购计划管理
    @FindBy(xpath="//*[text()='采购计划管理']")
    WebElement buyerPlaneManage;
    
    //商品类目经理分配配置
    @FindBy(xpath="//*[text()='商品类目经理分配配置']")
    WebElement skuManagerConfig;
    
    //营销管理
    @FindBy (xpath="//*[text()='营销管理']")
    WebElement marketingManage;
    
    //团购设置
    @FindBy (xpath="//*[text()='团购设置']/..")
    WebElement groupSetting;
    
    //团购控制
    @FindBy (xpath="//*[text()='团购控制']/..")
    WebElement groupControl;
    
    //采购商管理
    @FindBy (xpath="//*[text()='采购商管理']")
    WebElement buyerManage;
    
    //生成邀请码
    @FindBy (xpath="//*[text()='生成邀请码']"	)
    WebElement inviteCode;
    
    //询价管理
    @FindBy (xpath ="//span[text()='询价管理']")
    WebElement inquiryManage;
    
    //成品询价任务列表
    @FindBy (xpath = "//*[text()='成品询价任务列表']")
    WebElement productInquiryTask;
    
    //产品开发
    @FindBy (xpath ="//*[text()='产品开发']")
    WebElement productDev;
    
    //项目立项书新增
    @FindBy (xpath ="//*[text()='项目立项书新增']")
    WebElement addProject;
    
    //项目立项书查询
    @FindBy (xpath ="//*[text()='项目立项书查询']")
    WebElement quiryProject;
    
    
    
    /*
     * 方法
     */
    
    /**
     * 进入运营跟进管理页面
     * @return SupplierOperationsTrackPage
     */
    public SupplierOperationsTrackPage goToSupplierOperationsTrack() {
    	
    	//点击 供应商管理
    	click(supplier);
    	
    	//点击 平台运营跟进管理
    	click(operationsTrack);
    	
    	//此时，系统会加载一个平台运营跟进管理页面，故在此初始化该页面并将driver传递过去
    	return new SupplierOperationsTrackPage(driver);
    	
    }
    
    /**
     * 进入原厂商品发布
     * @return AddOriginalGoodsPage
     */
    public AddOriginalGoodsPage tOriginalGoodsPage() {
    	click(goodsManage);
    	isElementExist(addOriginalGoods);
    	click(addOriginalGoods);
    	return new AddOriginalGoodsPage(driver);
    }
    
    /**
     * 进入商品发布管理
     * @return GoodsRelesePage
     */
    public GoodsRelesePage tGoodsRelesePage() {
    	click(goodsManage);
    	click(goodsPublish);
    	return new GoodsRelesePage(driver);
    }
    
    /**
     * 进入原厂商品发布审核
     * @return AuditOriginalGoodsPage
     */
    public AuditOriginalGoodsPage toAuditOriginalGoodsPage() {
    	mywait(logout);
    	click(goodsManage);
    	click(auditOriginal);
    	return new AuditOriginalGoodsPage(driver);
    }
    
    /**
     * 进入商品库
     * @return GoodsBankPage
     */
    public GoodsBankPage toGoodsBankPage() {
    	click(goodsManage);
    	click(goodBank);
    	return new GoodsBankPage(driver);
    }
    
    /**
     * 进入市场商品发布
     * @return MarketGoodsRelesePage
     */
    public MarketGoodsRelesePage toMarketGoodsRelesePage() {
    	click(goodsManage);
    	click(marketGoodsRelese);
    	return new MarketGoodsRelesePage(driver);
    }
    /**
     * 进入市场商品发布审核 
     * @return AuditMarketGoodsPage
     */
    public AuditMarketGoodsPage toAuditMarketGoodsPage() {
    	click(goodsManage);
    	click(auditMarket);
    	return new AuditMarketGoodsPage(driver);
    }
    /**
     * 进入商品类目经理分配配置
     * @return SkuCategoryManagerCongfigPage
     */
    public SkuCategoryManagerCongfigPage toSkuCategoryManagerCongfig() {
    	mywait(logout);
    	click(buyerPlaneManage);
    	click(skuManagerConfig);
    	return new SkuCategoryManagerCongfigPage(driver);
    }
    /**
     * 进入团购设置
     * @return GroupSettingPage
     */
    public GroupSettingPage toGroupSettingPage() {
    	getHome();
    	click(marketingManage);
    	click(groupSetting);
    	return new GroupSettingPage(driver);
    }
    /**
     * 进入团购控制
     * @return GroupControlPage
     */
    public GroupControlPage toGroupControlPage() {
//    	getHome();
    	jsExecutorClick(essaIcon);
    	click(marketingManage);
    	click(groupControl);
    	return new GroupControlPage(driver);
    }
    /**
     * 进入生成邀请码
     * @return InvateCodePage
     */
    public InvateCodePage toInvateCodePage() {
    	click(buyerManage);
    	moveHeightScroll("100");
    	click(inviteCode);
    	return new InvateCodePage(driver);
    }
    /**
     * 进入成品询价任务列表
     * @return ProductInquiryTask
     */
    public ProductInquiryTask toProductInquiryTask() {
    	click(inquiryManage);
    	click(productInquiryTask);
    	return new ProductInquiryTask(driver);
    }
    
    
    /**
     * 判断是否进入后台首页
     * @return boolean
     */
    public boolean isSucceed() {
    	return isThisPage("退出", logout);
    }
    
    /**
     * 判断是否选中“供应商管理”
     * @return
     */
    public boolean isSearchSuppliers() {
    	return isElementExist(searchSuppliers);
    }
    
    /**
     *点击essa图标， 回到bpms后台首页
     */
    public void getHome() {
    	forceWait(500);
    	jsExecutorClick(essaIcon);
    	forceWait(1000);
    }
    /**
     * 退出登录
     */
    public void logout() {
    	click(logout);
    }
}  