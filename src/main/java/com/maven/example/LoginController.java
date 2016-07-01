/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：GeneralController   
 * 类描述：   
 * 创建人：妖妖
 * 创建时间：2016年2月29日 上午8:48:18   
 * 修改备注：     http://192.168.14.133:8080/vote/votes/login.do
 **********************************************************/
package com.maven.example;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vote.model.User;

@Controller
@RequestMapping(value="votes")  
public class LoginController {  
    /**
     *     ********************************************************      
     * 项目名称：vote  
     * 方法说明：登录方法
     * 参数： @return   
     * 返回值： ModelAndView   
     * 创建人：妖妖
     * 创建时间：2016年4月19日 上午9:34:42   
     * 修改备注：   
       
     *********************************************************
     */
    @RequestMapping(value="login")  
    public ModelAndView login(){  
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("login/login");
//    	mav.addObject("molly","molly你好吗");
        return mav;
    }   
    /**
     * ********************************************************      
     * 项目名称：vote  
     * 方法说明：链接页
     * 参数： @return   
     * 返回值： ModelAndView   
     * 创建人：妖妖
     * 创建时间：2016年4月19日 上午10:47:48   
     * 修改备注：   
       
     *********************************************************
     */
    @RequestMapping(value="index")  
    public ModelAndView index(){   	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("views/index"); 
        return mav;
    }  
    /**
     * ********************************************************      
     * 项目名称：vote  
     * 方法说明：登录之后跳转
     * 参数： @return   
     * 返回值： ModelAndView   
     * 创建人：妖妖 
     * 创建时间：2016年4月19日 上午11:48:04   
     * 修改备注：   
       
     *********************************************************
     */
    @RequestMapping(value="login_in") 
    @ResponseBody  
    public 	Map<String, Object> login_in(HttpServletRequest request,
    		HttpServletResponse response,
    		User user){
        Map<String, Object> returnMap=new HashMap<String, Object>();
        System.out.print("password:" + request.getParameter("password") +  "username:" +request.getParameter("username"));
        JSONObject data =new JSONObject();

        System.out.print("password:" + user.getPassword() +  "username:" + user.getUsername());
        data.put("returnCode", 1);
        data.put("returnMsg", 2);
        returnMap.put("returnCode",  user.getPassword());
        returnMap.put("returnMsg", user.getUsername());
		return returnMap;
		
    }  
    
    
    @RequestMapping(value="fullpage")  
    public ModelAndView fullpage(){  
    	
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("/fullpage");
//    	mav.addObject("molly","molly你好吗");
        return mav;
    }  
}   