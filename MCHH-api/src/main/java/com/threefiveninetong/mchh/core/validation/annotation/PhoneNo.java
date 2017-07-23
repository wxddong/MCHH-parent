package com.threefiveninetong.mchh.core.validation.annotation;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName: PhoneNo 
 * @Description: TODO 手机号验证
 * @author: jixf
 * @date: 2016年1月14日 下午2:49:47  
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {
		/** 暂时不使用自定义验证器 PhoneNoValidator.class */
}) 
@NotEmpty(message="{com.devsource.yimatravel.validator.phoneNo.empty}")
@Pattern(regexp= "^[1][3,4,5,7,8][0-9]{9}$",message="{com.devsource.yimatravel.validator.phoneNo}" )
public @interface PhoneNo {
	
	String filed() default "";
 
	/**
	 * @return the error message template
	 */
	String message() default "{com.devsource.yimatravel.validator.phoneNo}";

	/**
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default { };

	/**
	 * @return the payload associated to the constraint
	 */
	Class<? extends Payload>[] payload() default { };

	/**
	 * Defines several {@link Pattern} annotations on the same element.
	 *
	 * @see Pattern
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Pattern[] value();
	}
}
