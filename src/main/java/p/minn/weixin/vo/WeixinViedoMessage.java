package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinViedoMessage extends WeixinBodyMessage{
	
	private String mediaId;
	
	private String format;
	
	public WeixinViedoMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String format,String mediaId, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.mediaId = mediaId;
		this.format=format;
		MsgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}


}
