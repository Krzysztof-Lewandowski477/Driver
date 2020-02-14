package pl.driver.tag;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity @Table(name = "tags")
@Data @EqualsAndHashCode(of = "id")
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer popularity;

}
