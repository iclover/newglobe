package com.newglobe.minutes.web.systemmgr;


import com.newglobe.minutes.model.systemmgr.UserInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * spring mvc UserInfo Bean Validator
 * Created by Administrator on 14-2-19.
 */
public class UserInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> candidate) {
        return UserInfo.class.isAssignableFrom(candidate);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.login.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "required", "Field is required.");
    }


}
