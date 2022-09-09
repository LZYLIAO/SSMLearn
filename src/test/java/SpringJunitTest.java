import com.liao.config.SpringConfiguration;
import com.liao.dao.UserDao;
import com.liao.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringJUnitConfig(SpringConfiguration.class)
public class SpringJunitTest {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Test
    public void  testJunit() throws SQLException {
        userService.save();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


}
