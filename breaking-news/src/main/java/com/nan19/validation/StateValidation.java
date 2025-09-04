package com.nan19.validation;

import com.nan19.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * 判断文章的状态是否合法
     * @param value 将来要校验的数据
     * @param context context in which the constraint is evaluated
     *
     * @return 如果返回false，则校验不通过；如果返回true，则校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 提供校验规则
        if (value == null)
            return false;
        if ("已发布".equals(value) || "草稿".equals(value))
            return true;
        return false;
    }

}
