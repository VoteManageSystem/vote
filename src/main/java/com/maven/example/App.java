/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：App   
 * 类描述：   
 * 创建人：袁伟倩
 * 创建时间：2016年4月20日 下午5:48:19   
 * 修改备注：     
 **********************************************************/
package com.maven.example;

import org.hibernate.Session;

import com.vote.model.User;
import com.vote.util.HibernateUtil;

public class App {
	 public static void main(String[] args) {
	        System.out.println("Maven3 + Hibernate + Oracle10g");
	        Session session = HibernateUtil.getSessionFactory().openSession();
	 
	        session.beginTransaction();
	        User user = new User();
	 
	        user.setUsername("苏夜");
	        user.setPassword("11");
	        session.save(user);
	        session.getTransaction().commit();
	    }
}

  