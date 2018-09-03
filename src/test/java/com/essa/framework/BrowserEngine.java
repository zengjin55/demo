package com.essa.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserEngine {  
    
    private static String browserName;  
    private String serverURL;  
    private String buyerURL;
    private static WebDriver driver;  
    private static String env1;
      
    public void initConfigData() throws IOException{  
        Properties p = new Properties();  
        // 加载配置文件  
        InputStream ips = new FileInputStream(".\\resources\\config.properties"); 
        p.load(ips);  
        Logger.Output(LogType.LogTypeName.INFO, "开始从配置文件中选择浏览器");  
        browserName=p.getProperty("browserName");//使用jframe要注释
        Logger.Output(LogType.LogTypeName.INFO, "所选择的浏览器类型为: "+ browserName); 
        if (env1=="DIT") {
        	serverURL = p.getProperty("DIT"); 
        	buyerURL = p.getProperty("BDIT");
        	}else if (env1 =="HOTFIX") {
        		serverURL = p.getProperty("HOTFIX");
        		buyerURL = p.getProperty("BHOTFIX");
			}else if (env1 == "UAT") {
				serverURL = p.getProperty("UAT"); 
				buyerURL = p.getProperty("BUAT");
			}else {
				serverURL = p.getProperty("SIT"); 
				buyerURL = p.getProperty("BSIT");
			}
        Logger.Output(LogType.LogTypeName.INFO, "所测试的环境为："+ env1);  
        Model.setEnv(env1);//我也不知道为什么执行完上面的代码后，env会变为sit
        ips.close();  
    }  
    /**
     * bpms环境初始化
     * @param environment
     * @param browser
     */
    public static void setInit(String environment,String browser) {
    	browserName = browser;
    	env1 = environment;
    }
      
    /**
     * bpms获取地址方法
     * @return
     */
    public WebDriver getBrowser(){  
        
    	if(browserName.equalsIgnoreCase("Firefox")){  
            System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");    
            driver = new FirefoxDriver();  
            Logger.Output(LogType.LogTypeName.INFO, "正在启动FireFox浏览器");  
        }
    	else if(browserName.equals("Chrome")){  
            System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");  //图形界面
            driver= new ChromeDriver();  
            Logger.Output(LogType.LogTypeName.INFO, "正在启动Chrome浏览器");  
        }else if(browserName.equalsIgnoreCase("IE")){  
            System.setProperty("webdriver.ie.driver", ".\\src\\main\resources\\IEDriverServer.exe");  
            driver= new InternetExplorerDriver();  
            Logger.Output(LogType.LogTypeName.INFO, "正在启动IE浏览器");  
        }
    	driver.manage().window().maximize();  
        Logger.Output(LogType.LogTypeName.INFO, "窗口最大化");
        driver.get(serverURL);  
        Logger.Output(LogType.LogTypeName.INFO, "打开URL: "+ serverURL);  
        callWait(5);  
        return driver;  
    }  
   
    /**
     * buyer获取浏览器，并读取buyer的地址
     * @return
     */
    public WebDriver buyerGetBrowser() {
    	if (browserName.equals("Chrome")) {
    		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe"); //图形界面
    		driver= new ChromeDriver();  
            Logger.Output(LogType.LogTypeName.INFO, "正在启动Chrome浏览器");  
		}else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver.exe");    
            driver = new FirefoxDriver();  
            Logger.Output(LogType.LogTypeName.INFO, "正在启动FireFox浏览器"); 
		}
    	driver.manage().window().maximize();  
        Logger.Output(LogType.LogTypeName.INFO, "窗口最大化");
        driver.get(buyerURL);  
        Logger.Output(LogType.LogTypeName.INFO, "打开URL: "+ buyerURL);  
        callWait(5);  
        return driver;  
    }
      
      
    /**
     * 退出驱动
     * @throws InterruptedException
     */
    public void tearDown() throws InterruptedException{  
        Logger.Output(LogType.LogTypeName.INFO, "关闭浏览器");  
        driver.quit();  
        Thread.sleep(3000);  
    }  
      
    /**
     * 隐式时间等待方法 
     * @param time
     */
    public void callWait(int time){  
          
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);  
        Logger.Output(LogType.LogTypeName.INFO, "设置隐性等待"+time+" 秒");  
    }  
    /**
     *跳过安全链接 
     */
    public  void anQuan() {
    	 // 创建DesiredCapabilities类的一个对象实例  
        DesiredCapabilities cap=DesiredCapabilities.chrome();  
        // 设置变量ACCEPT_SSL_CERTS的值为True  
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        Logger.Output(LogType.LogTypeName.INFO, "设置浏览器可以打开不安全链接");
    }
}

