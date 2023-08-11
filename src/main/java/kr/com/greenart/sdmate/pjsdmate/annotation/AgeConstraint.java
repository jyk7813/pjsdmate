package kr.com.greenart.sdmate.pjsdmate.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
    String message() default "만 19세 이상만 가입 가능합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
