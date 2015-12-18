package p.minn.weixin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import p.minn.weixin.service.WeixinService;



/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */
@Controller
@RequestMapping("/minnweixin")
public class MinnWeixinController {
	
	@Autowired
	WeixinService weixinService;
	
	@RequestMapping(method = RequestMethod.POST)  
	public void post(HttpServletResponse rep,@RequestParam("encrypt_type") Integer encryptType,@RequestParam("appid") String appid,@RequestParam("token") String token,@RequestParam("encodingaeskey") String encodingaeskey,@RequestParam("body") String body){
		 PrintWriter out = null;  
	        try {  
	            out = rep.getWriter();  
	            weixinService.bodyDecode(encryptType,token, encodingaeskey, appid, body);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            out.close();  
	         
	        }  
	}
	@RequestMapping(method = RequestMethod.GET)  
	public void get(HttpServletResponse rep,@RequestParam("encrypt_type") Integer encryptType,@RequestParam("appid") String appid,@RequestParam("token") String token,@RequestParam("encodingaeskey") String encodingaeskey,@RequestParam("body") String body){
		post(rep, encryptType, appid,  token, encodingaeskey, body);
	}
}
