package pl.driver.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.driver.role.Role;

import javax.persistence.*;

@Entity @Table(name = "admins")
@Data @EqualsAndHashCode(of = "id")
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    private Role role;

    @Column(nullable = false)
    private String password;

}
