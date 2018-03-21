/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:58:50
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.model;

/**
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:58:50
 * @version 0.1.0
 * @since 0.1.0
 */
public class BaseMessage {
	protected String ToUserName;
	protected String FromUserName;
	protected long CreateTime;
	protected String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
