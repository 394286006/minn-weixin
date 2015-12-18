package p.minn.weixin.service;

import org.springframework.stereotype.Service;

import p.minn.weixin.util.WeixinXmlUtil;
import p.minn.weixin.vo.WeixinHeaderMessage;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
@Service
public class WeixinService {

	public void bodyDecode(Integer encryptType,String token, String encodingAesKey, String appId,String body) throws Exception{
		WeixinHeaderMessage whm=WeixinXmlUtil.decodeMessage(encryptType,token, encodingAesKey, appId, body);
	}
}
