package HibernateTest;

import hibernate.configuration.HibernateConf;
import hibernate.dao.UserDao;
import hibernate.entity.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.util.List;

public class CityDaoTest {

    private Session session;

    @Test
    void saveTest(){
        session = HibernateConf
                .getSessionFactory()
                .openSession();
        User user = new User();
        user.setName("Zbychu");
        user.setLastName("Motyka");
        user.setEmail("zbychu@gmail.com");

        UserDao userDao = new UserDao();
        long id = userDao.save(user);
        userDao.close();

        User user1 = userDao.read(id);

        System.out.println(user1.toString());

        session.close();
        HibernateConf.shutdown();

    }
}