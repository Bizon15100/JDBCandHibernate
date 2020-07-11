package hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "adress")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Adress {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private long id;
    @Column(name = "street")
    private String street;
    @Column(name = "postal_code")
    private String postalCode;

    @OneToOne(targetEntity = User.class)
    private User user;
}
