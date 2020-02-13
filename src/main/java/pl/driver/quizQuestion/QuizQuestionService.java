package pl.driver.quizQuestion;

import java.util.List;

public interface QuizQuestionService {
    List<QuizQuestion> getAll();

    QuizQuestion getOne(Long id);

    void saveQuizQuestion(QuizQuestion quizQuestion);

    void deleteQuizQuestion(Long id);

    List<QuizQuestion> getLimitedQuizQuestion(Integer startIndex, Integer amount);
}
