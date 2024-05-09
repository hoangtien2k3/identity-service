package com.hoangtien2k3.identityservice.validator;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private String message;

    @Override
    public void initialize(final ValidPassword constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(List.of(
                // at least 8 characters
                new LengthRule(8, 50)));

        boolean isValid = StringUtils.isNotBlank(password)
                && validator.validate(new PasswordData(password)).isValid();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }

        return isValid;
    }
}
