package ch12;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 18/08/2017.
 */
public class inMemoryDBTest {

    private Connection connection;
    private static final String H2_CONNECTION_STRING = "jdbc:h2:mem:test;MODE=MySQL";
    private static final String H2_CONNECTION_USERNAME = "user";
    private static final String H2_CONNECTION_PASSWORD = "password";


    @Before
    public void prepareDb() throws SQLException {
        connection = DriverManager.getConnection(H2_CONNECTION_STRING, H2_CONNECTION_USERNAME, H2_CONNECTION_PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeUpdate("create table teams (id INTEGER, name VARCHAR(100))");
        statement.executeUpdate("insert into teams VALUES (1, 'Squadra rossa')");
        statement.executeUpdate("insert into teams VALUES (2, 'Squadra bianca')");
        statement.executeUpdate("insert into teams VALUES (3, 'Squadra verde')");
        statement.close();
    }

    @Test
    public void memoryDbTest() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select count(*) FROM teams;");
        assertTrue(rs.next());
        assertEquals(3, rs.getInt(1));
    }



}
