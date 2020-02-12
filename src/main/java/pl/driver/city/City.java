package pl.driver.city;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity @Table(name = "cities")
@Data @EqualsAndHashCode(of = "id")
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false) @Enumerated(value = EnumType.STRING)
    private Region region;

}
