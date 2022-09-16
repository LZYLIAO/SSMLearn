import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBTest {

    @Test
    public void testDBconnByC3p0() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db0610");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection conn=dataSource.getConnection();
        System.out.println(conn);
        conn.close();

    }
    @Test
    public void testDBconnByC3p01() throws PropertyVetoException, SQLException {


        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过配置文件获取jdbc配置
        DataSource dataSource=(DataSource)app.getBean("dataSource");
        Connection conn=dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }



}
