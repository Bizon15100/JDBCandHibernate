package ReadFromDB;

import MyAwsomeDBWriter.City;
import MyAwsomeDBWriter.MySqlConnector;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFromDBSpecTest {

    @Test
    void ReadFromData() throws SQLException {
        // given

        MySqlConnector sqlConnector = new MySqlConnector("world");
        //when
        ResultSet resultSet = sqlConnector.readFromDb("city");

        //then
        System.out.println(resultSet);
        while (resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            System.out.println(id + " " + name);
        }
        sqlConnector.close();
    }

    @Test
    void ReadDataAsList() throws SQLException {
        MySqlConnector mySqlConnector = new MySqlConnector("world");

        List<City> cityList = mySqlConnector.readFromDBAsList("city");

        for (City record:cityList) {
            System.out.println(record.toString());
        }
        mySqlConnector.close();
    }

    @Test
    void createNewSchema() throws SQLException {
        MySqlConnector mySqlConnector = new MySqlConnector("world");

        boolean helloMySQL = mySqlConnector.createNewSchema("oeoeo");

        assertTrue(helloMySQL);
        mySqlConnector.close();

    }

    @Test
    void createNewTable() throws SQLException {

        MySqlConnector mySqlConnector = new MySqlConnector("sda");

        mySqlConnector.createNewTable("'newTable'");
        mySqlConnector.close();

    }

    @Test
    void InsertPreparedStatementTest() throws SQLException {
        MySqlConnector connector = new MySqlConnector("world");

        connector.InsertPreparedStatement(1,"Rafal", "Wojcicki");

        connector.close();
    }

}
