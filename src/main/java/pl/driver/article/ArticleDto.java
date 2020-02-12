package pl.driver.article;

import lombok.Data;
import pl.driver.quizQuestion.QuizQuestionDto;
import pl.driver.tag.TagDto;
import pl.driver.validation.constrains.ArticleExist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleDto {

    @ArticleExist
    private Long id;

    private String title;

    private String content;

    private String visualContent;

    private Boolean hasQuiz;

    private Boolean isAdviceOfTheWeek;

    private List<TagDto> tags = new ArrayList<>();

    private Integer likes = 0;

    private Integer shares = 0;

    private LocalDateTime created = LocalDateTime.now();

    private LocalDateTime updated = LocalDateTime.now();

    private List<QuizQuestionDto> quizQuestions = new ArrayList<>();

}
