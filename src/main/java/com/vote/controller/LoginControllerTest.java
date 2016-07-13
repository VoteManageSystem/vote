/**
 * 
 */
package com.vote.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.model.User;
import com.vote.model.VUser;
import com.vote.service.ILoginService;

import net.sf.json.JSONObject;

/**
 * @author zhanghonghao
 *
 */
@Controller
@RequestMapping(value = "logins")
public class LoginControllerTest {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "login_in")
	@ResponseBody
	public Map<String, Object> login_in(HttpServletRequest request, HttpServletResponse response, User user) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		System.out
				.print("password:" + request.getParameter("password") + "username:" + request.getParameter("username"));
		VUser vuser = new VUser();
		vuser.setUsername(request.getParameter("username"));
		vuser.setPassword(request.getParameter("password"));
		loginService.login(vuser);

		System.out.print("password:" + user.getPassword() + "username:" + user.getUsername());
		returnMap.put("returnCode", user.getPassword());
		returnMap.put("returnMsg", user.getUsername());
		return returnMap;

	}
}
