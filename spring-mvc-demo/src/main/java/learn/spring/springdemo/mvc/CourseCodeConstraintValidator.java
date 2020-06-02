package learn.spring.springdemo.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom Validator
 * @author saukedia1
 *
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.startsWith(coursePrefix);
    }
    
}
