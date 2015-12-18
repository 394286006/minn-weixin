package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinVoiceMessage extends WeixinBodyMessage{
	
	private String mediaId;
	
	private String thumbMediaId;
	
	public WeixinVoiceMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String thumbMediaId,String mediaId, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.mediaId = mediaId;
		this.thumbMediaId=thumbMediaId;
		MsgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}


}
