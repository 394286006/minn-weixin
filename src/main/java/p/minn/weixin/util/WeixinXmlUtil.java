package p.minn.weixin.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import p.minn.weixin.vo.WeixinBodyMessage;
import p.minn.weixin.vo.WeixinKey;
import p.minn.weixin.vo.WeixinTextMessage;
import p.minn.weixin.vo.WeixinHeaderMessage;


/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
public class WeixinXmlUtil {

	public static Element getElement(String body) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(body);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		return root;
	
	}
	
	public static String getValue(Element e,String key){
		NodeList node = e.getElementsByTagName(key);
		String val ="";
		if(node==null||node.item(0)==null){
			return val;
		}
		 val = node.item(0).getTextContent();
		return val;
	}
	
	public static WeixinHeaderMessage decodeMessage(Integer encryptType,String token, String encodingAesKey, String appId,String body) throws Exception{
		
		String encrypt=null;
		String msgSignature=null;
		String timeStamp=null;
		String nonce=null;
		String fromXML = null;
		WXBizMsgCrypt wmc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		String decryptMsg = null;
		EncryptType type=EncryptType.getType(encryptType);
		switch(type){
		case PLAINTEXT:
			decryptMsg=  body;
			break;
		case COMPATIBLE:
		case SAFETY:
			Element root = getElement(body);
			msgSignature=getValue(root, "MsgSignature");
			timeStamp=getValue(root, "TimeStamp");
			encrypt=getValue(root, "Encrypt");
			nonce=getValue(root, "Nonce");
			fromXML = String.format(WeixinKey.FORMATXML, encrypt);
			decryptMsg=wmc.decryptMsg(msgSignature, timeStamp, nonce, fromXML);
			default :
				throw new Exception("encryptType wrong!");
		}
		WeixinHeaderMessage whm=new WeixinHeaderMessage(encrypt,msgSignature,timeStamp,nonce);
		Element decryptelement = WeixinXmlUtil.getElement(decryptMsg);
		
		WeixinBodyMessage wbm=null;
		String msgType=getValue(decryptelement, "MsgType");
		WeixinMsgType wmt=WeixinMsgType.getType(msgType);
		switch(wmt){
		case TEXT:
			wbm=new WeixinTextMessage(getValue(decryptelement, "ToUserName"),getValue(decryptelement, "FromUserName"),getValue(decryptelement, "CreateTime"),msgType,getValue(decryptelement, "Content"),getValue(decryptelement, "MsgId"));
			break;
		case VIDEO:
			wbm=new WeixinTextMessage(getValue(decryptelement, "ToUserName"),getValue(decryptelement, "FromUserName"),getValue(decryptelement, "CreateTime"),msgType,getValue(decryptelement, "Content"),getValue(decryptelement, "MsgId"));
			break;
		default:
			throw new Exception("no impl");
		}
		WeixinKey wk=new WeixinKey(type,encodingAesKey,token,appId);
		whm.setWeixinKey(wk);
		whm.setWeixinBodyMessage(wbm);
		return whm;
	}
	private static Document encodeMessage(WeixinKey key,String toUserName,String fromUserName,String createTime,WeixinMsgType msgType) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document xmlDoc=db.newDocument();
		Node item = null;         
        Element root = xmlDoc.createElement("xml");
        item = xmlDoc.createElement("ToUserName");
        item.appendChild(xmlDoc.createCDATASection(toUserName));
        root.appendChild(item);
        item = xmlDoc.createElement("FromUserName");
        item.appendChild(xmlDoc.createCDATASection(fromUserName));
        root.appendChild(item);
        item = xmlDoc.createElement("CreateTime");
        item.appendChild(xmlDoc.createTextNode(createTime));
        root.appendChild(item);
        item = xmlDoc.createElement("MsgType");
        item.appendChild(xmlDoc.createCDATASection(msgType.getValue()));
        root.appendChild(item);
        xmlDoc.appendChild(root);
		return xmlDoc;
	}
	
	public static String xmlBack(Document xmlDoc) throws Exception{
		 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xmlDoc);
			OutputStream os=new ByteArrayOutputStream();
			 StreamResult result = new StreamResult(os);
			transformer.transform(source, result);
			return os.toString();
	}
	
	public static String encodingTypeMessage(WeixinKey key,String toUserName,String fromUserName,String createTime,WeixinMsgType msgType,String tagValue) throws Exception{
		Document xmlDoc=encodeMessage(key, toUserName, fromUserName, createTime, msgType);
		Node item = null;    
		switch(msgType){
		case TEXT:
			item = xmlDoc.createElement(msgType.getValue());
		    item.appendChild(xmlDoc.createCDATASection(tagValue));
			break;
		case IMAGE:
		case VOICE:
			Node item1 = null; 
			item = xmlDoc.createElement(msgType.getValue());
			item1= xmlDoc.createElement("MediaId");
			item1.appendChild(xmlDoc.createCDATASection(tagValue));
		    item.appendChild(item1);
			break;
			default:
				throw new Exception("no impl type:"+msgType.getValue());
		}
		 xmlDoc.getFirstChild().appendChild(item);
	    return xmlBack(xmlDoc);
	}

}
