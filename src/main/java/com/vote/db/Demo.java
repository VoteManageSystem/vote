/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：Demo   
 * 类描述：   
 * 创建人：七夜琉璃
 * 创建时间：2016年4月8日 下午4:50:39   
 * 修改备注：     
 **********************************************************/
package com.vote.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	 static String sql = null;  
	    static DBHelper db1 = null;  
	    static ResultSet ret = null;  
	  
	    public static void main(String[] args) {  
	        sql = "select * from test";//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象  
	  
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集  
	            while (ret.next()) {  
	                String uid = ret.getString(1);  
	                String ufname = ret.getString(2);  	                
	                System.out.println(uid + "\t" + ufname );  
	            }//显示数据  
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
}

  