package nsbm_higher_education;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//for get database connection
public class DatabaseConnection {
    public static Connection getDatabaseConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nsbm?zeroDateTimeBehavior=convertToNull","root","");
        }
        catch(ClassNotFoundException | SQLException e){
        }
        return connection;
    }
}

