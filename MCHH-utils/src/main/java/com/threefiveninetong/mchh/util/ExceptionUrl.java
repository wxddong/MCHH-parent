package com.threefiveninetong.mchh.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
public @interface ExceptionUrl {
	String url();
}
