/**
 * 
 */
package com.vote.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vote.dao.BaseDAO;
import com.vote.model.VUser;
import com.vote.service.ILoginService;

/**
 * @author zhanghonghao
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

	@Resource(name = "hibernateDAO")
	BaseDAO<VUser> hibernateDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vote.service.ILoginService#login(com.vote.model.VUser)
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean login(VUser vuser) {

		Map<String, String> parm = new HashMap<String, String>();
		parm.put("username", vuser.getUsername());
		parm.put("password", vuser.getPassword());
		VUser result = hibernateDAO.findByColumn("from " + VUser.class.getSimpleName() + " where username=:username and password = :password", parm);
		return false;
	}

}
