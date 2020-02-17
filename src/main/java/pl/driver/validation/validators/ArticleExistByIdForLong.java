package pl.driver.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.driver.article.ArticleRepository;
import pl.driver.validation.constrains.ArticleExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ArticleExistByIdForLong implements ConstraintValidator<ArticleExist, Long> {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void initialize(ArticleExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null){
            return true;
        } else {
            return articleRepository.existsById(aLong);
        }

    }
}
