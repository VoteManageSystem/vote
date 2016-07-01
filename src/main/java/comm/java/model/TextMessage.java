/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：TextMessage   
 * 类描述：   
 * 创建人：苏叶
 * 创建时间：2016年5月27日 上午9:33:10   
 * 修改备注：     
 **********************************************************/
package comm.java.model;

public class TextMessage {
   private String ToUserName;
   private String FromUserName;
   private String CreateTime;
   private String MsgType;
   private String Content;
   private String MsgId;
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
public String getCreateTime() {
	return CreateTime;
}
public void setCreateTime(String createTime) {
	CreateTime = createTime;
}
public String getMsgType() {
	return MsgType;
}
public void setMsgType(String msgType) {
	MsgType = msgType;
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

  