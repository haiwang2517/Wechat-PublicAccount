/**   
 *
 * @author HYL   
 * @date 2018年3月20日 下午11:48:33
 * @version 0.1.0
 * @since 0.1.0  
 */
package com.clogic.dataanalytics.online.msg.comm;

import java.io.IOException;  
import java.io.InputStream;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;  
  
import org.dom4j.Document;  
import org.dom4j.DocumentException;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  

/**   
 * 
 * @author HYL
 * @date 2018年3月20日 下午11:48:33
 * @version 0.1.0
 * @since 0.1.0  
 */
public class MessageUtil {  
    /** 
     * 将微信的请求中参数转成map 
     * @param request 
     * @return 
     */  
    public static Map<String,String> xmlToMap(HttpServletRequest request){  
        Map<String,String> map = new HashMap<String,String>();  
        SAXReader reader = new SAXReader();  
        InputStream in = null;  
        try {  
            in = request.getInputStream();  
            Document doc = reader.read(in);  
            Element root = doc.getRootElement();  
            List<Element> list = root.elements();  
            for (Element element : list) {  
                map.put(element.getName(), element.getText());  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (DocumentException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            try {  
                in.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        return map;  
    }  
}  
