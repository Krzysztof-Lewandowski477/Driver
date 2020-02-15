package pl.driver.userDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.driver.city.City;
import pl.driver.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "users_details")
@Data @EqualsAndHashCode(of = "id")
public class UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private City city;
    private Integer yearsOfDrivingLicence;
    @OneToOne
    private User user;


}
