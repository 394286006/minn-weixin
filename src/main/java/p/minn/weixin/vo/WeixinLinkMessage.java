package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinLinkMessage extends WeixinBodyMessage{
	
	private String title;
	
	private String description;
	
	private String url;
	
	public WeixinLinkMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String title,String description,String url, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.title = title;
		this.description=description;
		this.url = url;
		MsgId = msgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
