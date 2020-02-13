package pl.driver.quizQuestion;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class QuizQuestionDto {

    private Long id;

    private String question;

    private Map<Integer, String> answersContent = new HashMap<>();

    private Map<Integer, Boolean> correctAnswers = new HashMap<>();

    private Map<Integer, String> answersVisualContent = new HashMap<>();

}
