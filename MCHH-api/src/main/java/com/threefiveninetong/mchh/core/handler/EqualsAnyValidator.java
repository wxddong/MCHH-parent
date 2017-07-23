package com.threefiveninetong.mchh.core.handler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.threefiveninetong.mchh.core.validation.annotation.EqualsAny;

public class EqualsAnyValidator implements ConstraintValidator<EqualsAny, String> {

	private String[] values;

	@Override
	public void initialize(EqualsAny annotation) {
		this.values = annotation.values();
	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
		if (str == null) {
			return true;
		}
		for (String value : values) {
			if (str.equals(value)) {
				return true;
			}
		}
		return false;
	}

}
