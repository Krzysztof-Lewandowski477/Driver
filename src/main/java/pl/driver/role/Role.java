package pl.driver.role;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity @Table(name = "roles")
@Data @EqualsAndHashCode(of = "id")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

}
