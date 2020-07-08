package MyAwsomeDBWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CountryLanguageTable {

    private Connection connection;
    private final String TABLE_NAME = "countrylanguage";

    public List<CountryLanguage> readTable(){
        List<CountryLanguage> countryLanguages = new LinkedList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from countrylanguage" );
           // statement.setString(1,TABLE_NAME);
            ResultSet resultSet = statement.executeQuery();
            countryLanguages = mapToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countryLanguages;
    }

    private List<CountryLanguage> mapToList(ResultSet resultSet) throws SQLException {
        LinkedList<CountryLanguage> countryLanguages = new LinkedList<>();
        while (resultSet.next()){
            CountryLanguage countryLanguage = new CountryLanguage();
            countryLanguage.setCountryCode(resultSet.getString("CountryCode"));
            countryLanguage.setLanguage(resultSet.getString("Language"));
            countryLanguage.setOfficial(resultSet.getBoolean("IsOfficial"));
            countryLanguage.setPercentage(resultSet.getDouble("Percentage"));

            countryLanguages.add(countryLanguage);
        }


        return countryLanguages;
    }
}
