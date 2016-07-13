package com.vote.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.vote.annotation.MethodInfo;

@MappedSuperclass
public abstract class BaseCode implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@MethodInfo(dataname = "user", label = "ID", isShow = "show")
	private Integer id;

	@Column
	@MethodInfo(dataname = "createDate", label = "创建时间", isShow = "show", issearch = false)
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	
	@Column
	@MethodInfo(dataname = "updateDate", label = "更新时间", isShow = "show", issearch = false)
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public static String clean(String value) {
		value = value.replaceAll("<script", "&lt;script").replaceAll("script>", "script&gt;");
		value = value.replaceAll("<input", "&lt;input");
		
//		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
//		value = value.replaceAll("'", "&#39;");
//		value = value.replaceAll("eval\\((.*)\\)", "");
//		value = value.replaceAll("[\\\"<a>\\\'][\\s]*javascript:(.*)[\\\"\\\'</a>]", "\"\"");
//		value = value.replaceAll("script", "");
		return value;
	}
	
	public static String cleanScript(String value) {
		value = value.replaceAll("<script", "&lt;script").replaceAll("script>", "script&gt;");
		
//		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
//		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
//		value = value.replaceAll("'", "&#39;");
//		value = value.replaceAll("eval\\((.*)\\)", "");
//		value = value.replaceAll("[\\\"<a>\\\'][\\s]*javascript:(.*)[\\\"\\\'</a>]", "\"\"");
//		value = value.replaceAll("script", "");
		return value;
	}
}
