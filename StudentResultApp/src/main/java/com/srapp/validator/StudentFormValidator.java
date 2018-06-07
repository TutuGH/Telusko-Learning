package com.srapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.srapp.command.StudentCommand;

@Component
public class StudentFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentCommand cmd = (StudentCommand) target;
		if (cmd.getCity().equals("") || cmd.getCity() == null) {
			errors.rejectValue("city", "city.required");
		}
		if (cmd.getLowerAge() < 10) {
			errors.rejectValue("lowerAge", "lowerage.less");
		}
		if (cmd.getUpperAge() < 10 || cmd.getUpperAge() > 60) {
			errors.rejectValue("upperAge", "upperage.max");
		}
	}

}
