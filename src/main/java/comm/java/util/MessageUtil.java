/**********************************************************      
 
 * 项目名称：   
 * 类名称：MessageUtil   
 * 类描述：   
 * 创建人：苏叶
 * 创建时间：2016年5月27日 上午8:38:35   
 * 修改备注：     
 **********************************************************/
package comm.java.util;

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

import com.thoughtworks.xstream.XStream;
import comm.java.model.TextMessage;

public class MessageUtil {
	/**
	 * ********************************************************      
	 * 项目名称：  
	 * 方法说明：xml转为map集合
	 * 参数： @param request
	 * 参数： @return
	 * 参数： @throws Exception   
	 * 返回值： Map<String,String>   
	 * 创建人：苏叶 
	 * 创建时间：2016年5月27日 上午9:14:24   
	 * 修改备注：   
	   
	 *********************************************************
	 */
  public static Map<String ,String > xmlToMap(HttpServletRequest request) throws Exception{
	  Map<String ,String > map=new HashMap<String, String>();
	  SAXReader reader=new SAXReader();
	  InputStream ins=request.getInputStream();
	  Document doc=reader.read(ins);
	  
	  Element root=doc.getRootElement();
	  List<Element> list=root.elements();
	  for(Element e:list){
		  map.put(e.getName(), e.getText());
	  }
	  ins.close();
	  return map;
	  	  
  }
  /**
   * ********************************************************      
   * 项目名称：  
   * 方法说明：将文本消息对象转为xml
   * 参数： @param textMessage
   * 参数： @return   
   * 返回值： String   
   * 创建人：苏叶 
   * 创建时间：2016年5月27日 上午9:30:47   
   * 修改备注：   
     
   *********************************************************
   */
  public static String textMessageToXml(TextMessage textMessage){
	  XStream xstream=new XStream();
	  xstream.alias("xml", textMessage.getClass());
	  return xstream.toXML(textMessage);
  }
}

  