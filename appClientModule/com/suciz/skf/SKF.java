package com.suciz.skf;

import java.util.ArrayList;

/**
 * LYFUsbkey的提供的Jni接口
 * @author aisa
 *
 */
public class SKF {
	private static SKF _instance = new SKF();
	
	/**
	 * 返回唯一的SKF实例
	 * @return
	 */
	static SKF getInstance()
	{
		return _instance;
	}
	
	/**
	 * 错误号码列表
	 * @author aisa
	 *
	 */
	public static class SKF_ERROR
	{
		public static long SAR_OK							= 0x00000000;				//成功
		public static long SAR_FAIL						= 0x0A000001;				//失败
		public static long SAR_UNKNOWNERR					= 0x0A000002;				//异常错误
		public static long SAR_NOTSUPPORTYETERR			= 0x0A000003;				//不支持的服务
		public static long SAR_FILEERR						= 0x0A000004;				//文件操作错误
		public static long SAR_INVALIDHANDLEERR			= 0x0A000005;				//无效的句柄
		public static long SAR_INVALIDPARAMERR				= 0x0A000006;				//无效的参数
		public static long SAR_READFILEERR					= 0x0A000007;				//读文件错误
		public static long SAR_WRITEFILEERR				= 0x0A000008;				//写文件错误
		public static long SAR_NAMELENERR					= 0x0A000009;				//文件名称错误
		public static long SAR_KEYUSAGEERR					= 0x0A00000A;				//密钥用途错误
		public static long SAR_MODULUSLENERR				= 0x0A00000B;				//模的长度错误
		public static long SAR_NOTINITIALIZEERR			= 0x0A00000C;				//未初始化
		public static long SAR_OBJERR						= 0x0A00000D;				//对象错误
		public static long SAR_MEMORYERR					= 0x0A00000E;				//内存错误
		public static long SAR_TIMEOUTERR					= 0x0A00000F;				//超时
		public static long SAR_INDATALENERR				= 0x0A000010;				//输入数据长度错误
		public static long SAR_INDATAERR					= 0x0A000011;				//输入数据错误
		public static long SAR_GENRANDERR					= 0x0A000012;				//生成随机数错误
		public static long SAR_HASHOBJERR					= 0x0A000013;				//HASH对象错误
		public static long SAR_HASHERR						= 0x0A000014;				//HASH运算错误
		public static long SAR_GENRSAKEYRR					= 0x0A000015;				//产生RSA密钥错误
		public static long SAR_RSAMODULUSLENERR			= 0x0A000016;				//RSA密钥模长错误
		public static long SAR_CSPIMPRTPUBKEYERR			= 0x0A000017;				//CSP服务导入公钥错误
		public static long SAR_RSAENCERR					= 0x0A000018;				//RSA加密错误
		public static long SAR_RSADECERR					= 0x0A000019;				//RSA解密错误
		public static long SAR_HASHNOTEQUALERR				= 0x0A00001A;				//HASH值不相等
		public static long SAR_KEYNOTFOUNDERR				= 0x0A00001B;				//密钥未发现
		public static long SAR_CERTNOTFOUNDERR				= 0x0A00001C;				//证书未发现
		public static long SAR_NOTEXPORTERR				= 0x0A00001D;				//对象未导出
		public static long SAR_DECRYPTPADERR				= 0x0A00001E;				//解密时做补丁错误
		public static long SAR_MACLENERR					= 0x0A00001F;				//MAC长度错误
		public static long SAR_BUFFER_TOO_SMALL			= 0x0A000020;				//缓冲区不足
		public static long SAR_KEYINFOTYPEERR				= 0x0A000021;				//密钥类型错误
		public static long SAR_NOT_EVENTERR				= 0x0A000022;				//无事件错误
		public static long SAR_DEVICE_REMOVED				= 0x0A000023;				//设备已移除
		public static long SAR_PIN_INCORRECT				= 0x0A000024;				//PIN不正确
		public static long SAR_PIN_LOCKED					= 0x0A000025;				//PIN被锁死
		public static long SAR_PIN_INVALID					= 0x0A000026;				//PIN无效
		public static long SAR_PIN_LEN_RANGE				= 0x0A000027;				//PIN长度错误
		public static long SAR_USER_ALREADY_LOGGED_IN		= 0x0A000028;				//用户已经登录
		public static long SAR_USER_PIN_NOT_INITIALIZED	= 0x0A000029;				//没有初始化用户口令
		public static long SAR_USER_TYPE_INVALID			= 0x0A00002A;				//PIN类型错误
		public static long SAR_APPLICATION_NAME_INVALID	= 0x0A00002B;				//应用名称无效
		public static long SAR_APPLICATION_EXISTS			= 0x0A00002C;				//应用已经存在
		public static long SAR_USER_NOT_LOGGED_IN			= 0x0A00002D;				//用户没有登录
		public static long SAR_APPLICATION_NOT_EXISTS		= 0x0A00002E;				//应用不存在
		public static long SAR_FILE_ALREADY_EXIST			= 0x0A00002F;				//文件已经存在
		public static long SAR_NO_ROOM						= 0x0A000030;				//空间不足
		public static long SAR_FILE_NOT_EXIST				= 0x0A000031;				//文件不存在
		public static long SAR_FILE_NAME_INVALID			= 0x0A000032;				//文件名无效
		public static long SAR_DATA_LEN_RANGE				= 0x0A000033;				//数据长度错误
		public static long SAR_INSUFFICIENT_PRIVILEGES		= 0x0A000034;				//操作权限不足
		public static long SAR_CHECKINFO_FAIL				= 0x0A000035;				//日志读写错误
		public static long SAR_CANCEL						= 0x0A000036;				//取消操作
		// Add extern return value
		public static long SAR_IMPORTKEYERR				= 0x0A000031;	// 导入密钥错误
		public static long SAR_GENERATESYMKEYERR			= 0x0A000032;	// 生成对称密钥错误
		public static long SAR_CONTAINER_ALREADY_EXIST		= 0x0A000033;	// 容器已经存在
		public static long SAR_CONTAINER_NOT_EXIST			= 0x0A000034;	// 容器不存在
		public static long SAR_CONTAINER_NOT_OPEN			= 0x0A000035;	// 容器没有打开
		public static long SAR_CONTAINER_ALREADY_OPEN		= 0x0A000036;	// 容器已经打开

		//App Error
		public static long SAR_NO_FOUND_APP				= 0x8A000001;	//未发现应用
		public static long SAR_NO_FOUND_CONTAINER			= 0x8A000002;  //未发现容器

		public static long SAR_NO_DEVICE_AVAILABEL			= 0x8A000040;	//未找到设备
		
	}
	
	/**
	 * Pin类型
	 * @author aisa
	 *
	 */
	public static class SKF_PinType
	{
		/**
		 * 管理员PIN类型
		 */
		public static long ADMIN_TYPE = 0;
		/**
		 * 用户PIN类型
		 */
		public static long USER_TYPE = 1;
	}
	
	public static class SKF_Secure_Right
	{
		/**
		 * 不允许
		 */
		static public long NO_RIGHT = 0xEF;
		/**
		 * 管理员权限
		 */
		static public long SO_RIGTH = 0x33;
		/**
		 * 用户权限
		 */
		static public long USER_RIGHT = 0x22;
		/**
		 * 任何人
		 */
		static public long EVERY_RIGHT = 0xF0;
	}

	public static class SKF_Version
	{
		public byte major;
		public byte minor;
	}

	/**
	 * 设备信息，可以通过<code>GetDevInfo</code>来获取
	 * @author aisa
	 *
	 */
	public static class SKF_DevInfo {
		/**
		 * 数据结构版本号
		 */
		public SKF_Version version;
		/**
		 * 设备厂商信息
		 */
		public byte[] Manufacturer;
		/**
		 * 发行厂商信息
		 */
		public byte[] Issuer;
		/**
		 * 设备标签
		 */
		public byte[] Label;
		/**
		 * 序列号
		 */
		public byte[] serialNumber;
		/**
		 * 设备硬件版本
		 */
		public SKF_Version HWVersion;
		/**
		 * 设备固件版本
		 */
		public SKF_Version FirmwareVersion;
	}
	
	/**
	 * 文件属性
	 * @author aisa
	 *
	 */
	public static class SKF_FileAttribute {
		/**
		 * 文件名
		 */
		public String FileName;
		/**
		 * 创建文件时定义的文件大小
		 */
		public long FileSize;
		/**
		 * 读取文件需要的权限
		 */
		public long ReadRights;
		/**
		 * 写入文件需要的权限
		 */
		public long WriteRights;
	}

	/**
	 * 一个用于接收SKF硬件事件的抽象类，这个类里方法的实现都是空的
	 * <p>
	 * 这个类的存在原因在于方便实现创建监听类
	 * <p>
	 * 创建一个继承该类的监听类，并重写感兴趣的方法，然后创建一个对象，使用{@link #com.suciz.skf.SKF.SetEventHandler(EventHandler eh) SetEventHandler}方法来注册它
	 * <p>
	 * 这样，当有设备插入，移除或调用SKF.Finalize时，相关的方法会被调用

	 * @author aisa
	 * @see SKF.SetEventHandler
	 */
	public static abstract class EventHandler
	{
		/**
		 * 设备插入时调用
		 */
		public void onInsert(String devName){};	
		/**
		 * 设备移除时调用
		 * @param devName
		 */
		public void onRemove(String devName){};
		/**
		 * <code>SKF.Finalize</code>时调用
		 */
		public void onFinalize(){};
	};
	
	/**
	 * 必须在其它函数之前调用
	 * @return
	 */
	public native long Initialize();
	/**
	 * 不再使用SKF方法时或程序退出调用，清除资源
	 * @return
	 */
	public native long Finalize();

	/**
	 * 设置事件对象，用于响应设备插入移除事件
	 * @see EventHandler
	 */
	public native long SetEventHandler(EventHandler eh);
	
	/**
	 * 枚举当前设备，listDevName不能为空
	 * <p>
	 * bPresent为true时，只枚举当前存在的设备
	 * 
	 * @param bPresent [IN] 为true表示取当前设备状态为存在的设备列表。为false表示取当前驱动支持的设备列表。
	 * @param listDevName [OUT] 设备名称列表,不能为空
	 * @return 错误号，
	 * @see SKF_ERROR
	 */
	public native long EnumDev(boolean bPresent, ArrayList<String> listDevName); 
	
	/**
	 * 查看设备状态
	 * <p>
	 * 未实现
	 * @param devName，设备名
	 * @param pulDevState， 设备状态
	 * @return 0，设备不存在；1，设备存在，2，设备状态未知
	 */
	public native long GetDevState(final String devName, long[] pulDevState);
	
	/**
	 * 连接设备，并返回句柄
	 * 
	 * @param devName  [IN] 设备名称。
	 * @param handleDev [OUT] 返回设备操作句柄。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long Connect(final String devName, long[] handleDev);
	
	/**
	 * 关闭打开的设备
	 * @param handleDev [IN] 连接设备时返回的设备句柄。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long Disconnect(long handleDev);
	
	/**
	 * 设置设备标签
	 * @param handleDev  [IN] 连接设备时返回的设备句柄。
	 * @param label  [IN] 设备标签字符串。该字符串应小于32字节。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long SetLabel(long handleDev, final String label);
	
	/**
	 * 获取设备信息，devInfo不能为null
	 * @param handleDev  [IN] 连接设备时返回的设备句柄。
	 * @param devInfo    [OUT] 返回设备信息,不能为空
	 * @return 错误号
	 * @see SKF_ERROR
	 * @see SKF_DevInfo
	 */
	public native long GetDevInfo(long handleDev, SKF_DevInfo devInfo);

	/**
	 * 打开默认应用
	 * @param handleDev  [IN] 连接设备时返回的设备句柄。
	 * @param handleApp  [OUT] 应用的句柄。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long OpenApp(long handleDev, long[] handleApp);
	
	/**
	 * 关闭应用
	 * @param handleApp  [IN]应用句柄。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long CloseApp(long handleApp);
	
	/**
	 * 获取PIN码信息，包括最大重试次数、当前剩余重试次数，以及当前PIN码是否为出厂默认PIN码。
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.ADMIN_TYPE}	0	管理员PIN类型
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.USER_TYPE}  1	用户PIN类型
	 * <p>
	 * @param handleApp 应用句柄
	 * @param pinType PIN类型。
	 * @param retryCountMax 最大重试次数。
	 * @param retryCountRemain 当前剩余重试次数，当为0时表示已锁死。
	 * @param defaultPin 是否为出厂默认PIN码。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long GetPINInfo(long handleApp, long pinType, long[] retryCountMax, long[] retryCountRemain, boolean[] defaultPin);
	
	/**
	 * 调用该函数可以修改Administrator PIN和User PIN的值。
	 * <p>
	 * 如果原PIN码错误导致验证失败，该函数会返回相应PIN码的剩余重试次数，当剩余次数为0时，表示PIN已经被锁死。	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.ADMIN_TYPE}	0	管理员PIN类型
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.USER_TYPE}  1	用户PIN类型
	 * <p>
	 * @param handleApp [IN] 应用句柄。
	 * @param pinType  [IN] PIN类型，可为ADMIN_TYPE或USER_TYPE。
	 * @param pinOld   [IN] 原PIN值。
	 * @param pinNew   [IN] 新PIN值。
	 * @param retryCount [OUT] 出错后重试次数。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long ChangePIN(long handleApp, long pinType, final byte[] pinOld, final byte[] pinNew, long[] retryCount);
	
	/**
	 * 校验PIN码。校验成功后，会获得相应的权限，如果PIN码错误，会返回PIN码的重试次数，当重试次数为0时表示PIN码已经锁死。
	 * 
	 * @param handleApp [IN] 应用句柄。
	 * @param pinType   [IN] PIN类型。
	 * @param pin       [IN] PIN值。
	 * @param retryCount [OUT] 出错后返回的重试次数。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long VerifyPIN(long handleApp, long pinType, final byte[] pin, long[] retryCount);
	
	/**
	 * 当用户的PIN码锁死后，通过调用该函数来解锁用户PIN码。
	 * <p>
	 * 解锁后，用户PIN码被设置成新值，用户PIN码的重试次数也恢复到原值。
	 * 
	 * @param handleApp   [IN] 应用句柄。
	 * @param pinAdm      [IN] 管理员PIN码。
	 * @param pinUserNew  [IN] 新的用户PIN码。
	 * @param retryCount  [OUT] 管理员PIN码错误时，返回剩余重试次数。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long UnblockPIN(long handleApp, final byte[] pinAdm, final byte[] pinUserNew, long[] retryCount);
	
	/**
	 * 清除应用当前的安全状态。
	 * @param handleApp [IN] 应用句柄。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long ClearSecureState(long handleApp);

	//////////文件管理
	/**
	 * 枚举一个应用下存在的所有文件。
	 * @param handleApp    [IN] 应用句柄。
	 * @param listFileName [OUT] 返回文件名称列表
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long FileEnum(long handleApp, ArrayList<String> listFileName);
	
	/**
	 * 创建文件时要指定文件的名称，大小，以及文件的读写权限。
	 * @param handleApp  [IN] 应用句柄。
	 * @param fileName   [IN] 文件名称，长度不得大于32个字节。
	 * @param fileSize   [IN] 文件大小。
	 * @param rightRead  [IN] 文件读权限，参见{@link #com.suciz.skf.SKF.SKF_Secure_Account 权限类型}。
	 * @param rightWrite [IN] 文件写权限，参见{@link #com.suciz.skf.SKF.SKF_Secure_Account 权限类型}。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long FileCreate(long handleApp, final String fileName, long fileSize, long rightRead, long rightWrite);
	
	/**
	 * 删除指定文件：
	 * <p>
	 * 文件删除后，文件中写入的所有信息将丢失。
	 * <p>
	 * 文件在设备中的占用的空间将被释放。
	 * @param handleApp [IN] 要删除文件所在的应用句柄。
	 * @param fileName  [IN] 要删除文件的名称。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long FileDelete(long handleApp, final String fileName);
	
	/**
	 * 获取文件信息：
	 * <p>
	 * 获取应用文件的属性信息，例如文件的大小、权限等。
	 * @param handleApp  [IN] 文件所在应用的句柄。
	 * @param fileName   [IN] 文件名称。
	 * @param pFileInfo  [OUT] 文件信息,不能为空
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 * @see SKF_FileAttribute
	 */
	public native long FileGetInfo(long handleApp, final String fileName, SKF_FileAttribute pFileInfo);
	
	/**
	 * 读取文件内容。
	 * @param handleApp  [IN] 应用句柄。
	 * @param fileName   [IN] 文件名。
	 * @param offset     [IN] 文件读取偏移位置。
	 * @param size       [IN] 要读取的长度。
	 * @param dataRead   [OUT] 读取的数据
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long FileRead(long handleApp, final String fileName, long offset, long size, ArrayList<Byte> data);
	
	/**
	 * 写数据到文件中。
	 * @param handleApp  [IN] 应用句柄。
	 * @param fileName   [IN] 文件名。
	 * @param offset     [IN] 写入文件的偏移量。
	 * @param data       [IN] 写入数据
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long FileWrite(long handleApp, final String fileName, long offset, final byte[] data);
	
	////////容器管理
	/**
	 * 枚举应用下的所有容器并返回容器名称列表。
	 * @param handleApp 应用句柄。
	 * @param listContainerName 指向容器名称列表缓冲区。 
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerEnum(long handleApp, ArrayList<String> listContainerName);
	
	/**
	 * 在应用下建立指定名称的容器并返回容器句柄。权限要求：需要用户权限。
	 * @param handleApp [IN] 应用句柄。
	 * @param containerName 表示所建立容器的名称，容器名称的最大长度不能超过64字节。
	 * @param handleContainer [OUT] 返回所建立容器的容器句柄。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerCreate(long handleApp, final String containerName, long[] handleContainer);
	
	/**
	 * 在应用下删除指定名称的容器并释放容器相关的资源。权限要求：需要用户权限。
	 * @param handleApp [IN] 应用句柄。 
	 * @param containerName [IN] 指向删除容器的名称。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerDelete(long handleApp, final String containerName);
	
	/**
	 * 获取容器句柄。
	 * @param handleApp [IN] 应用句柄。
	 * @param containerName [IN] 容器的名称。
	 * @param handleContainer [OUT] 返回所打开容器的句柄。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerOpen(long handleApp, final String containerName, long[] handleContainer);
	
	/**
	 * 关闭容器句柄，并释放容器句柄相关资源。
	 * @param handleContainer [IN] 容器句柄。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerClose(long handleContainer);

	//容器操作

	/**
	 * 获取容器的类型
	 * @param handleContainer [IN] 容器句柄。
	 * @param containerType [OUT] 获得的容器类型。指针指向的值为0表示未定、尚未分配类型或者为空容器，为1表示为RSA容器，为2表示为ECC容器。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ContainerGetType(long handleContainer, long[] containerType);
	
	/**
	 * 向容器内导入数字证书。
	 * @param handleContainer [IN] 容器句柄。
	 * @param bSignFlag [IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param certData [IN] 指向证书内容缓冲区。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
 */
	public native long ImportCert(long handleContainer, boolean bSignFlag, final byte[] certData);
	
	/**
	 * 从容器内导出数字证书。
	 * @param handleContainer [IN] 容器句柄。
	 * @param bSignFlag [IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param certData [IN]用于接收返回数据，这里把数据转换为ArrayList<Byte>返回。
	 * @return 错误号, SAR_OK成功
	 * @see SKF_ERROR
	 */
	public native long ExportCert(long handleContainer, boolean bSignFlag, ArrayList<Byte> certData);
	
	//密码服务
	/**
	 * 产生指定长度的随机数。长度为4，8，16有效
	 * @param handleDev  [IN] 设备句柄。
	 * @param dataRandom [IN, OUT] 返回随机数。
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long GenRandom(long handleDev, byte[] dataRandom);

	/**
	 * 导入公钥到容器
	 * @param handleContainer [IN] 容器句柄
	 * @param bSignFlag	[IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param exponent  [IN] 公钥参数，e
	 * @param modulus	[IN] 公钥参数，modulus
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long ImportRSAPub(long handleContainer, boolean bSignFlag, final byte[] exponent, final byte[] modulus);
	/**
	 * 导入私钥到容器
	 * @param handleContainer [IN] 容器句柄
	 * @param bSignFlag [IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param modulus	[IN] 私钥参数 modulus
	 * @param p			[IN] 私钥参数 PrimeP
	 * @param q			[IN] 私钥参数 PrimeQ
	 * @param dp		[IN] 私钥参数 PrimeExponentP
	 * @param dq		[IN] 私钥参数 PrimeExponentQ
	 * @param u			[IN] 私钥参数 CrtCoefficient
	 * @return 错误号
	 * @see SKF_ERROR
	 */
	public native long ImportRSAPrv(long handleContainer, boolean bSignFlag, final byte[] modulus, final byte[] p, final byte[] q, final byte[] dp, final byte[] dq, final byte[] u);
	
	/**
	 * 私钥运算，私钥计算与私钥等长的数据，支持1024位和2048位密钥
	 * <p>
	 * 1024位私钥计算128字节的数据,2048位私钥计算256字节的数据
	 * <p>
	 * 该函数仅进行私钥运算，不执行数据填充等功能，输出与输入等长
	 * <p>
	 * 可以在此函数基础上实现标准的PKI签名接口
	 * @param handleContainer [IN] 容器句柄
	 * @param bSignFlag [IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param plain [IN] 明文
	 * @param cipher [OUT] 密文
	 * @return
	 */
	public native long RSAEncrypt(long handleContainer, boolean bSignFlag, final byte[] plain, ArrayList<Byte> cipher);
	
	/**
	 * 公钥运算，公钥计算与公钥等长的数据，支持1024位和2048位和密钥
	 * <p>
	 * 1024位公钥计算128位字节的数据，2048位公钥计算256字节的数据
	 * <p>
	 * 该函数仅进行公钥计算，不执行数据去填充等功能，输出与输入等长
	 * <p>
	 * 可以在此函数基础上实现标准的PKI签名验证接口
	 * @param handleContainer [IN] 容器句柄
	 * @param bSignFlag [IN] TRUE表示签名证书，FALSE表示加密证书。
	 * @param cipher [IN] 明文
	 * @param plain [OUT] 密文
	 * @return
	 */
	public native long RSADecrypt(long handleContainer, boolean bSignFlag, final byte[] cipher, ArrayList<Byte> plain);
	
	static{
		System.loadLibrary("tokenh_javaDll");
	}
}
