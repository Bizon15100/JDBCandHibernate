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
@Getter
@Setter
@Table(name = "countrylanguage")
@ToString
public class CountryLanguage {
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "Language")
    private String language;
    @Column(name = "IsOfficial")
    private boolean isOfficial;
    @Column(name = "Percentage")
    private double percentage;

    public CountryLanguage(String countryCode, String language, boolean isOfficial, double percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

}
