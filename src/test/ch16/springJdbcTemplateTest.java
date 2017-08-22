package ch16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 22/08/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ch16/applicationContext.xml")
public class springJdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTest() {
        String sql = "select count(*) from users";
        //queryForObject(sql, Integer.class, arg1, arg2, ...);
        Integer rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        //no auto un/box
        assertTrue(rowCount.equals(Integer.valueOf(3)));
    }

    @Test
    public void rowMapperTest() {
        List<User> users = jdbcTemplate.query(
                "select * from users where id > 1",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User out = new User();
                        out.setID(resultSet.getInt("id"));
                        out.setName(resultSet.getString("name"));
                        out.setEmail(resultSet.getString("email"));
                        out.setDate(resultSet.getDate("date"));
                        return out;
                    }
                });
        assertEquals(users.size(), 2);
        assertEquals(users.get(0).getName(), "alex");
    }


}
