package MyAwsomeDBWriter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;

    public City(Integer id, String name, String countryCode, String district, Integer population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}

