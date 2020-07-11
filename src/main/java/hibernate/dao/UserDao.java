package hibernate.dao;

import hibernate.configuration.HibernateConf;
import hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {

    private Session session;

    public long save(User user) {
        session = HibernateConf
                .getSessionFactory()
                .openSession();
        Transaction transaction = session.beginTransaction();
        long id = (long) session.save(user);
        transaction.commit();
        return id;
    }

    public User read(long id){
        session = HibernateConf
                .getSessionFactory()
                .openSession();
        return session.get(User.class,id);
    }


    public void close() {
        session.close();
    }
}
