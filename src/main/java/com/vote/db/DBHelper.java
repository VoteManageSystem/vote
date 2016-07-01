/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：DBHelper   
 * 类描述：   
 * 创建人：七夜琉璃
 * 创建时间：2016年4月8日 下午4:49:24   
 * 修改备注：     
 **********************************************************/
package com.vote.db;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
public class DBHelper {
	public static final String url = "jdbc:mysql://127.0.0.1/vote";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}

  