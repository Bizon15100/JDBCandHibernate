package hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "phone")
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(updatable = false,insertable = false)
    private long id;
    @Column(name = "imei")
    private String imei;
    @Column(name = "model")
    private String model;

    @ManyToOne(targetEntity = User.class)
    private User user;
}
