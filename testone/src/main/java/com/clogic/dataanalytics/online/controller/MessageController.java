/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:42:34
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.clogic.dataanalytics.online.msg.comm.MessageUtil;
import com.clogic.dataanalytics.online.msg.comm.TextMessageUtil;

/**   
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:42:34
 * @version 0.1.0
 * @since 0.1.0  
 */
@Controller
public class MessageController {

	/**
	 * POST 请求接收消息
	 * @param request
	 * @param response
	 * @author HYL   
	 * @date 2018年3月21日 上午8:52:59
	 */
	@PostMapping("/testOne")
	public void messageHandle(HttpServletRequest request,HttpServletResponse response){
		System.out.println("pppost");
		response.setCharacterEncoding("utf-8");  
	    PrintWriter out = null;  
	    //将微信请求xml转为map格式，获取所需的参数  
	    Map<String,String> map = MessageUtil.xmlToMap(request);  
	    String ToUserName = map.get("ToUserName");  
	    String FromUserName = map.get("FromUserName");  
	    String MsgType = map.get("MsgType");  
	    String Content = map.get("Content");  
	      
	    String message = null;  
	    //处理文本类型，实现输入1，回复相应的封装的内容  
	    if("text".equals(MsgType)){  
//	        if("1".equals(Content)){  
	            TextMessageUtil textMessage = new TextMessageUtil();  
	            message = textMessage.initMessage(FromUserName, ToUserName);  
//	        }  
	    }  
	    try {  
	        out = response.getWriter();  
	        out.write(message);  
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	    out.close();  
	}
}
