package hibernate.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(insertable = false,updatable = false)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email",unique = true)
    @NaturalId
    private String email;
    @OneToOne(targetEntity = Adress.class)
    private Adress adress;
    @OneToMany(targetEntity = Phone.class, fetch = EAGER)
    private List<Phone> userPhones;

}
