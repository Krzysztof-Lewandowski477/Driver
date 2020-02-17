package pl.driver.validation.constrains;

import pl.driver.validation.validators.ArticleExistByIdForLong;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ArticleExistByIdForLong.class)
public @interface ArticleExist {

    String message() default "{pl.driver.validation.constrains.ArticleExist.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
