/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:57:59
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.comm;

import java.util.Date;

import com.clogic.dataanalytics.online.msg.model.MessageText;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:57:59
 * @version 0.1.0
 * @since 0.1.0
 */
public class TextMessageUtil {
	/**
	 * 将发送消息封装成对应的xml格式
	 */
	public String messageToxml(MessageText message) {
		XStream xstream = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}

	/**
	 * 封装发送消息对象,封装时，需要将调换发送者和接收者的关系
	 * 
	 * @param FromUserName
	 * @param ToUserName
	 */
	public String initMessage(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("欢迎关注机械振动工程党支部");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		return messageToxml(text);
	}
}
