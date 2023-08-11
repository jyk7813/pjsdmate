package kr.com.greenart.sdmate.pjsdmate.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeValidator implements ConstraintValidator<AgeConstraint, String> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) {return true;}

        try{
            LocalDate birthDate = LocalDate.parse(value, formatter);
            LocalDate now = LocalDate.now();
            return !birthDate.plusYears(19).isAfter(now);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
