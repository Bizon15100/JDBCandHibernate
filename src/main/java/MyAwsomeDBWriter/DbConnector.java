package MyAwsomeDBWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {
    private Connection connection;
    private String propsFileName;
    private Properties properties;

    private Properties getProperties(){
        Properties properties = new Properties();
        DbConnector.class
                .getClassLoader()
                .getResourceAsStream(propsFileName);

        return properties;
    }


    public Connection getConnection() {
        if (this.connection == null){
            this.properties = getProperties();
            String dbUrl = properties.getProperty("dburl");
            try {
                this.connection = DriverManager.getConnection(dbUrl,properties);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public void close(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
