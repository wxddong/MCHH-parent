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
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {  
}) 
@NotEmpty(message="{com.devsource.yimatravel.validator.legalText.empty}")
@Pattern(regexp= "^(?!_)(?!-)(?!.*?_$)(?!.*?-$)[a-zA-Z0-9_\\-\u4e00-\u9fa5]+$",message="{com.devsource.yimatravel.validator.legalText}" )
public @interface LegalText {
	
	String filed() default "";
 
	/**
	 * @return the error message template
	 */
	String message() default "{com.devsource.yimatravel.validator.legalText}";

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
