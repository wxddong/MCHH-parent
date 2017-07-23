package com.threefiveninetong.mchh.core.handler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.threefiveninetong.mchh.core.validation.annotation.NotEmpty;


public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

	@Override
	public void initialize(NotEmpty annotation) {
	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
		return !(str == null || str.isEmpty());
	}

}
