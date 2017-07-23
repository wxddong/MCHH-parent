package com.threefiveninetong.mchh.core.handler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.threefiveninetong.mchh.core.validation.annotation.NotNull;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

	@Override
	public void initialize(NotNull annotation) {
	}

	@Override
	public boolean isValid(Object str, ConstraintValidatorContext constraintValidatorContext) {
		return str != null;
	}

}
