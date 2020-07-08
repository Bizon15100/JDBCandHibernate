package MyAwsomeDBWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbConnector dbConnector = new DbConnector();
        CountryLanguageTable countryLanguageTable = new CountryLanguageTable();
        List<CountryLanguage> list = countryLanguageTable.readTable();

        list.stream().forEach(System.out::println);

        dbConnector.close();
    }
}
