package pl.driver.quizQuestion;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashMap;

@Entity @Table(name = "quiz_questions")
@Data @EqualsAndHashCode(of = "id")
public class QuizQuestion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private HashMap<Integer, String> answersContent;

    @Column(nullable = false)
    private HashMap<Integer, Boolean> correctAnswers;

    private HashMap<Integer, String> answersVisualContent;


}
