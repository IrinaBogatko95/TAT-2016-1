package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Contains all actions with database
 *
 * @author Irina Bogatko
 * @version 1.1
 * @since 25.11.2016
 */
public class DBWorker {
    // Number of rows of the table affected by the last query.
    private Integer affected_rows = 0;

    // The value of the auto-increment primary key obtained after
    // add a new record.
    private Integer last_insert_id = 0;

    // Pointer to the instance of the class.
    private static DBWorker instance = null;

    /**
     * Method for the instance (implemented Singleton).
     *
     * @return DBWorker instance
     */
    public static DBWorker getInstance() {
        if (instance == null) {
            instance = new DBWorker();
        }
        return instance;
    }

    /**
     * "Plug" to an instance can not be obtained directly.
     */
    private DBWorker() {
        // Just "plug".
    }

    /**
     * Perform queries on the data sample.
     *
     * @param query sql-query
     * @return set of query
     */
    public ResultSet getDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/phonebook?user=root&password=1234&useUnicode=true" +
                            "&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null on getDBData()!");
        return null;
    }

    /**
     * Perform data modification requests
     *
     * @param query sql-query
     * @return execute update
     */
    public Integer changeDBData(String query) {
        Statement statement;
        Connection connect;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/phonebook?user=root&password=1234&useUnicode=true" +
                            "&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
            statement = connect.createStatement();
            this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            // Получаем last_insert_id() для операции вставки.
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                this.last_insert_id = rs.getInt(1);
            }
            return this.affected_rows;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("null on changeDBData()!");
        return null;
    }

    /**
     * @return last insert id
     */
    public Integer getLastInsertId() {
        return this.last_insert_id;
    }
}

