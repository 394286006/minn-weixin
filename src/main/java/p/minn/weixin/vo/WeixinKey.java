package p.minn.weixin.vo;

import p.minn.weixin.util.EncryptType;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */

public class WeixinKey {
	
	public  EncryptType encryptType;

	public  String encodingAesKey="abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
	
	public  String token="pamtest";
	
	public  String appId="wxb11529c136998cb6";
	
	public static final String FORMATXML="<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

	
	
	public WeixinKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public WeixinKey(EncryptType encryptType,String encodingAesKey, String token, String appId) {
		super();
		this.encryptType=encryptType;
		this.encodingAesKey = encodingAesKey;
		this.token = token;
		this.appId = appId;
	}



	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}



	public EncryptType getEncryptType() {
		return encryptType;
	}



	public void setEncryptType(EncryptType encryptType) {
		this.encryptType = encryptType;
	}
	
	
}
