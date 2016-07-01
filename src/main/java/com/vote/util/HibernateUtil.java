/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：HibernateUtil   
 * 类描述：   
 * 创建人：袁伟倩
 * 创建时间：2016年4月20日 下午5:47:23   
 * 修改备注：     
 **********************************************************/
package com.vote.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
    System.out.println("test----1");
        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

  