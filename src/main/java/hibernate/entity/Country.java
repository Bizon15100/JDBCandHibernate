package hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "country")
@ToString
@Getter
@Setter
public class Country {
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Continent")
    private String continent;
    @Column(name = "Region")
    private String region;
    @Column(name = "SurfaceArea")
    private double surfaceArea;
    @Column(name = "IndepYear")
    private int indepYear;
    @Column(name = "Population")
    private int population;
    @Column(name = "LifeExpectancy")
    private double lifeExpectancy;
    @Column(name = "GNP")
    private double gnp;
    @Column(name = "GNPOld")
    private double gnpOld;
    @Column(name = "LocalName")
    private String localName;
    @Column(name = "GovernmentForm")
    private String governmentForm;
    @Column(name = "HeadOfState")
    private String headOfState;
    @Column(name = "Capital")
    private int capital;
    @Column(name = "Code2")
    private String code2;

}
