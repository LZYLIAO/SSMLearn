import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {


    @Test
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ttt");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        int row=jdbcTemplate.update("insert into users values(?,?)","Tom",1000);
        System.out.println(row);
    }
    @Test
    public void test2() throws PropertyVetoException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=app.getBean(JdbcTemplate.class);
        int row=jdbcTemplate.update("insert into users values(?,?)","Tom123",1000);
        System.out.println(row);
    }
}
