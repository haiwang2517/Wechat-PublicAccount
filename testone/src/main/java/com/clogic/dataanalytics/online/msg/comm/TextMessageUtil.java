/**   
 *
 * @author HYL   
 * @date 2018��3��20�� ����11:57:59
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
 * @date 2018��3��20�� ����11:57:59
 * @version 0.1.0
 * @since 0.1.0
 */
public class TextMessageUtil {
	/**
	 * ��������Ϣ��װ�ɶ�Ӧ��xml��ʽ
	 */
	public String messageToxml(MessageText message) {
		XStream xstream = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}

	/**
	 * ��װ������Ϣ����,��װʱ����Ҫ�����������ߺͽ����ߵĹ�ϵ
	 * 
	 * @param FromUserName
	 * @param ToUserName
	 */
	public String initMessage(String FromUserName, String ToUserName) {
		MessageText text = new MessageText();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("��ӭ��ע��е�񶯹��̵�֧��");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
		return messageToxml(text);
	}
}
