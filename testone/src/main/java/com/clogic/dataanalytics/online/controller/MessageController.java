/**   
 *
 * @author HYL   
 * @date 2018��3��20�� ����11:42:34
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
 * @date 2018��3��20�� ����11:42:34
 * @version 0.1.0
 * @since 0.1.0  
 */
@Controller
public class MessageController {

	/**
	 * POST ���������Ϣ
	 * @param request
	 * @param response
	 * @author HYL   
	 * @date 2018��3��21�� ����8:52:59
	 */
	@PostMapping("/testOne")
	public void messageHandle(HttpServletRequest request,HttpServletResponse response){
		System.out.println("pppost");
		response.setCharacterEncoding("utf-8");  
	    PrintWriter out = null;  
	    //��΢������xmlתΪmap��ʽ����ȡ����Ĳ���  
	    Map<String,String> map = MessageUtil.xmlToMap(request);  
	    String ToUserName = map.get("ToUserName");  
	    String FromUserName = map.get("FromUserName");  
	    String MsgType = map.get("MsgType");  
	    String Content = map.get("Content");  
	      
	    String message = null;  
	    //�����ı����ͣ�ʵ������1���ظ���Ӧ�ķ�װ������  
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
