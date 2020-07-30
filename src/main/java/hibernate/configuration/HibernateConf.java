package hibernate.configuration;

import hibernate.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConf {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.buildSessionFactory();
            configuration.addAnnotatedClass(Adress.class);
            configuration.addAnnotatedClass(Phone.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
        }
        return sessionFactory;
    }

    public static void shutdown(){
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
