package MyAwsomeDBWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class MySqlConnector {

    private final Properties props = readPropertiesFile();
    private static final String URL = "jdbc:mysql://127.0.0.1:3306";
    private String dbName;
    private Connection connection = DriverManager.getConnection(URL, props);;


    public MySqlConnector(String dbName) throws SQLException {
        this.dbName = dbName;
    }

    public MySqlConnector() throws SQLException {
    }

    private static Properties readPropertiesFile() {
        Properties properties = new Properties();

        InputStream is = MySqlConnector.class
                .getClassLoader()
                .getResourceAsStream("app.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return properties;
    }

    public ResultSet readFromDb(String tableName) throws SQLException {
        connection = DriverManager.getConnection(URL + "/" + this.dbName, props);
        Statement statement = connection.createStatement();

        return statement.executeQuery("SELECT * FROM city");
    }

    public List<City> readFromDBAsList(String tableName) throws SQLException {
        ResultSet resultSet = readFromDb(tableName);
        List<City> cityList = new LinkedList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Name");
            String district = resultSet.getString("District");
            String countryCode = resultSet.getString("CountryCode");
            Integer population = resultSet.getInt("Population");

           City city = new City(id,
                   name,
                   countryCode,
                   district,
                   population);

            cityList.add(city);
        }
        return cityList;
    }



    public boolean createNewSchema(String schemaName) throws SQLException {
        connection = DriverManager.getConnection(URL + "/" + this.dbName, props);
        Statement statement = connection.createStatement();
        return statement.execute("CREATE SCHEMA" + schemaName);
    }

    public void createNewTable(String tableName) throws SQLException {
       connection = DriverManager.getConnection(URL , props);
        Statement statement = connection.createStatement();
         statement.execute("CREATE TABLE" +  tableName + " ('name' VARCHAR(16) NOT NULL, 'surname' VARCHAR(24) NOT NULL, 'id' INT  AUTO_INCREMENT, PRIMARY KEY ('id'));");
    }


    public void  InsertPreparedStatement(int id, String name, String surname) throws SQLException {
        connection = DriverManager.getConnection(URL + "/" +this.dbName,props);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO world.oeoeo(name,surname,id) VALUES(?,?,?)");
        statement.setInt(3,id);
        statement.setString(1,name);
        statement.setString(2,surname);
        statement.execute();
    }




    public void close() throws SQLException {
        connection.close();
    }




}
