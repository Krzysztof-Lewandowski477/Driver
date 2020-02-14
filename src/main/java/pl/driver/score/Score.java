package pl.driver.score;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.driver.user.User;

import javax.persistence.*;

@Entity @Table(name = "users_scores")
@Data @EqualsAndHashCode(of = "id")
public class Score {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "int default 0")
    private Integer score;

    @OneToOne
    private User user;

}
