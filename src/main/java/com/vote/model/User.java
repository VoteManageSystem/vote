/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：User   
 * 类描述：   
 * 创建人：袁伟倩
 * 创建时间：2016年4月20日 下午5:39:16   
 * 修改备注：     
 **********************************************************/
package com.vote.model;

import java.util.Date;


public class User {
    
    private int  id; 
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

  