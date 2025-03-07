package servlets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    // Метод для получения всех студентов
//    public List<Student> findAllStudents() {
//
//        List<Student> students = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            // 1. Установка соединения с базой данных
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://centerbeam.proxy.rlwy.net:12436//students", // URL базы данных
//                    "postgres", // Имя пользователя
//                    "postgres"  // Пароль
//            );
//
//            // 2. Создание Statement
//            statement = connection.createStatement();
//
//            // 3. Выполнение SQL-запроса
//            String sql = "SELECT id, first_name, sekond_name FROM public.students";
//            resultSet = statement.executeQuery(sql);
//
//            // 4. Обработка результата
//            while (resultSet.next()) {
////                Long id = resultSet.getLong("id");
//                String firstName = resultSet.getString("first_name");
//                String secondName = resultSet.getString("sekond_name");
//
//                // Создание объекта Student и добавление его в список
//                Student student = new Student(1l, firstName, secondName);
//                students.add(student);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Обработка ошибок
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // 5. Закрытие ресурсов
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return students;
//    }
    public  String main() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        // Получаем переменные окружения
        String host = "postgres.railway.internal";
        String port = "5432";
        String database = "railway";
        String user = "postgres";
        String password ="DMKOtCFRxDXieBspZrQMaqMAxHHdxFBP";

        // Формируем URL для подключения
        String url = String.format(
                "jdbc:postgresql://%s:%s/%s?ssl=true&sslmode=require",
                host, port, database
        );
        System.out.println(url);
        // Подключаемся к базе данных
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to PostgreSQL!");
            // Выполняем запрос (пример)
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT version();")) {
                if (rs.next()) {
                   return  "PostgreSQL version: " + rs.getString(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return "PostgreSQL version unknown";
    }

    public String test() throws ClassNotFoundException {

        try (Connection conn = DatabaseUtil.getConnection()) {
           return "Connected to PostgreSQL!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            DatabaseUtil.closeDataSource();
//        }
        return "PostgreSQL version unknown";
    }

}