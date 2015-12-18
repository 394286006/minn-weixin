package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeinxinImageMessage extends WeixinBodyMessage {

	private String picUrl;
	
	private String mediaId;

	public WeinxinImageMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String picUrl,String mediaId, String msgId) {
		super();
		// TODO Auto-generated constructor stub
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.picUrl = picUrl;
		this.mediaId=mediaId;
		MsgId = msgId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	
	
}
