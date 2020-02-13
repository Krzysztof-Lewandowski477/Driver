package pl.driver.quizQuestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    @Query(value = "SELECT * FROM quiz_questions LIMIT ?1, ?2 ;", nativeQuery = true)
    List<QuizQuestion> findLimitedQuizQuestions(Integer startIndex, Integer amount);

}
