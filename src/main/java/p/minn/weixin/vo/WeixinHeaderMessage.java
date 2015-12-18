package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinHeaderMessage {

	private String encrypt;
	
	private String msgSignature;
	
	private String timeStamp;
	
	private String Nonce;
	
	private WeixinBodyMessage weixinBodyMessage;
	
	private WeixinKey weixinKey;
	

	public WeixinHeaderMessage(String encrypt, String msgSignature,
			String timeStamp, String nonce) {
		super();
		this.encrypt = encrypt;
		this.msgSignature = msgSignature;
		this.timeStamp = timeStamp;
		Nonce = nonce;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public String getMsgSignature() {
		return msgSignature;
	}

	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonce() {
		return Nonce;
	}

	public void setNonce(String nonce) {
		Nonce = nonce;
	}

	public WeixinBodyMessage getWeixinBodyMessage() {
		return weixinBodyMessage;
	}

	public void setWeixinBodyMessage(WeixinBodyMessage weixinBodyMessage) {
		this.weixinBodyMessage = weixinBodyMessage;
	}

	public WeixinKey getWeixinKey() {
		return weixinKey;
	}

	public void setWeixinKey(WeixinKey weixinKey) {
		this.weixinKey = weixinKey;
	}
	
}
