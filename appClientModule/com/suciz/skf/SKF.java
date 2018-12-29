package com.suciz.skf;

import java.util.ArrayList;

/**
 * LYFUsbkey���ṩ��Jni�ӿ�
 * @author aisa
 *
 */
public class SKF {
	private static SKF _instance = new SKF();
	
	/**
	 * ����Ψһ��SKFʵ��
	 * @return
	 */
	static SKF getInstance()
	{
		return _instance;
	}
	
	/**
	 * ��������б�
	 * @author aisa
	 *
	 */
	public static class SKF_ERROR
	{
		public static long SAR_OK							= 0x00000000;				//�ɹ�
		public static long SAR_FAIL						= 0x0A000001;				//ʧ��
		public static long SAR_UNKNOWNERR					= 0x0A000002;				//�쳣����
		public static long SAR_NOTSUPPORTYETERR			= 0x0A000003;				//��֧�ֵķ���
		public static long SAR_FILEERR						= 0x0A000004;				//�ļ���������
		public static long SAR_INVALIDHANDLEERR			= 0x0A000005;				//��Ч�ľ��
		public static long SAR_INVALIDPARAMERR				= 0x0A000006;				//��Ч�Ĳ���
		public static long SAR_READFILEERR					= 0x0A000007;				//���ļ�����
		public static long SAR_WRITEFILEERR				= 0x0A000008;				//д�ļ�����
		public static long SAR_NAMELENERR					= 0x0A000009;				//�ļ����ƴ���
		public static long SAR_KEYUSAGEERR					= 0x0A00000A;				//��Կ��;����
		public static long SAR_MODULUSLENERR				= 0x0A00000B;				//ģ�ĳ��ȴ���
		public static long SAR_NOTINITIALIZEERR			= 0x0A00000C;				//δ��ʼ��
		public static long SAR_OBJERR						= 0x0A00000D;				//�������
		public static long SAR_MEMORYERR					= 0x0A00000E;				//�ڴ����
		public static long SAR_TIMEOUTERR					= 0x0A00000F;				//��ʱ
		public static long SAR_INDATALENERR				= 0x0A000010;				//�������ݳ��ȴ���
		public static long SAR_INDATAERR					= 0x0A000011;				//�������ݴ���
		public static long SAR_GENRANDERR					= 0x0A000012;				//�������������
		public static long SAR_HASHOBJERR					= 0x0A000013;				//HASH�������
		public static long SAR_HASHERR						= 0x0A000014;				//HASH�������
		public static long SAR_GENRSAKEYRR					= 0x0A000015;				//����RSA��Կ����
		public static long SAR_RSAMODULUSLENERR			= 0x0A000016;				//RSA��Կģ������
		public static long SAR_CSPIMPRTPUBKEYERR			= 0x0A000017;				//CSP�����빫Կ����
		public static long SAR_RSAENCERR					= 0x0A000018;				//RSA���ܴ���
		public static long SAR_RSADECERR					= 0x0A000019;				//RSA���ܴ���
		public static long SAR_HASHNOTEQUALERR				= 0x0A00001A;				//HASHֵ�����
		public static long SAR_KEYNOTFOUNDERR				= 0x0A00001B;				//��Կδ����
		public static long SAR_CERTNOTFOUNDERR				= 0x0A00001C;				//֤��δ����
		public static long SAR_NOTEXPORTERR				= 0x0A00001D;				//����δ����
		public static long SAR_DECRYPTPADERR				= 0x0A00001E;				//����ʱ����������
		public static long SAR_MACLENERR					= 0x0A00001F;				//MAC���ȴ���
		public static long SAR_BUFFER_TOO_SMALL			= 0x0A000020;				//����������
		public static long SAR_KEYINFOTYPEERR				= 0x0A000021;				//��Կ���ʹ���
		public static long SAR_NOT_EVENTERR				= 0x0A000022;				//���¼�����
		public static long SAR_DEVICE_REMOVED				= 0x0A000023;				//�豸���Ƴ�
		public static long SAR_PIN_INCORRECT				= 0x0A000024;				//PIN����ȷ
		public static long SAR_PIN_LOCKED					= 0x0A000025;				//PIN������
		public static long SAR_PIN_INVALID					= 0x0A000026;				//PIN��Ч
		public static long SAR_PIN_LEN_RANGE				= 0x0A000027;				//PIN���ȴ���
		public static long SAR_USER_ALREADY_LOGGED_IN		= 0x0A000028;				//�û��Ѿ���¼
		public static long SAR_USER_PIN_NOT_INITIALIZED	= 0x0A000029;				//û�г�ʼ���û�����
		public static long SAR_USER_TYPE_INVALID			= 0x0A00002A;				//PIN���ʹ���
		public static long SAR_APPLICATION_NAME_INVALID	= 0x0A00002B;				//Ӧ��������Ч
		public static long SAR_APPLICATION_EXISTS			= 0x0A00002C;				//Ӧ���Ѿ�����
		public static long SAR_USER_NOT_LOGGED_IN			= 0x0A00002D;				//�û�û�е�¼
		public static long SAR_APPLICATION_NOT_EXISTS		= 0x0A00002E;				//Ӧ�ò�����
		public static long SAR_FILE_ALREADY_EXIST			= 0x0A00002F;				//�ļ��Ѿ�����
		public static long SAR_NO_ROOM						= 0x0A000030;				//�ռ䲻��
		public static long SAR_FILE_NOT_EXIST				= 0x0A000031;				//�ļ�������
		public static long SAR_FILE_NAME_INVALID			= 0x0A000032;				//�ļ�����Ч
		public static long SAR_DATA_LEN_RANGE				= 0x0A000033;				//���ݳ��ȴ���
		public static long SAR_INSUFFICIENT_PRIVILEGES		= 0x0A000034;				//����Ȩ�޲���
		public static long SAR_CHECKINFO_FAIL				= 0x0A000035;				//��־��д����
		public static long SAR_CANCEL						= 0x0A000036;				//ȡ������
		// Add extern return value
		public static long SAR_IMPORTKEYERR				= 0x0A000031;	// ������Կ����
		public static long SAR_GENERATESYMKEYERR			= 0x0A000032;	// ���ɶԳ���Կ����
		public static long SAR_CONTAINER_ALREADY_EXIST		= 0x0A000033;	// �����Ѿ�����
		public static long SAR_CONTAINER_NOT_EXIST			= 0x0A000034;	// ����������
		public static long SAR_CONTAINER_NOT_OPEN			= 0x0A000035;	// ����û�д�
		public static long SAR_CONTAINER_ALREADY_OPEN		= 0x0A000036;	// �����Ѿ���

		//App Error
		public static long SAR_NO_FOUND_APP				= 0x8A000001;	//δ����Ӧ��
		public static long SAR_NO_FOUND_CONTAINER			= 0x8A000002;  //δ��������

		public static long SAR_NO_DEVICE_AVAILABEL			= 0x8A000040;	//δ�ҵ��豸
		
	}
	
	/**
	 * Pin����
	 * @author aisa
	 *
	 */
	public static class SKF_PinType
	{
		/**
		 * ����ԱPIN����
		 */
		public static long ADMIN_TYPE = 0;
		/**
		 * �û�PIN����
		 */
		public static long USER_TYPE = 1;
	}
	
	public static class SKF_Secure_Right
	{
		/**
		 * ������
		 */
		static public long NO_RIGHT = 0xEF;
		/**
		 * ����ԱȨ��
		 */
		static public long SO_RIGTH = 0x33;
		/**
		 * �û�Ȩ��
		 */
		static public long USER_RIGHT = 0x22;
		/**
		 * �κ���
		 */
		static public long EVERY_RIGHT = 0xF0;
	}

	public static class SKF_Version
	{
		public byte major;
		public byte minor;
	}

	/**
	 * �豸��Ϣ������ͨ��<code>GetDevInfo</code>����ȡ
	 * @author aisa
	 *
	 */
	public static class SKF_DevInfo {
		/**
		 * ���ݽṹ�汾��
		 */
		public SKF_Version version;
		/**
		 * �豸������Ϣ
		 */
		public byte[] Manufacturer;
		/**
		 * ���г�����Ϣ
		 */
		public byte[] Issuer;
		/**
		 * �豸��ǩ
		 */
		public byte[] Label;
		/**
		 * ���к�
		 */
		public byte[] serialNumber;
		/**
		 * �豸Ӳ���汾
		 */
		public SKF_Version HWVersion;
		/**
		 * �豸�̼��汾
		 */
		public SKF_Version FirmwareVersion;
	}
	
	/**
	 * �ļ�����
	 * @author aisa
	 *
	 */
	public static class SKF_FileAttribute {
		/**
		 * �ļ���
		 */
		public String FileName;
		/**
		 * �����ļ�ʱ������ļ���С
		 */
		public long FileSize;
		/**
		 * ��ȡ�ļ���Ҫ��Ȩ��
		 */
		public long ReadRights;
		/**
		 * д���ļ���Ҫ��Ȩ��
		 */
		public long WriteRights;
	}

	/**
	 * һ�����ڽ���SKFӲ���¼��ĳ����࣬������﷽����ʵ�ֶ��ǿյ�
	 * <p>
	 * �����Ĵ���ԭ�����ڷ���ʵ�ִ���������
	 * <p>
	 * ����һ���̳и���ļ����࣬����д����Ȥ�ķ�����Ȼ�󴴽�һ������ʹ��{@link #com.suciz.skf.SKF.SetEventHandler(EventHandler eh) SetEventHandler}������ע����
	 * <p>
	 * �����������豸���룬�Ƴ������SKF.Finalizeʱ����صķ����ᱻ����

	 * @author aisa
	 * @see SKF.SetEventHandler
	 */
	public static abstract class EventHandler
	{
		/**
		 * �豸����ʱ����
		 */
		public void onInsert(String devName){};	
		/**
		 * �豸�Ƴ�ʱ����
		 * @param devName
		 */
		public void onRemove(String devName){};
		/**
		 * <code>SKF.Finalize</code>ʱ����
		 */
		public void onFinalize(){};
	};
	
	/**
	 * ��������������֮ǰ����
	 * @return
	 */
	public native long Initialize();
	/**
	 * ����ʹ��SKF����ʱ������˳����ã������Դ
	 * @return
	 */
	public native long Finalize();

	/**
	 * �����¼�����������Ӧ�豸�����Ƴ��¼�
	 * @see EventHandler
	 */
	public native long SetEventHandler(EventHandler eh);
	
	/**
	 * ö�ٵ�ǰ�豸��listDevName����Ϊ��
	 * <p>
	 * bPresentΪtrueʱ��ֻö�ٵ�ǰ���ڵ��豸
	 * 
	 * @param bPresent [IN] Ϊtrue��ʾȡ��ǰ�豸״̬Ϊ���ڵ��豸�б�Ϊfalse��ʾȡ��ǰ����֧�ֵ��豸�б�
	 * @param listDevName [OUT] �豸�����б�,����Ϊ��
	 * @return ����ţ�
	 * @see SKF_ERROR
	 */
	public native long EnumDev(boolean bPresent, ArrayList<String> listDevName); 
	
	/**
	 * �鿴�豸״̬
	 * <p>
	 * δʵ��
	 * @param devName���豸��
	 * @param pulDevState�� �豸״̬
	 * @return 0���豸�����ڣ�1���豸���ڣ�2���豸״̬δ֪
	 */
	public native long GetDevState(final String devName, long[] pulDevState);
	
	/**
	 * �����豸�������ؾ��
	 * 
	 * @param devName  [IN] �豸���ơ�
	 * @param handleDev [OUT] �����豸���������
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long Connect(final String devName, long[] handleDev);
	
	/**
	 * �رմ򿪵��豸
	 * @param handleDev [IN] �����豸ʱ���ص��豸�����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long Disconnect(long handleDev);
	
	/**
	 * �����豸��ǩ
	 * @param handleDev  [IN] �����豸ʱ���ص��豸�����
	 * @param label  [IN] �豸��ǩ�ַ��������ַ���ӦС��32�ֽڡ�
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long SetLabel(long handleDev, final String label);
	
	/**
	 * ��ȡ�豸��Ϣ��devInfo����Ϊnull
	 * @param handleDev  [IN] �����豸ʱ���ص��豸�����
	 * @param devInfo    [OUT] �����豸��Ϣ,����Ϊ��
	 * @return �����
	 * @see SKF_ERROR
	 * @see SKF_DevInfo
	 */
	public native long GetDevInfo(long handleDev, SKF_DevInfo devInfo);

	/**
	 * ��Ĭ��Ӧ��
	 * @param handleDev  [IN] �����豸ʱ���ص��豸�����
	 * @param handleApp  [OUT] Ӧ�õľ����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long OpenApp(long handleDev, long[] handleApp);
	
	/**
	 * �ر�Ӧ��
	 * @param handleApp  [IN]Ӧ�þ����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long CloseApp(long handleApp);
	
	/**
	 * ��ȡPIN����Ϣ������������Դ�������ǰʣ�����Դ������Լ���ǰPIN���Ƿ�Ϊ����Ĭ��PIN�롣
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.ADMIN_TYPE}	0	����ԱPIN����
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.USER_TYPE}  1	�û�PIN����
	 * <p>
	 * @param handleApp Ӧ�þ��
	 * @param pinType PIN���͡�
	 * @param retryCountMax ������Դ�����
	 * @param retryCountRemain ��ǰʣ�����Դ�������Ϊ0ʱ��ʾ��������
	 * @param defaultPin �Ƿ�Ϊ����Ĭ��PIN�롣
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long GetPINInfo(long handleApp, long pinType, long[] retryCountMax, long[] retryCountRemain, boolean[] defaultPin);
	
	/**
	 * ���øú��������޸�Administrator PIN��User PIN��ֵ��
	 * <p>
	 * ���ԭPIN���������֤ʧ�ܣ��ú����᷵����ӦPIN���ʣ�����Դ�������ʣ�����Ϊ0ʱ����ʾPIN�Ѿ���������	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.ADMIN_TYPE}	0	����ԱPIN����
	 * <p>
	 * {@link #com.suciz.skf.SKF.SKF_PinType.ADMIN_TYPE SKF.PinType.USER_TYPE}  1	�û�PIN����
	 * <p>
	 * @param handleApp [IN] Ӧ�þ����
	 * @param pinType  [IN] PIN���ͣ���ΪADMIN_TYPE��USER_TYPE��
	 * @param pinOld   [IN] ԭPINֵ��
	 * @param pinNew   [IN] ��PINֵ��
	 * @param retryCount [OUT] ��������Դ�����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long ChangePIN(long handleApp, long pinType, final byte[] pinOld, final byte[] pinNew, long[] retryCount);
	
	/**
	 * У��PIN�롣У��ɹ��󣬻�����Ӧ��Ȩ�ޣ����PIN����󣬻᷵��PIN������Դ����������Դ���Ϊ0ʱ��ʾPIN���Ѿ�������
	 * 
	 * @param handleApp [IN] Ӧ�þ����
	 * @param pinType   [IN] PIN���͡�
	 * @param pin       [IN] PINֵ��
	 * @param retryCount [OUT] ����󷵻ص����Դ�����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long VerifyPIN(long handleApp, long pinType, final byte[] pin, long[] retryCount);
	
	/**
	 * ���û���PIN��������ͨ�����øú����������û�PIN�롣
	 * <p>
	 * �������û�PIN�뱻���ó���ֵ���û�PIN������Դ���Ҳ�ָ���ԭֵ��
	 * 
	 * @param handleApp   [IN] Ӧ�þ����
	 * @param pinAdm      [IN] ����ԱPIN�롣
	 * @param pinUserNew  [IN] �µ��û�PIN�롣
	 * @param retryCount  [OUT] ����ԱPIN�����ʱ������ʣ�����Դ�����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long UnblockPIN(long handleApp, final byte[] pinAdm, final byte[] pinUserNew, long[] retryCount);
	
	/**
	 * ���Ӧ�õ�ǰ�İ�ȫ״̬��
	 * @param handleApp [IN] Ӧ�þ����
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long ClearSecureState(long handleApp);

	//////////�ļ�����
	/**
	 * ö��һ��Ӧ���´��ڵ������ļ���
	 * @param handleApp    [IN] Ӧ�þ����
	 * @param listFileName [OUT] �����ļ������б�
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long FileEnum(long handleApp, ArrayList<String> listFileName);
	
	/**
	 * �����ļ�ʱҪָ���ļ������ƣ���С���Լ��ļ��Ķ�дȨ�ޡ�
	 * @param handleApp  [IN] Ӧ�þ����
	 * @param fileName   [IN] �ļ����ƣ����Ȳ��ô���32���ֽڡ�
	 * @param fileSize   [IN] �ļ���С��
	 * @param rightRead  [IN] �ļ���Ȩ�ޣ��μ�{@link #com.suciz.skf.SKF.SKF_Secure_Account Ȩ������}��
	 * @param rightWrite [IN] �ļ�дȨ�ޣ��μ�{@link #com.suciz.skf.SKF.SKF_Secure_Account Ȩ������}��
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long FileCreate(long handleApp, final String fileName, long fileSize, long rightRead, long rightWrite);
	
	/**
	 * ɾ��ָ���ļ���
	 * <p>
	 * �ļ�ɾ�����ļ���д���������Ϣ����ʧ��
	 * <p>
	 * �ļ����豸�е�ռ�õĿռ佫���ͷš�
	 * @param handleApp [IN] Ҫɾ���ļ����ڵ�Ӧ�þ����
	 * @param fileName  [IN] Ҫɾ���ļ������ơ�
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long FileDelete(long handleApp, final String fileName);
	
	/**
	 * ��ȡ�ļ���Ϣ��
	 * <p>
	 * ��ȡӦ���ļ���������Ϣ�������ļ��Ĵ�С��Ȩ�޵ȡ�
	 * @param handleApp  [IN] �ļ�����Ӧ�õľ����
	 * @param fileName   [IN] �ļ����ơ�
	 * @param pFileInfo  [OUT] �ļ���Ϣ,����Ϊ��
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 * @see SKF_FileAttribute
	 */
	public native long FileGetInfo(long handleApp, final String fileName, SKF_FileAttribute pFileInfo);
	
	/**
	 * ��ȡ�ļ����ݡ�
	 * @param handleApp  [IN] Ӧ�þ����
	 * @param fileName   [IN] �ļ�����
	 * @param offset     [IN] �ļ���ȡƫ��λ�á�
	 * @param size       [IN] Ҫ��ȡ�ĳ��ȡ�
	 * @param dataRead   [OUT] ��ȡ������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long FileRead(long handleApp, final String fileName, long offset, long size, ArrayList<Byte> data);
	
	/**
	 * д���ݵ��ļ��С�
	 * @param handleApp  [IN] Ӧ�þ����
	 * @param fileName   [IN] �ļ�����
	 * @param offset     [IN] д���ļ���ƫ������
	 * @param data       [IN] д������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long FileWrite(long handleApp, final String fileName, long offset, final byte[] data);
	
	////////��������
	/**
	 * ö��Ӧ���µ������������������������б�
	 * @param handleApp Ӧ�þ����
	 * @param listContainerName ָ�����������б������� 
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerEnum(long handleApp, ArrayList<String> listContainerName);
	
	/**
	 * ��Ӧ���½���ָ�����Ƶ��������������������Ȩ��Ҫ����Ҫ�û�Ȩ�ޡ�
	 * @param handleApp [IN] Ӧ�þ����
	 * @param containerName ��ʾ���������������ƣ��������Ƶ���󳤶Ȳ��ܳ���64�ֽڡ�
	 * @param handleContainer [OUT] �������������������������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerCreate(long handleApp, final String containerName, long[] handleContainer);
	
	/**
	 * ��Ӧ����ɾ��ָ�����Ƶ��������ͷ�������ص���Դ��Ȩ��Ҫ����Ҫ�û�Ȩ�ޡ�
	 * @param handleApp [IN] Ӧ�þ���� 
	 * @param containerName [IN] ָ��ɾ�����������ơ�
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerDelete(long handleApp, final String containerName);
	
	/**
	 * ��ȡ���������
	 * @param handleApp [IN] Ӧ�þ����
	 * @param containerName [IN] ���������ơ�
	 * @param handleContainer [OUT] �������������ľ����
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerOpen(long handleApp, final String containerName, long[] handleContainer);
	
	/**
	 * �ر�������������ͷ�������������Դ��
	 * @param handleContainer [IN] ���������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerClose(long handleContainer);

	//��������

	/**
	 * ��ȡ����������
	 * @param handleContainer [IN] ���������
	 * @param containerType [OUT] ��õ��������͡�ָ��ָ���ֵΪ0��ʾδ������δ�������ͻ���Ϊ��������Ϊ1��ʾΪRSA������Ϊ2��ʾΪECC������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ContainerGetType(long handleContainer, long[] containerType);
	
	/**
	 * �������ڵ�������֤�顣
	 * @param handleContainer [IN] ���������
	 * @param bSignFlag [IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param certData [IN] ָ��֤�����ݻ�������
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
 */
	public native long ImportCert(long handleContainer, boolean bSignFlag, final byte[] certData);
	
	/**
	 * �������ڵ�������֤�顣
	 * @param handleContainer [IN] ���������
	 * @param bSignFlag [IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param certData [IN]���ڽ��շ������ݣ����������ת��ΪArrayList<Byte>���ء�
	 * @return �����, SAR_OK�ɹ�
	 * @see SKF_ERROR
	 */
	public native long ExportCert(long handleContainer, boolean bSignFlag, ArrayList<Byte> certData);
	
	//�������
	/**
	 * ����ָ�����ȵ������������Ϊ4��8��16��Ч
	 * @param handleDev  [IN] �豸�����
	 * @param dataRandom [IN, OUT] �����������
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long GenRandom(long handleDev, byte[] dataRandom);

	/**
	 * ���빫Կ������
	 * @param handleContainer [IN] �������
	 * @param bSignFlag	[IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param exponent  [IN] ��Կ������e
	 * @param modulus	[IN] ��Կ������modulus
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long ImportRSAPub(long handleContainer, boolean bSignFlag, final byte[] exponent, final byte[] modulus);
	/**
	 * ����˽Կ������
	 * @param handleContainer [IN] �������
	 * @param bSignFlag [IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param modulus	[IN] ˽Կ���� modulus
	 * @param p			[IN] ˽Կ���� PrimeP
	 * @param q			[IN] ˽Կ���� PrimeQ
	 * @param dp		[IN] ˽Կ���� PrimeExponentP
	 * @param dq		[IN] ˽Կ���� PrimeExponentQ
	 * @param u			[IN] ˽Կ���� CrtCoefficient
	 * @return �����
	 * @see SKF_ERROR
	 */
	public native long ImportRSAPrv(long handleContainer, boolean bSignFlag, final byte[] modulus, final byte[] p, final byte[] q, final byte[] dp, final byte[] dq, final byte[] u);
	
	/**
	 * ˽Կ���㣬˽Կ������˽Կ�ȳ������ݣ�֧��1024λ��2048λ��Կ
	 * <p>
	 * 1024λ˽Կ����128�ֽڵ�����,2048λ˽Կ����256�ֽڵ�����
	 * <p>
	 * �ú���������˽Կ���㣬��ִ���������ȹ��ܣ����������ȳ�
	 * <p>
	 * �����ڴ˺���������ʵ�ֱ�׼��PKIǩ���ӿ�
	 * @param handleContainer [IN] �������
	 * @param bSignFlag [IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param plain [IN] ����
	 * @param cipher [OUT] ����
	 * @return
	 */
	public native long RSAEncrypt(long handleContainer, boolean bSignFlag, final byte[] plain, ArrayList<Byte> cipher);
	
	/**
	 * ��Կ���㣬��Կ�����빫Կ�ȳ������ݣ�֧��1024λ��2048λ����Կ
	 * <p>
	 * 1024λ��Կ����128λ�ֽڵ����ݣ�2048λ��Կ����256�ֽڵ�����
	 * <p>
	 * �ú��������й�Կ���㣬��ִ������ȥ���ȹ��ܣ����������ȳ�
	 * <p>
	 * �����ڴ˺���������ʵ�ֱ�׼��PKIǩ����֤�ӿ�
	 * @param handleContainer [IN] �������
	 * @param bSignFlag [IN] TRUE��ʾǩ��֤�飬FALSE��ʾ����֤�顣
	 * @param cipher [IN] ����
	 * @param plain [OUT] ����
	 * @return
	 */
	public native long RSADecrypt(long handleContainer, boolean bSignFlag, final byte[] cipher, ArrayList<Byte> plain);
	
	static{
		System.loadLibrary("tokenh_javaDll");
	}
}
