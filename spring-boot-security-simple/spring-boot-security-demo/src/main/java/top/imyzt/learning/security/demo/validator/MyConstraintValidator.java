package top.imyzt.learning.security.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import top.imyzt.learning.security.demo.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author imyzt
 * @date 2019/6/3
 * @description MyConstraintValidator
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("MyConstraintValidator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        helloService.greeting((String) value);

        System.out.println("参数值: " + value);

        return null != value && ((String) value).length() > 3;
    }
}
