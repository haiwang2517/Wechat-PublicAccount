/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:57:30
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.comm;

/**   
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:57:30
 * @version 0.1.0
 * @since 0.1.0  
 */
public interface BaseMessageUtil<T> {
	 /** 
     * 将回复的信息对象转xml格式给微信 
     * @param message 
     * @return 
     */  
    public  abstract  String messageToxml(T t);  
      
    /** 
     * 回复的信息封装 
     * @param FromUserName 
     * @param ToUserName 
     * @param Content 
     * @return 
     */  
    public abstract  String initMessage(String FromUserName,String ToUserName);  
}
