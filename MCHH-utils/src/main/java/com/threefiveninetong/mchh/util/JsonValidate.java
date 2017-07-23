package com.threefiveninetong.mchh.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *标志是否要进行JSON效验
 */
@Target( {ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonValidate {

}
