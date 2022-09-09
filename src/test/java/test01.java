import com.liao.dao.UserDao;
import com.liao.service.UserService;
import com.liao.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void testCreatObj(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1=(UserDao)app.getBean("userDao");
        UserDao userDao2=(UserDao)app.getBean("userDao");
        userDao1.save();

        // bean标签中的scope属性 singleton（同一个对象） 或 prototype （多个不同对象）
        System.out.println(userDao1);
        System.out.println(userDao2);

    }
    @Test
    public void testCreateObjByFactory(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");

//        静态、动态工厂创建对象
        UserDao userDao1=(UserDao) app.getBean("userDao1");
        userDao1.save();

        UserDao userDao2=(UserDao) app.getBean("userDao2");
        userDao2.save();
    }

    @Test
    public void testInjectObj(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService=(UserService) app.getBean("userService");
        userService.save();

        UserService userService1=(UserService) app.getBean("userService1");
        userService1.save();

        UserService userService2=(UserService) app.getBean("userService2");
        userService2.save();


    }

    @Test
    public void testInjectData(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao) app.getBean("userDao4");
        userDao.save();

    }

}
