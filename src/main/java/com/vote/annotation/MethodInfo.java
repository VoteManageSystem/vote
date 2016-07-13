package com.vote.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vote.pojo.BaseCode;

@Documented // 文档
@Retention(RetentionPolicy.RUNTIME) // 在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD }) // 作用到类，方法，接口上等
public @interface MethodInfo {
	public String label() default "";

	public String dataname() default "";

	public String isShow() default "";

	public String getEnum() default "";

	public boolean issearch() default true;

	public String idKey() default "";

	public Class detail() default BaseCode.class;
}
