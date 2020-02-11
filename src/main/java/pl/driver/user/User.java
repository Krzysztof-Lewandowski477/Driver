package pl.driver.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.driver.article.Article;
import pl.driver.role.Role;
import pl.driver.score.Score;
import pl.driver.userDetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "users")
@Data @EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false) @ToString.Exclude
    private String password;

    @ManyToMany @ToString.Exclude
    private List<Role> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails details;

    @OneToOne(cascade = CascadeType.ALL)
    private Score score;

    @ManyToMany
    private List<Article> read = new ArrayList<>();

}
