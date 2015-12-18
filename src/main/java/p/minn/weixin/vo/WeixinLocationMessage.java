package p.minn.weixin.vo;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinLocationMessage extends WeixinBodyMessage{
	
	private String location_X;
	
	private String location_Y;
	
	private String scale;
	
	private String label;
	
	public WeixinLocationMessage(String toUserName, String fromUserName,
			String createTime, String msgType, String location_X,String location_Y,String scale,String label, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		this.location_X = location_X;
		this.location_Y=location_Y;
		this.scale = scale;
		this.label=label;
		MsgId = msgId;
	}

	public String getLocation_X() {
		return location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



}
