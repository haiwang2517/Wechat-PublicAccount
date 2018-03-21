/**   
 *
 * @author HYL   
 * @date 2018��3��20�� ����11:59:31
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.model;

/**
 * 
 * @author HYL
 * @date 2018��3��20�� ����11:59:31
 * @version 0.1.0
 * @since 0.1.0
 */
public class MessageText extends BaseMessage {
	private String Content;// �ı���Ϣ����

	private String MsgId;// ��Ϣid��64λ����

	public MessageText() {

	}

	public MessageText(String toUserName, String fromUserName, long createTime, String msgType, String content,
			String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

}
