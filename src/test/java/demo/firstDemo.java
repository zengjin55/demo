package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.TestNG;

import com.essa.framework.BrowserEngine;
import com.essa.framework.Logger;
import com.essa.framework.Model;
import com.essa.pageObject.GoodsManage.AddOriginalGoodsPage;
import com.essa.pageObject.GoodsManage.GoodsBankPage;
import com.essa.pageObject.GoodsManage.UpdatePicPage;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;
import java.beans.PropertyChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.TextField;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

/**
 * @author Administrator
 *图形化
 */
public class firstDemo {

	private JFrame frmvBy;
	private JTextField supplierName;
	private JTextField buyerNo2;
	public static String no;
	private JTextField account;
	private JTextField SkuNo;
	private JTextField password;
	private JTextField registerAccount;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstDemo window = new firstDemo();
					window.frmvBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public firstDemo() {
		initialize();
		
	}
	 public  String getCurrentTime() {
			SimpleDateFormat format = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
			Date today = new Date();
			String time = format.format(today);
			return time;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmvBy = new JFrame("ESSA自动化测试工具v1.0.0");
		frmvBy.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmvBy.setTitle("ESSA自动化测试工具v1.0.1");
		frmvBy.setIconImage(Toolkit.getDefaultToolkit().getImage(firstDemo.class.getResource("/demo/icon2.png")));
		frmvBy.getContentPane().setEnabled(false);
		frmvBy.setResizable(false);
		frmvBy.setBackground(UIManager.getColor("Button.background"));
		frmvBy.setForeground(Color.LIGHT_GRAY);
		frmvBy.setBounds(650, 350, 526, 467);
		frmvBy.setSize(686, 405);
		frmvBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmvBy.getContentPane().setLayout(null);
		
		final JTextArea ja;
		JScrollPane jsp;
		ja = new JTextArea();
		jsp = new JScrollPane(ja);
		jsp.setBounds(22, 186, 631, 134);
		frmvBy.getContentPane().add(jsp);
		
		ja.setEditable(false);
		ja.setWrapStyleWord(true);
		ja.setLineWrap(true);
		ja.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//		ja.append("提示：建议使用版本号为68.0的Chrome浏览器\r\n");
		ja.append(getCurrentTime()+"默认选择场景：新增原厂商品\r\n");
		
		JLabel label = new JLabel("操作环境：");
		label.setBounds(24, 53, 78, 15);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		frmvBy.getContentPane().add(label);
		
		final JPanel ToCart = new JPanel();
		ToCart.setBounds(231, 42, 230, 128);
		ToCart.setVisible(false);
		frmvBy.getContentPane().add(ToCart);
		ToCart.setLayout(null);
		
		JLabel label_1 = new JLabel("可视化操作：");
		label_1.setBounds(10, 119, 88, 15);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		frmvBy.getContentPane().add(label_1);
		
		JRadioButton view = new JRadioButton("是");
		view.setBounds(103, 115, 42, 23);
		view.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		view.setSelected(true);
		frmvBy.getContentPane().add(view);
		
		JRadioButton notView = new JRadioButton("否");
		notView.setBounds(160, 115, 44, 23);
		notView.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		notView.setEnabled(false);
		frmvBy.getContentPane().add(notView);
		
		ButtonGroup group = new ButtonGroup();
		group.add(view);
		group.add(notView);
		
		final JLabel process = new JLabel();
		process.setBounds(474, 25, 179, 170);
		process.setForeground(Color.GRAY);
		process.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		process.setText("<html><body>新增原厂商品场景流程:<br>1.商品建档<br>2.更新商品图片<br>3.审核商品<br>4.检查商品库，验证是否新增成功<br>PS：以上均由账号（linxun）操作<br><br></body></html>");
		frmvBy.getContentPane().add(process);
		
		JLabel label_2 = new JLabel("操作场景：");
		label_2.setBounds(24, 87, 78, 15);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		frmvBy.getContentPane().add(label_2);
		
		
		final JPanel addOriginal = new JPanel();
		addOriginal.setBounds(231, 37, 234, 134);
		addOriginal.setVisible(true);
		frmvBy.getContentPane().add(addOriginal);
		addOriginal.setLayout(null);
		
		final JComboBox selectSystem = new JComboBox<String>();
		selectSystem.setBounds(102, 51, 114, 20);
		selectSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("SIT".equals((String)selectSystem.getSelectedItem())) {
					Model.setEnv("SIT");
					ja.append(getCurrentTime()+"已选择环境：SIT\r\n");
				}else if ("DIT".equals((String)selectSystem.getSelectedItem())) {
					Model.setEnv("DIT");
					ja.append(getCurrentTime()+"已选择环境：DIT\r\n");
				}else if ("HOTFIX".equals((String)selectSystem.getSelectedItem())) {
					Model.setEnv("HOTFIX");
					ja.append(getCurrentTime()+"已选择环境：HOTFIX\r\n");
				}else if ("UAT".equals((String)selectSystem.getSelectedItem())){
					Model.setEnv("UAT");
					ja.append(getCurrentTime()+"已选择环境：UAT\r\n");
				}
//				Model.setEnv((String)selectSystem.getSelectedItem());
			}
		});
		selectSystem.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		selectSystem.addItem("SIT");
		selectSystem.addItem("HOTFIX");
		selectSystem.addItem("UAT");
		selectSystem.addItem("DIT");
		frmvBy.getContentPane().add(selectSystem);
		
		final JPanel addMarket = new JPanel();
		addMarket.setBounds(0, 67, 230, 46);
		addOriginal.add(addMarket);
		addMarket.setVisible(false);
		addMarket.setLayout(null);
		
		final JComboBox browser = new JComboBox();
		browser.setEnabled(false);
		browser.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		browser.setBounds(102, 147, 114, 20);
		browser.setModel(new DefaultComboBoxModel(new String[] {"Chrome", "Firefox", "IE"}));
		frmvBy.getContentPane().add(browser);
		
		final JComboBox selectScene = new JComboBox();
		selectScene.setBounds(102, 85, 114, 20);
		selectScene.setForeground(Color.BLACK);
		selectScene.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		selectScene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("新增原厂商品".equals((String)selectScene.getSelectedItem())) {
					process.setText("<html><body>新增原厂商品场景流程:<br>1.商品建档<br>2.更新商品图片<br>3.审核商品<br>4.检查商品库，验证是否新增成功<br>PS：以上均由账号（linxun）操作<br><br></body></html>");
					addOriginal.setVisible(true);
					addMarket.setVisible(false);
					ToCart.setVisible(false);
					ja.append(getCurrentTime()+"已选择场景：新增原厂商品\r\n");
				}else if("新增市场商品".equals((String)selectScene.getSelectedItem())) {
					process.setText("<html><body>新增市场商品场景流程：<br>" + 
							"1.指定采购商编号(默认:RUS00833)<br>" + 
							"2.使用账号（maomeixiang)对指定采购商进行市场商品建档并选择审核人为\"邢昌勇\"<br>" + 
							"3.使用账号（xingchangyong）对市场商品审核<br></body></html>");
					addMarket.setVisible(true);
					ToCart.setVisible(false);
					ja.append(getCurrentTime()+"已选择场景：新增市场商品\r\n");
				}else if("发布团购".equals((String)selectScene.getSelectedItem())) {
					ja.append(getCurrentTime()+"已选择场景：发布团购，运行过程中将会打开关闭浏览器2次！\r\n");
					process.setText("<html><body>发布团购场景流程：<br><font color=\"red\">1.先执行新增原厂商品流程，生成一个原厂SKU</font><br>2.使用账号（linrong）为新增的SKU分配类目经理<br>3.团购设置中添加该SKU，并发布团购，验证团购发布结果</body></html>");
					addOriginal.setVisible(true);
					addMarket.setVisible(false);
					ToCart.setVisible(false);
				}else if ("采购商注册".equals((String)selectScene.getSelectedItem())) {
					addOriginal.setVisible(false);
					ToCart.setVisible(false);
					ja.append(getCurrentTime()+"已选择场景：采购商注册，运行过程中将会打开关闭浏览器2次！\r\n");
					process.setText("<html><body>采购商注册流程：<br>1.使用账号（admin）在bpms后台生成一个邀请码<br>2.采购商平台填写注册信息，并填入上一步生成的邀请码<br>PS:新账号密码默认为：essa123<br><br><br></body></html>");
				}else if ("添加SKU至购物车".equals((String)selectScene.getSelectedItem()))  {
					addOriginal.setVisible(false);
					ToCart.setVisible(true);
					ja.append(getCurrentTime()+"已选择场景：添加SKU至购物车\r\n");
					process.setText("<html><body>添加SKU至购物车流程：<br>1.Buyer平台根据填入的采购<br>商信息进行登录操作<br>2.若未填写商品编号，将从数<br>据库随机查出一个符合要求的<br>sku添加至购物车<br><br><br></body></html>");
				}else if ("成品询价".equals((String)selectScene.getSelectedItem())) {
					ToCart.setVisible(true);
					ja.append(getCurrentTime()+"已选择场景：成品询价，运行过程中将会打开关闭浏览器2次！\r\n");
					process.setText("<html><body>成品询价流程：<br>1.Buyer平台根据填入的采购<br>商信息加入sku，若未填写sku<br>编号，将随机从数据库获取符<br>合要求的sku<br>2.bpms后台登录账号（chenhong）对该sku进行成<br>品询价审核<br></body></html>");
				}else if ("提交PO".equals((String)selectScene.getSelectedItem())) {
					ToCart.setVisible(true);
					ja.append(getCurrentTime()+"已选择场景：提交PO，运行过程中将会打开关闭浏览器3次！\r\n");
					process.setText("<html><body>提交PO流程：<br>1.采购商平台加入商品至购物车<br>2.bpms后台登录账号（chenhong）对该sku进行成品询价审核<br>3.再次登录采购商平台，进行拼柜、设置唛头、贴纸和提交PO操作</body></html>");
				}
			}
		});
		selectScene.setModel(new DefaultComboBoxModel(new String[] {"新增原厂商品", "新增市场商品", "发布团购", "采购商注册", "成品询价", "提交PO"}));
		frmvBy.getContentPane().add(selectScene);
		
		JLabel label_3 = new JLabel("供应商名称：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setBounds(9, 15, 91, 15);
		addOriginal.add(label_3);
		
		supplierName = new JTextField();
		supplierName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		supplierName.setForeground(Color.BLACK);
		supplierName.setBounds(92, 10, 114, 25);
		addOriginal.add(supplierName);
		supplierName.setText("ESSA");
		supplierName.setColumns(10);
		
		JButton button = new JButton("选择图片");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button.setBounds(91, 44, 91, 23);
		addOriginal.add(button);
		
		JLabel lblSku = new JLabel("商品图片：");
		lblSku.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblSku.setBounds(22, 48, 70, 15);
		addOriginal.add(lblSku);
		
		final JLabel label_7 = new JLabel("*必填");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_7.setBounds(192, 48, 42, 15);
		addOriginal.add(label_7);
		label_7.setForeground(Color.RED);
		
		final JLabel picPath = new JLabel("");
		picPath.setVisible(false);
		addOriginal.add(picPath);
		
		JLabel label_5 = new JLabel("采购商编号：");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_5.setBounds(8, 15, 86, 15);
		addMarket.add(label_5);
		
		buyerNo2 = new JTextField();
		buyerNo2.setBounds(93, 11, 114, 25);
		addMarket.add(buyerNo2);
		buyerNo2.setFont(new Font("宋体", Font.PLAIN, 14));
		buyerNo2.setText("RUS00833");
		buyerNo2.setColumns(10);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				jf.showDialog(new JLabel(), "选择图片");
				File file=jf.getSelectedFile();
				String s = null;
				try {
					s = file.getAbsolutePath();
				} catch (NullPointerException exception) {
				}
				if(s == "" || s == null) {
					ja.append(getCurrentTime()+"您未选择图片，请选择图片\r\n");
				}else {
					ja.append(getCurrentTime()+"选择的图片为："+s+"\r\n");
					picPath.setText(s);
					label_7.setText("已选");
				}
			}
		});
		
		JLabel label_4 = new JLabel("浏览器：");
		label_4.setBounds(38, 149, 62, 15);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		frmvBy.getContentPane().add(label_4);
		
		JButton btnNewButton = new JButton("开 始");
		btnNewButton.setBounds(551, 325, 101, 35);
		frmvBy.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));

		
		JLabel lblEssav = new JLabel("ESSA自动化测试工具 V1.0.1");
		lblEssav.setBounds(225, 10, 228, 29);
		lblEssav.setFont(new Font("微软雅黑", Font.BOLD, 16));
		frmvBy.getContentPane().add(lblEssav);
		
		JLabel lblwindowsjdkbug = new JLabel("<html><body>提示：1.建议使用版本号为68.0的Chrome浏览器<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.由于部分操作会用到鼠标事件，若运行时手动切换界面可能会导致运行出错</body></html>");
		lblwindowsjdkbug.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblwindowsjdkbug.setBounds(25, 323, 456, 40);
		frmvBy.getContentPane().add(lblwindowsjdkbug);
		
		
		JLabel Account = new JLabel("采购商账号：");
		Account.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Account.setBounds(9, 10, 88, 15);
		ToCart.add(Account);
		
		JLabel Password = new JLabel("密码：");
		Password.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Password.setBounds(50, 41, 65, 15);
		ToCart.add(Password);
		
		JLabel No = new JLabel("商品编号：");
		No.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		No.setBounds(22, 75, 88, 15);
		ToCart.add(No);
		
		account = new JTextField();
		account.setText("buyer11159@essa.cn");
		account.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		account.setBounds(92, 4, 130, 25);
		ToCart.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setText("essa123");
		password.setToolTipText("");
		password.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		password.setBounds(92, 37, 130, 25);
		ToCart.add(password);
		password.setColumns(10);
		
		SkuNo = new JTextField();
		SkuNo.setText("选填,勿填活动商品");
		SkuNo.setForeground(Color.LIGHT_GRAY);
		SkuNo.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		SkuNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SkuNo.getText().equals("选填,勿填活动商品")) {
					SkuNo.setForeground(Color.black);
					SkuNo.setText("");
				}
			}
		});
		SkuNo.setBounds(92, 70, 130, 25);
		ToCart.add(SkuNo);
		SkuNo.setColumns(10);
		
		JPanel register = new JPanel();
		register.setBounds(231, 42, 224, 134);
		frmvBy.getContentPane().add(register);
		
		JLabel RegisterAccount = new JLabel("采购商邮箱：");
		register.add(RegisterAccount);
		RegisterAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		registerAccount = new JTextField();
		registerAccount.setForeground(Color.LIGHT_GRAY);
		registerAccount.setText("若不填写将自动生成");
		registerAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (registerAccount.getText().equals("若不填写将自动生成")) {
					registerAccount.setForeground(Color.black);
					registerAccount.setText("");
				}
			}
		});
		register.add(registerAccount);
		registerAccount.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		registerAccount.setColumns(10);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Environment = (String) selectSystem.getSelectedItem();
				String Scene = (String) selectScene.getSelectedItem();
				String Browser = (String) browser.getSelectedItem();
				BrowserEngine.setInit(Environment, Browser);
				TestNG testNG = new TestNG();
	            List<String> suites = new ArrayList<String>();
	            if (Scene == "新增原厂商品") {
					AddOriginalGoodsPage.setSupplierName(supplierName.getText());
					UpdatePicPage.setPicPath(picPath.getText());
//	            	suites.add(".\\suites\\addOriginalGoods.xml");
	            	suites.add(".\\resources\\suites\\addOriginalGoods.xml");//图形界面
				}else if (Scene == "新增市场商品") {
					Model.setBuyerNo(buyerNo2.getText());
					Model.setPicPath(picPath.getText());
					Model.setSupplierName(supplierName.getText());
//					suites.add(".\\suites\\addMarketGoods.xml");
					suites.add(".\\resources\\suites\\addMarketGoods.xml");//图形界面
				} else if (Scene == "发布团购") {
					AddOriginalGoodsPage.setSupplierName(supplierName.getText());
					UpdatePicPage.setPicPath(picPath.getText());
//					suites.add(".\\suites\\publishGroupPurchase.xml");
					suites.add(".\\resources\\suites\\publishGroupPurchase.xml");//图形界面
				} else if (Scene == "采购商注册") {
//					suites.add(".\\suites\\buyerRegister.xml");
					if (!(registerAccount.getText().equals("") ||registerAccount.getText().equals("若不填写将自动生成"))) {
						Model.setEmail(registerAccount.getText());
					}
					suites.add(".\\resources\\suites\\buyerRegister.xml");//图形界面
				} else if (Scene == "添加SKU至购物车") {
					Model.setBuyerAccount(account.getText());
					Model.setBuyerPassword(password.getText());
					Model.setSkuNo(SkuNo.getText());
					suites.add(".\\resources\\suites\\addSkuToCart.xml");//暂时舍弃
				} else if (Scene == "成品询价") {
					Model.setBuyerAccount(account.getText());
					Model.setBuyerPassword(password.getText());
					Model.setSkuNo(SkuNo.getText());
					System.out.println("打印："+SkuNo);//===============================================
					suites.add(".\\resources\\suites\\productInquiry.xml");
				} else if (Scene == "提交PO") {
					Model.setBuyerAccount(account.getText());
					Model.setBuyerPassword(password.getText());
					Model.setSkuNo(SkuNo.getText());
					suites.add(".\\resources\\suites\\sendPO.xml");
				}
	            testNG.setTestSuites(suites);
	            testNG.run();
	            ja.append(getCurrentTime()+"======="+Scene+"场景,执行完毕！=======\r\n");
	            if (Scene == "新增原厂商品" || Scene == "新增市场商品" || Scene == "发布团购") {
	            	no = Model.getSkuNo();
	            	if (no != null) {
	            		ja.append(getCurrentTime()+"SKU商品编号："+no+"\r\n");
					}else {
						ja.append(getCurrentTime()+"程序执行失败了！\r\n你可查看目录中test-output/index.html的测试报告，或者查看Log中的执行日志检查原因");
					}
				}else if (Scene == "采购商注册") {
	            	String code = Model.getInvateCode();
	            	String email = Model.getEmail();
	            	if (code !=null && email != null) {
	            		ja.append(getCurrentTime()+"生成的邀请码："+Model.getInvateCode()+"\r\n");
						ja.append(getCurrentTime()+"新采购商邮箱："+Model.getEmail()+"\r\n");
					}else {
						ja.append(getCurrentTime()+"程序执行失败了！\r\n你可以分析目录中test-output/index.html的测试报告，或者查看目录中Log文件夹生成的执行日志");
					}
				}else if (Scene == "添加SKU至购物车") {
					ja.append(getCurrentTime()+"所选采购商账号："+Model.getBuyerAccount()+"\r\n");
					ja.append(getCurrentTime()+"添加的SKU编号为："+Model.getSkuNo()+"\r\n");
				}else if (Scene == "成品询价") {
					ja.append(getCurrentTime()+"采购商账号："+Model.getBuyerAccount()+"\r\n");
					ja.append(getCurrentTime()+"SKU编号："+Model.getSkuNo()+"\r\n");
				}else if (Scene == "提交PO") {
					ja.append(getCurrentTime()+"采购商账号："+Model.getBuyerAccount()+"\r\n");
					ja.append(getCurrentTime()+"PO单号："+Model.getPoNum()+"\r\n");
				}
			}
		});
		
	}
}
