package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinTextMessage extends WeixinBodyMessage{
	
	private String content;
	
	public WeixinTextMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String content, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.content = content;
		MsgId = msgId;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}
