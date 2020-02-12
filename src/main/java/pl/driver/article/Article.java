package pl.driver.article;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.driver.quizQuestion.QuizQuestion;
import pl.driver.tag.Tag;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "articles")
@Data @EqualsAndHashCode(of = "id")
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, columnDefinition = "varchar(10000)")
    private String content;

    private String visualContent;

    @Column(nullable = false)
    private Boolean hasQuiz;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<QuizQuestion> quizQuestions = new ArrayList<>();

    @ManyToMany
    private List<Tag> tags;

    @Column(nullable = false)
    private Integer likes;

    @Column(nullable = false)
    private Integer shares;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    @Column(nullable = false)
    private Boolean isAdviceOfTheWeek;


}
