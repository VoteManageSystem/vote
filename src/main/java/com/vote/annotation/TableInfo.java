package com.vote.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented // 文档
@Retention(RetentionPolicy.RUNTIME) // 在运行时可以获取
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD }) // 作用到类，方法，接口上等
public @interface TableInfo {

	public String defend() default "defend";

	public String listview() default "list";

	public Class packageName();

	public String search() default "";

	public String[] doMethodName() default "";

	public String[] doMethodURL() default "";
}
