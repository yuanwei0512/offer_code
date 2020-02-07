package com.hyw.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/15 19:50
 * Description：TODO
 */
public class ValidationTest {



    @Test
    public void init() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserInfo userInfo = new UserInfo();
        validator.validate(userInfo, UserInfo.LoginGroup.class);

    }

    public void groupValidateion() {

    }



}
