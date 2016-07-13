package com.vote.model;
// Generated 2016-7-12 13:35:20 by Hibernate Tools 3.5.0.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Indexed;

import com.vote.annotation.TableInfo;
import com.vote.pojo.BaseCode;

@TableInfo(defend = "defend", packageName = VUser.class)
@Entity
@Table(name = "v_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@Indexed(index = "VUser")
@Analyzer(impl = SmartChineseAnalyzer.class) // 分词器
public class VUser extends BaseCode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "varchar2(255)")
	@JsonIgnore
	private String username;
	@Column(columnDefinition = "varchar2(255)")
	@JsonIgnore
	private String password;

	public VUser() {
	}

	public VUser(int id) {
		super.setId(id);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
