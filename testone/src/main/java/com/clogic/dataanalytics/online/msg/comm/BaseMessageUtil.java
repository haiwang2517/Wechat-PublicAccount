/**   
 *
 * @author HYL   
 * @date 2018��3��20�� ����11:57:30
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.comm;

/**   
 * 
 * @author HYL
 * @date 2018��3��20�� ����11:57:30
 * @version 0.1.0
 * @since 0.1.0  
 */
public interface BaseMessageUtil<T> {
	 /** 
     * ���ظ�����Ϣ����תxml��ʽ��΢�� 
     * @param message 
     * @return 
     */  
    public  abstract  String messageToxml(T t);  
      
    /** 
     * �ظ�����Ϣ��װ 
     * @param FromUserName 
     * @param ToUserName 
     * @param Content 
     * @return 
     */  
    public abstract  String initMessage(String FromUserName,String ToUserName);  
}
