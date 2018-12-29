package com.suciz.skf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.suciz.skf.SKF.SKF_FileAttribute;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Demo {

	private JFrame frame;
	private JComboBox comboBox_devName;
	private JButton button_connect;
	private JButton button_disconnect;
	private JButton button_getDevInfo;

	private long[] handleDev;
	private long[] handleApp;
	private JLabel label;
	private JTextField textField_label;
	private JButton button_setLabel;
	private JButton btn_openApp;
	private JButton btn_closeApp;
	private JTextField textField_pin;
	private JTextField textField_pinOrig;
	private JTextField textField_pinNew;
	private JTextField textField_pinAdm;
	private JTextField textField_pinUsr;
	private final ButtonGroup buttonGroup_pinType = new ButtonGroup();
	private final ButtonGroup buttonGroup_filewrite = new ButtonGroup();
	private final ButtonGroup buttonGroup_fileread = new ButtonGroup();
	private JRadioButton radio_pinTypeAdm;
	private JRadioButton radio_pinTypeUsr;
	private JTextField textField_len;
	private JTextField textField_random;
	private JComboBox jComboBox_files;
	private JRadioButton jRadioButton_file_write_so;
	private JTextField jTextField_fileread;
	private JButton jButton_read_file;
	private JButton jButton_write_file;
	private JTextField jTextField_write;
	private JLabel jLabel3;
	private JButton jButton_file_delete;
	private JTextField jTextField_filesize;
	private JLabel jLabel4;
	private JTextField jTextField_file_name;
	private JButton jButton_create_file;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JRadioButton jRadioButton_file_write_every;
	private JRadioButton jRadioButton_file_write_user;
	private JRadioButton jRadioButton_file_read_every;
	private JRadioButton jRadioButton_file_read_user;
	private JRadioButton jRadioButton_file_read_so;
	private JButton jButton_enum_files;
	private JPanel panel_file;
	private JComboBox comboBox_containers;
	private JTextField textField_newContainerName;
	private JTextField textField_pfxPath;
	private JTextField textField_pfxPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		System.out.println("把tokenh_Javadll放在" + System.getProperty("java.library.path"));
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				SKF.getInstance().Initialize();
				
				ArrayList<String> listDevName = new ArrayList<String>();
			
				
				long lRet = SKF.getInstance().EnumDev(true, listDevName);
				if( SKF.SKF_ERROR.SAR_OK == lRet)
				{
					for(int i = 0; i < listDevName.size(); i++ )
					{
						comboBox_devName.addItem(listDevName.get(i));
					}
				}
				
				
				SKF.getInstance().SetEventHandler(new SKF.EventHandler() {
					@Override
					public void onInsert(String devName){
						comboBox_devName.addItem(devName);
					}
					@Override
					public void onRemove(String devName){
						comboBox_devName.removeItem(devName);
					}

					@Override
					public void onFinalize(){
						System.out.print("OnFinalize");
					}
				});
			}
			@Override
			public void windowClosing(WindowEvent e) {
				SKF.getInstance().Finalize();
			}
		});
		frame.setBounds(100, 100, 682, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox_devName = new JComboBox();
		comboBox_devName.setBounds(89, 13, 561, 24);
		frame.getContentPane().add(comboBox_devName);
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(14, 13, 83, 24);
		frame.getContentPane().add(lblNewLabel);
		
		button_connect = new JButton("\u8FDE\u63A5\u8BBE\u5907");
		button_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleDev = new long[1];
				String devName = (String) comboBox_devName.getSelectedItem();
				long lRet = SKF.getInstance().Connect(devName, handleDev);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}
			}
		});
		button_connect.setBounds(24, 50, 113, 27);
		frame.getContentPane().add(button_connect);
		
		button_disconnect = new JButton("\u5173\u95ED\u8BBE\u5907");
		button_disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(null != handleDev)
				{
					long lRet = SKF.getInstance().Disconnect(handleDev[0]);
					if( SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, lRet);
					}
				}
			}
		});
		button_disconnect.setBounds(153, 50, 113, 27);
		frame.getContentPane().add(button_disconnect);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 90, 636, 336);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_dev = new JPanel();
		tabbedPane.addTab("\u8BBE\u5907\u7BA1\u7406", null, panel_dev, null);
		panel_dev.setLayout(null);
		
		button_getDevInfo = new JButton("\u8BBE\u5907\u4FE1\u606F");
		button_getDevInfo.setBounds(337, 13, 93, 27);
		panel_dev.add(button_getDevInfo);
		
		label = new JLabel("\u8BBE\u5907\u6807\u7B7E");
		label.setBounds(14, 17, 72, 18);
		panel_dev.add(label);
		
		textField_label = new JTextField();
		textField_label.setBounds(82, 14, 123, 24);
		panel_dev.add(textField_label);
		textField_label.setColumns(10);
		
		button_setLabel = new JButton("\u8BBE\u7F6E\u6807\u7B7E");
		button_setLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long lRet = SKF.getInstance().SetLabel(handleDev[0], textField_label.getText());
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					JOptionPane.showMessageDialog(null, "设置标签成功");
				}
			}
		});
		button_setLabel.setBounds(230, 13, 93, 27);
		panel_dev.add(button_setLabel);
		
		JLabel label_1 = new JLabel("\u968F\u673A\u6570\u957F\u5EA6");
		label_1.setBounds(14, 70, 75, 18);
		panel_dev.add(label_1);
		
		textField_len = new JTextField();
		textField_len.setBounds(103, 67, 44, 24);
		panel_dev.add(textField_len);
		textField_len.setColumns(10);
		
		textField_random = new JTextField();
		textField_random.setBounds(103, 104, 405, 24);
		panel_dev.add(textField_random);
		textField_random.setColumns(10);
		
		JLabel label_2 = new JLabel("\u968F\u673A\u6570");
		label_2.setBounds(14, 107, 72, 18);
		panel_dev.add(label_2);
		
		JButton button_genRandom = new JButton("\u751F\u6210\u968F\u673A\u6570");
		button_genRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nLen = Integer.parseInt(textField_len.getText());
				
				byte[] dataRandom = new byte[nLen];
				
				long lRet = SKF.getInstance().GenRandom(handleDev[0], dataRandom);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					JOptionPane.showMessageDialog(null, "产生随机数成功");
					String msg = "";
					for( int i = 0; i < dataRandom.length; i++ )
					{
						msg += Integer.toHexString(dataRandom[i]&0xff);
					}
					textField_random.setText(msg);
				}
			}
		});
		button_genRandom.setBounds(230, 66, 113, 27);
		panel_dev.add(button_genRandom);
		button_getDevInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SKF.SKF_DevInfo devInfo = new SKF.SKF_DevInfo();
				long lRet = SKF.getInstance().GetDevInfo(handleDev[0], devInfo);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					String msg = "";
					msg += "devInfo.version = ";
					msg += Integer.toString(devInfo.version.major) + ".";
					msg += Integer.toString(devInfo.version.minor);
					
					msg += "\r\n";
					
					msg += "Label = ";
					msg += new String(devInfo.Label);
					msg += "\r\n";
					msg += "Manufacturer = ";
					msg += new String(devInfo.Manufacturer);
					msg += "\r\n";
					msg += "Issuer= ";
					msg += new String(devInfo.Issuer);
					msg += "\r\n";
					msg += "serialNumber = ";
					msg += new String(devInfo.serialNumber);
					
					msg += "\r\n";
					msg += "devInfo.HWVersion = ";
					msg += Integer.toString(devInfo.HWVersion.major) + ".";
					msg += Integer.toString(devInfo.HWVersion.minor);

					msg += "\r\n";
					msg += "devInfo.FirmwareVersion = ";
					msg += Integer.toString(devInfo.FirmwareVersion.major) + ".";
					msg += Integer.toString(devInfo.FirmwareVersion.minor);
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		
		JPanel panel_app = new JPanel();
		tabbedPane.addTab("PIN\u7BA1\u7406", null, panel_app, null);
		panel_app.setLayout(null);
		
		JButton btn_getPinInfo = new JButton("\u5BC6\u94A5\u4FE1\u606F");
		btn_getPinInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long pinType = SKF.SKF_PinType.USER_TYPE;
				if(radio_pinTypeAdm.isSelected()){
					pinType = SKF.SKF_PinType.ADMIN_TYPE;
				}else{
					pinType = SKF.SKF_PinType.USER_TYPE;
				}
				
				long[] retryCountMax = new long[1];
				long[] retryCountRemain = new long[1];
				boolean[] defaultPin = new boolean[1]; 
				
				long lRet = SKF.getInstance().GetPINInfo(handleApp[0], pinType, retryCountMax, retryCountRemain, defaultPin);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					String msg = "";
					msg += "最大重试次数为" + retryCountMax[0];
					msg += "\r\n";
					msg += "剩余重试次数为" + retryCountRemain[0];
					msg += "\r\n";
					msg += defaultPin[0] ? "是默认PIN" : "不是默认PIN";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btn_getPinInfo.setBounds(316, 13, 113, 27);
		panel_app.add(btn_getPinInfo);
		
		radio_pinTypeAdm = new JRadioButton("\u7BA1\u7406\u5BC6\u7801");
		buttonGroup_pinType.add(radio_pinTypeAdm);
		radio_pinTypeAdm.setBounds(108, 13, 89, 27);
		panel_app.add(radio_pinTypeAdm);
		
		radio_pinTypeUsr = new JRadioButton("\u7528\u6237\u5BC6\u7801");
		buttonGroup_pinType.add(radio_pinTypeUsr);
		radio_pinTypeUsr.setBounds(203, 13, 103, 27);
		panel_app.add(radio_pinTypeUsr);
		
		JLabel lblPin = new JLabel("PIN\u7C7B\u578B\u8BBE\u7F6E");
		lblPin.setBounds(14, 17, 84, 18);
		panel_app.add(lblPin);
		
		JButton btn_clearSecureStatus = new JButton("\u6E05\u9664\u5B89\u5168\u72B6\u6001");
		btn_clearSecureStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long lRet = SKF.getInstance().ClearSecureState(handleApp[0]);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					JOptionPane.showMessageDialog(null, "清除设备状态成功");
				}
			}
		});
		btn_clearSecureStatus.setBounds(432, 13, 123, 27);
		panel_app.add(btn_clearSecureStatus);
		
		JLabel lblpin = new JLabel("\u6821\u9A8CPIN\u4E4B\u540E\uFF0C\u53EF\u83B7\u5F97\u76F8\u5E94\u6743\u9650\uFF1A");
		lblpin.setBounds(14, 48, 219, 18);
		panel_app.add(lblpin);
		
		textField_pin = new JTextField();
		textField_pin.setBounds(91, 76, 311, 24);
		panel_app.add(textField_pin);
		textField_pin.setColumns(10);
		
		JLabel lblPin_1 = new JLabel("PIN:");
		lblPin_1.setBounds(45, 79, 32, 18);
		panel_app.add(lblPin_1);
		
		JButton btn_pinVerify = new JButton("\u6821\u9A8C");
		btn_pinVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long pinType = SKF.SKF_PinType.USER_TYPE;
				if(radio_pinTypeAdm.isSelected()){
					pinType = SKF.SKF_PinType.ADMIN_TYPE;
				}else{
					pinType = SKF.SKF_PinType.USER_TYPE;
				}
				
				byte[] pin = textField_pin.getText().getBytes();
				long[] retryCount = new long[1];
				long lRet = SKF.getInstance().VerifyPIN(handleApp[0], pinType, pin, retryCount);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
				}else{
					JOptionPane.showMessageDialog(null, "设备认证成功");
				}
			}
		});
		btn_pinVerify.setBounds(432, 75, 113, 27);
		panel_app.add(btn_pinVerify);
		
		JLabel lblpinpin = new JLabel("\u4FEE\u6539PIN,\u8BBE\u7F6E\u65B0\u7684PIN");
		lblpinpin.setBounds(14, 113, 146, 18);
		panel_app.add(lblpinpin);
		
		JLabel lblOldPin = new JLabel("\u539FPIN:");
		lblOldPin.setBounds(30, 144, 47, 18);
		panel_app.add(lblOldPin);
		
		JLabel lblNewPin = new JLabel("\u65B0PIN:");
		lblNewPin.setBounds(30, 175, 47, 18);
		panel_app.add(lblNewPin);
		
		textField_pinOrig = new JTextField();
		textField_pinOrig.setBounds(91, 141, 311, 24);
		panel_app.add(textField_pinOrig);
		textField_pinOrig.setColumns(10);
		
		textField_pinNew = new JTextField();
		textField_pinNew.setBounds(91, 172, 311, 24);
		panel_app.add(textField_pinNew);
		textField_pinNew.setColumns(10);
		
		JButton button_pinChange = new JButton("\u4FEE\u6539");
		button_pinChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				long pinType = SKF.SKF_PinType.USER_TYPE;
				if(radio_pinTypeAdm.isSelected()){
					pinType = SKF.SKF_PinType.ADMIN_TYPE;
				}else{
					pinType = SKF.SKF_PinType.USER_TYPE;
				}
				
				byte[] pinOrig = textField_pinOrig.getText().getBytes();
				byte[] pinNew = textField_pinNew.getText().getBytes();
				
				long[] retryCount = new long[1];
				
				long lRet = SKF.getInstance().ChangePIN(handleApp[0], pinType, pinOrig, pinNew, retryCount);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
				}else{
					JOptionPane.showMessageDialog(null, "修改PIN成功");
				}
			}
		});
		button_pinChange.setBounds(432, 171, 113, 27);
		panel_app.add(button_pinChange);
		
		JLabel lblpin_1 = new JLabel("\u89E3\u9501\u7528\u6237PIN");
		lblpin_1.setBounds(14, 206, 84, 18);
		panel_app.add(lblpin_1);
		
		JLabel lblpin_2 = new JLabel("\u7BA1\u7406PIN:");
		lblpin_2.setBounds(14, 237, 62, 18);
		panel_app.add(lblpin_2);
		
		JLabel lblpin_3 = new JLabel("\u7528\u6237PIN:");
		lblpin_3.setBounds(14, 268, 62, 18);
		panel_app.add(lblpin_3);
		
		textField_pinAdm = new JTextField();
		textField_pinAdm.setBounds(91, 234, 311, 24);
		panel_app.add(textField_pinAdm);
		textField_pinAdm.setColumns(10);
		
		textField_pinUsr = new JTextField();
		textField_pinUsr.setBounds(91, 265, 311, 24);
		panel_app.add(textField_pinUsr);
		textField_pinUsr.setColumns(10);
		
		JButton button_pinUnblock = new JButton("\u89E3\u9501");
		button_pinUnblock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				byte[] pinAdm = textField_pinAdm.getText().getBytes();
				byte[] pinUsr = textField_pinUsr.getText().getBytes();
				long[] retryCount = new long[1];
				
				long lRet = SKF.getInstance().UnblockPIN(handleApp[0], pinAdm, pinUsr, retryCount);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
				}else{
					JOptionPane.showMessageDialog(null, "重设用户PIN成功");
				}
			}
		});
		button_pinUnblock.setBounds(432, 233, 113, 27);
		panel_app.add(button_pinUnblock);
		
		JPanel panel_con = new JPanel();
		tabbedPane.addTab("\u5BB9\u5668", null, panel_con, null);
		panel_con.setLayout(null);
		{
			panel_file = new JPanel();
			tabbedPane.addTab("文件管理", null, panel_file, null);
			panel_file.setLayout(null);
			panel_file.setPreferredSize(new java.awt.Dimension(10, 10));
			{
				ComboBoxModel jComboBox_filesModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				jComboBox_files = new JComboBox();
				panel_file.add(jComboBox_files);
				jComboBox_files.setModel(jComboBox_filesModel);
				jComboBox_files.setBounds(31, 27, 295, 24);
			}
			{
				jButton_enum_files = new JButton();
				panel_file.add(jButton_enum_files);
				jButton_enum_files.setText("\u679a\u4e3e\u6587\u4ef6");
				jButton_enum_files.setBounds(338, 28, 86, 24);
				jButton_enum_files.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						
						ArrayList<String> nameList = new ArrayList<String>();
						long lRet = SKF.getInstance().FileEnum(handleApp[0], nameList);
						if( SKF.SKF_ERROR.SAR_OK != lRet){
							JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
						}else{
							
							jComboBox_files.removeAllItems();
							
							for( int i = 0; i < nameList.size(); i++ )
							{
								jComboBox_files.insertItemAt(nameList.get(i), i);
							}
						}
					}
				});
			}
			{
				jRadioButton_file_read_so = new JRadioButton();
				panel_file.add(jRadioButton_file_read_so);
				jRadioButton_file_read_so.setText("\u7ba1\u7406\u5458\u6743\u9650");
				jRadioButton_file_read_so.setBounds(79, 65, 118, 21);
				buttonGroup_fileread.add(jRadioButton_file_read_so);
			}
			{
				jRadioButton_file_read_user = new JRadioButton();
				panel_file.add(jRadioButton_file_read_user);
				jRadioButton_file_read_user.setText("\u7528\u6237\u6743\u9650");
				jRadioButton_file_read_user.setBounds(202, 65, 97, 21);
				buttonGroup_fileread.add(jRadioButton_file_read_user);
			}
			{
				jRadioButton_file_read_every = new JRadioButton();
				panel_file.add(jRadioButton_file_read_every);
				jRadioButton_file_read_every.setText("\u4e0d\u9650\u5236");
				jRadioButton_file_read_every.setBounds(322, 65, 80, 21);
				buttonGroup_fileread.add(jRadioButton_file_read_every);
			}
			{
				jRadioButton_file_write_so = new JRadioButton();
				panel_file.add(jRadioButton_file_write_so);
				jRadioButton_file_write_so.setText("\u7ba1\u7406\u5458\u6743\u9650");
				jRadioButton_file_write_so.setBounds(79, 94, 118, 21);
				buttonGroup_filewrite.add(jRadioButton_file_write_so);
			}
			{
				jRadioButton_file_write_user = new JRadioButton();
				panel_file.add(jRadioButton_file_write_user);
				jRadioButton_file_write_user.setText("\u7528\u6237\u6743\u9650");
				jRadioButton_file_write_user.setBounds(202, 94, 91, 21);
				buttonGroup_filewrite.add(jRadioButton_file_write_user);
			}
			{
				jRadioButton_file_write_every = new JRadioButton();
				panel_file.add(jRadioButton_file_write_every);
				jRadioButton_file_write_every.setText("\u4e0d\u9650\u5236");
				jRadioButton_file_write_every.setBounds(322, 94, 80, 21);
				buttonGroup_filewrite.add(jRadioButton_file_write_every);
			}
			{
				jLabel1 = new JLabel();
				panel_file.add(jLabel1);
				jLabel1.setText("\u8bfb\u6743\u9650");
				jLabel1.setBounds(31, 65, 48, 17);
			}
			{
				jLabel2 = new JLabel();
				panel_file.add(jLabel2);
				jLabel2.setText("\u5199\u6743\u9650");
				jLabel2.setBounds(31, 92, 42, 17);
			}
			{
				jButton_create_file = new JButton();
				panel_file.add(jButton_create_file);
				jButton_create_file.setText("\u521b\u5efa\u6587\u4ef6");
				jButton_create_file.setBounds(356, 160, 103, 24);
				jButton_create_file.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {

						String sfilename = jTextField_file_name.getText();
						long fileSize = Long.parseLong(jTextField_filesize.getText());
						
						long rightRead = SKF.SKF_Secure_Right.NO_RIGHT;
						if(jRadioButton_file_read_so.isSelected() )
						{
							rightRead = SKF.SKF_Secure_Right.SO_RIGTH;
						}
						
						if(jRadioButton_file_read_user.isSelected())
						{
							rightRead = SKF.SKF_Secure_Right.USER_RIGHT;
						}
						
						if( jRadioButton_file_read_every.isSelected())
						{
							rightRead = SKF.SKF_Secure_Right.EVERY_RIGHT;
						}
						
						long rightWrite = SKF.SKF_Secure_Right.NO_RIGHT;
						if(jRadioButton_file_write_so.isSelected())
						{
							rightWrite = SKF.SKF_Secure_Right.SO_RIGTH;
						}
						
						if(jRadioButton_file_write_user.isSelected())
						{
							rightWrite = SKF.SKF_Secure_Right.USER_RIGHT;
						}
						if(jRadioButton_file_write_every.isSelected())
						{
							rightWrite = SKF.SKF_Secure_Right.EVERY_RIGHT;
						}
						
						long lRet = SKF.getInstance().FileCreate(handleApp[0], sfilename, fileSize, rightRead, rightWrite);
						if( SKF.SKF_ERROR.SAR_OK != lRet){
							JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
						}else{
							JOptionPane.showMessageDialog(null, "创建文件成功");
						}
					}
				});
			}
			{
				jTextField_file_name = new JTextField();
				panel_file.add(jTextField_file_name);
				jTextField_file_name.setBounds(79, 126, 243, 24);
			}
			{
				jLabel3 = new JLabel();
				panel_file.add(jLabel3);
				jLabel3.setText("\u6587\u4ef6\u540d");
				jLabel3.setBounds(31, 129, 42, 17);
			}
			{
				jTextField_write = new JTextField();
				panel_file.add(jTextField_write);
				jTextField_write.setBounds(83, 214, 243, 24);
			}
			{
				jButton_write_file = new JButton();
				panel_file.add(jButton_write_file);
				jButton_write_file.setText("\u5199\u6587\u4ef6");
				jButton_write_file.setBounds(356, 214, 73, 24);
				jButton_write_file.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						String sFilename = (String) jComboBox_files.getSelectedItem();
						String sText = jTextField_write.getText();
						byte[] sDataToWrite = sText.getBytes();

						long lRet = SKF.getInstance().FileWrite(handleApp[0], sFilename, 0, sDataToWrite);
						if( SKF.SKF_ERROR.SAR_OK != lRet){
							JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
						}else{
							JOptionPane.showMessageDialog(null, "写文件成功");
						}
					}
				});
			}
			{
				jButton_read_file = new JButton();
				panel_file.add(jButton_read_file);
				jButton_read_file.setText("\u8bfb\u6587\u4ef6");
				jButton_read_file.setBounds(356, 255, 73, 24);
				jButton_read_file.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {

						String sFilename = (String) jComboBox_files.getSelectedItem();
						
						SKF.SKF_FileAttribute info = new SKF.SKF_FileAttribute();

						//利用文件属性可以得到文件长度
						long lRet = SKF.getInstance().FileGetInfo(handleApp[0], sFilename, info);
						if( SKF.SKF_ERROR.SAR_OK != lRet){
							JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
						}else{

							ArrayList<Byte> data = new ArrayList<Byte>();
							
							lRet = SKF.getInstance().FileRead(handleApp[0], sFilename, 0, info.FileSize,  data);
							if( SKF.SKF_ERROR.SAR_OK != lRet){
								JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
							}else{
								JOptionPane.showMessageDialog(null, "读文件成功");
								
								byte pdata[] = new byte[data.size()];
								for( int i = 0; i < pdata.length; i++ )
								{
									pdata[i] = data.get(i);
								}
								
								String sText = new String(pdata);
								
								jTextField_fileread.setText(sText);
							}
						}
					}
				});
			}
			{
				jTextField_fileread = new JTextField();
				panel_file.add(jTextField_fileread);
				jTextField_fileread.setBounds(83, 255, 243, 24);
			}
			{
				jLabel4 = new JLabel();
				panel_file.add(jLabel4);
				jLabel4.setText("\u6587\u4ef6\u5927\u5c0f");
				jLabel4.setBounds(19, 163, 48, 17);
			}
			{
				jTextField_filesize = new JTextField();
				panel_file.add(jTextField_filesize);
				jTextField_filesize.setBounds(79, 160, 243, 24);
			}
			{
				jButton_file_delete = new JButton();
				panel_file.add(jButton_file_delete);
				jButton_file_delete.setText("\u5220\u9664");
				jButton_file_delete.setBounds(447, 28, 71, 24);
				jButton_file_delete.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {

						String sFilename = (String) jComboBox_files.getSelectedItem();
						
						long lRet = SKF.getInstance().FileDelete(handleApp[0], sFilename);
						if( SKF.SKF_ERROR.SAR_OK != lRet){
							JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
						}else{
							JOptionPane.showMessageDialog(null, "删除文件成功");
						}
					}
				});
			}
		}

		comboBox_containers = new JComboBox();
		comboBox_containers.setBounds(26, 27, 302, 24);
		panel_con.add(comboBox_containers);
		
		JButton button_enumContainer = new JButton("\u679A\u4E3E\u5BB9\u5668\u540D");
		button_enumContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> arrayContainers = new ArrayList<String>();
				
				long lRet = SKF.getInstance().ContainerEnum(handleApp[0], arrayContainers);
				if(SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
				}else{
//					ComboBox_containers.
					comboBox_containers.removeAll();
					for(int i = 0; i < arrayContainers.size(); i++ )
					{
						comboBox_containers.addItem(arrayContainers.get(i));
					}
				}
				
			}
		});
		button_enumContainer.setBounds(342, 26, 113, 27);
		panel_con.add(button_enumContainer);
		
		JButton button_delContainer = new JButton("\u5220\u9664");
		button_delContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String containerName = comboBox_containers.getSelectedItem().toString();
				if(!containerName.isEmpty()){
					long lRet = SKF.getInstance().ContainerDelete(handleApp[0], containerName);
					if(SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
					}
				}
				
			}
		});
		button_delContainer.setBounds(469, 26, 113, 27);
		panel_con.add(button_delContainer);
		
		textField_newContainerName = new JTextField();
		textField_newContainerName.setBounds(26, 76, 302, 24);
		panel_con.add(textField_newContainerName);
		textField_newContainerName.setColumns(10);
		
		JButton button_newContainer = new JButton("\u65B0\u5EFA\u5BB9\u5668");
		button_newContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String containerName = textField_newContainerName.getText();
				if( ! containerName.isEmpty()){
					long[] handleContainer = new long[1];
					long lRet = SKF.getInstance().ContainerCreate(handleApp[0], containerName, handleContainer);
					if(SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, Long.toHexString(lRet));
					}else{
						//关闭资源
						SKF.getInstance().ContainerClose(handleContainer[0]);
					}
				}
			}
		});
		button_newContainer.setBounds(342, 75, 113, 27);
		panel_con.add(button_newContainer);
		
		JButton btn_exportCert = new JButton("\u5BFC\u51FA");
		btn_exportCert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String containerName = comboBox_containers.getSelectedItem().toString();
				if(containerName.isEmpty())
				{
					return;
				}
				
				long[] handleContainer = new long[1];
				long lRet = SKF.getInstance().ContainerOpen(handleApp[0], containerName, handleContainer);
				if(SKF.SKF_ERROR.SAR_OK != lRet)
				{
					JOptionPane.showMessageDialog(null, lRet);
					return;
				}
				
				ArrayList<Byte> cert = new ArrayList<Byte>();
				lRet = SKF.getInstance().ExportCert(handleContainer[0], true, cert);
				if(SKF.SKF_ERROR.SAR_OK != lRet)
				{
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					byte[] byteCert = new byte[cert.size()];
					for(int i = 0; i < cert.size(); i++ )
					{
						byteCert[i] = cert.get(i);
					}
					 
				}
				
				SKF.getInstance().ContainerClose(handleContainer[0]);
			}
		});
		btn_exportCert.setBounds(469, 148, 113, 27);
		panel_con.add(btn_exportCert);
		
		JButton btn_importCert = new JButton("\u5BFC\u5165");
		btn_importCert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String containerName = comboBox_containers.getSelectedItem().toString();
				
				if(containerName.isEmpty())
				{
					return;
				}
				
				long[] handleContainer = new long[1];
				long lRet = SKF.getInstance().ContainerOpen(handleApp[0], containerName, handleContainer);
				if(SKF.SKF_ERROR.SAR_OK != lRet)
				{
					JOptionPane.showMessageDialog(null, lRet);
					return;
				}
				
				try {
					KeyStore ks = Pfx.loadKeyStore(textField_pfxPath.getText(), textField_pfxPass.getText());
					
					String keyAlias = null;
					Enumeration enumas = ks.aliases();
					if (enumas.hasMoreElements()){
						keyAlias = (String) enumas.nextElement();
						System.out.println("alias=[" + keyAlias + "]");
					}

					Certificate cert = ks.getCertificate(keyAlias); 
					
					byte[] certData = cert.getEncoded();
					
					lRet = SKF.getInstance().ImportCert(handleContainer[0], true, certData);
					if( SKF.SKF_ERROR.SAR_OK != lRet)
					{
						JOptionPane.showMessageDialog(null, lRet);
						return;
					}
					

		            PublicKey pubkey = cert.getPublicKey();  
		            PrivateKey prikey = (PrivateKey) ks.getKey(keyAlias, textField_pfxPass.getText().toCharArray());  
		            
		            KeyFactory kf = KeyFactory.getInstance("RSA");
		            RSAPrivateCrtKeySpec KeyPrv = kf.getKeySpec(prikey,  RSAPrivateCrtKeySpec.class);
		            RSAPublicKeySpec KeyPub = kf.getKeySpec(pubkey, RSAPublicKeySpec.class);
		            
		            lRet = SKF.getInstance().ImportRSAPrv(handleContainer[0], true, KeyPrv.getModulus().toByteArray(), 
		            		KeyPrv.getPrimeP().toByteArray(), 
		            		KeyPrv.getPrimeQ().toByteArray(), 
		            		KeyPrv.getPrimeExponentP().toByteArray(), 
		            		KeyPrv.getPrimeExponentQ().toByteArray(), 
		            		KeyPrv.getCrtCoefficient().toByteArray());
					if( SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, lRet);
						return;
					}
					
					lRet = SKF.getInstance().ImportRSAPub(handleContainer[0], true, KeyPub.getPublicExponent().toByteArray(), KeyPub.getModulus().toByteArray());
					if( SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, lRet);
						return;
					}

					JOptionPane.showMessageDialog(null, "导入成功");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally
				{
					SKF.getInstance().ContainerClose(handleContainer[0]);
				}
			
			}
		});
		btn_importCert.setBounds(342, 148, 113, 27);
		panel_con.add(btn_importCert);
		
		textField_pfxPath = new JTextField();
		textField_pfxPath.setBounds(26, 115, 302, 24);
		panel_con.add(textField_pfxPath);
		textField_pfxPath.setColumns(10);
		
		JButton button_browser = new JButton("\u6D4F\u89C8");
		button_browser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFileChooser fd = new JFileChooser();  
			    //fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
			    fd.showOpenDialog(null);  
			    File f = fd.getSelectedFile();  
			    if(f != null){
			    	textField_pfxPath.setText(f.getPath());
			    }
			}
		});
		button_browser.setBounds(342, 115, 113, 27);
		panel_con.add(button_browser);
		
		textField_pfxPass = new JTextField();
		textField_pfxPass.setBounds(103, 149, 213, 24);
		panel_con.add(textField_pfxPass);
		textField_pfxPass.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8BC1\u4E66\u5BC6\u7801");
		label_3.setBounds(26, 152, 72, 18);
		panel_con.add(label_3);
		
		JButton button_sign = new JButton("\u7B7E\u540D");
		button_sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String containerName = comboBox_containers.getSelectedItem().toString();
				
				if(containerName.isEmpty())
				{
					return;
				}
				
				long[] handleContainer = new long[1];
				long lRet = SKF.getInstance().ContainerOpen(handleApp[0], containerName, handleContainer);
				if(SKF.SKF_ERROR.SAR_OK != lRet)
				{
					JOptionPane.showMessageDialog(null, lRet);
					return;
				}
//				byte[] data = textField_data.getText().getBytes();
				ArrayList<Byte> cipher = new ArrayList<Byte>();
				
				//数据需要与key长度同长
				byte[] data = new byte[256];
				for(int i = 0; i < data.length; i++ )
				{
					data[i] = (byte) (i&0xff);
				}
				
				//私钥运算
				lRet = SKF.getInstance().RSAEncrypt(handleContainer[0], true, data, cipher);
				if(SKF.SKF_ERROR.SAR_OK != lRet)
				{
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					
					byte[] byteCipher = new byte[cipher.size()];
					for(int i = 0; i < cipher.size(); i++ )
					{
						byteCipher[i] = cipher.get(i);
					}
					
					String strCipher = Pfx.byte2hex(byteCipher);
					System.out.println(strCipher);
					
					//公钥运算
					ArrayList<Byte> plain = new ArrayList<Byte>();
					lRet = SKF.getInstance().RSADecrypt(handleContainer[0], true, byteCipher, plain);
					if(SKF.SKF_ERROR.SAR_OK != lRet){
						JOptionPane.showMessageDialog(null, lRet);
					}else{
						byte[] bytePlain = new byte[plain.size()];
						for(int i = 0; i < plain.size(); i++ )
						{
							bytePlain[i] = plain.get(i);
						}
						
						String strPlain = Pfx.byte2hex(bytePlain);
						System.out.println(strPlain);
					}
				}
				
				SKF.getInstance().ContainerClose(handleContainer[0]);
	
			}
		});
		button_sign.setBounds(342, 203, 113, 27);
		panel_con.add(button_sign);
		
		btn_openApp = new JButton("\u6253\u5F00\u5E94\u7528");
		btn_openApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleApp = new long[1];
				long lRet = SKF.getInstance().OpenApp(handleDev[0], handleApp);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					JOptionPane.showMessageDialog(null, "打开应用成功");
				}
			}
		});
		btn_openApp.setBounds(283, 50, 113, 27);
		frame.getContentPane().add(btn_openApp);
		
		btn_closeApp = new JButton("\u5173\u95ED\u5E94\u7528");
		btn_closeApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long lRet = SKF.getInstance().CloseApp(handleApp[0]);
				if( SKF.SKF_ERROR.SAR_OK != lRet){
					JOptionPane.showMessageDialog(null, lRet);
				}else{
					JOptionPane.showMessageDialog(null, "关闭应用成功");
				}
			}
		});
		btn_closeApp.setBounds(409, 50, 113, 27);
		frame.getContentPane().add(btn_closeApp);
	}
}
