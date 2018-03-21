/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:59:31
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.model;

/**
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:59:31
 * @version 0.1.0
 * @since 0.1.0
 */
public class MessageText extends BaseMessage {
	private String Content;// 文本消息内容

	private String MsgId;// 消息id，64位整型

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
