package hibernate.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConf {

    private static final String CONFIG_FILE = "hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure(CONFIG_FILE);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown(){
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
