package p.minn.weixin.util;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public enum WeixinMsgType {
	TEXT("text"),IMAGE("image"),VOICE("voice"),VIDEO("video"),SHORTVIDEO("shortvideo"),LOCATION("location"),LINK("link");
	
	private String value;
	
	private WeixinMsgType(String val){
		this.value=val;
	}

	public String getValue() {
		return value;
	}
	
	public static WeixinMsgType getType(String type){
		switch(type){
		case "text":
			return TEXT;
		case "image":
			return IMAGE;
		case "voice":
			return VOICE;
		case "video":
			return VIDEO;
		case "shortvideo":
			return SHORTVIDEO;
		case "location":
			return LOCATION;
		case "link":
			return LINK;
			default:
				throw new RuntimeException("no impl type:"+type);
		}
		
	}
}
