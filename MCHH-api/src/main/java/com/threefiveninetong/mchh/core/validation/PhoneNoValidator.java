package com.threefiveninetong.mchh.core.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import com.threefiveninetong.mchh.core.validation.annotation.PhoneNo;

public class PhoneNoValidator implements ConstraintValidator<PhoneNo, String> {

	@Override
	public void initialize(PhoneNo constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null)
			return false;
		String regexp = ((ConstraintValidatorContextImpl)context).getConstraintDescriptor().getAttributes().get("regexp").toString();
		return Pattern.matches(regexp, value);
	}

}
