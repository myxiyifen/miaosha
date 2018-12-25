package com.xiyifen.miaosha.validator;

import com.xiyifen.miaosha.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: fs.z
 * @Date: 2018/12/23 9:24
 * @Description:
 */

public class isMobileValidator implements ConstraintValidator<isMobile,String>{
    private boolean requered=false;
    @Override
    public void initialize(isMobile isMobile) {
        requered=isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (requered){
            return ValidatorUtil.isMobile(value);
        }else {
            if (StringUtils.isEmpty(value)){
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
