package servlets;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {
    private static HikariDataSource dataSource;
    private static   String  host = "postgres.railway.internal";
    private static String port = "5432";
    private static String database = "railway";
    private static String user = "postgres";
    private static String password = "DMKOtCFRxDXieBspZrQMaqMAxHHdxFBP";
//    private static String password = "postgres";
    // Формируем URL для подключения
    private static   String url = String.format(
            "jdbc:postgresql://%s:%s/%s?ssl=true&sslmode=require",
            host, port, database
    );
//    private static   String url="jdbc:postgresql://localhost:5432/students";
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");
        dataSource = new HikariDataSource(config);
    System.out.println("dataSource " + dataSource);
    System.out.println("url  " + url);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}