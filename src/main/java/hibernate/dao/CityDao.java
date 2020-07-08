package hibernate.dao;

import hibernate.configuration.HibernateConf;
import hibernate.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CityDao {
    private Session session;



    public City getCityById(int id){
        session = openSession();
        return session.get(City.class,id);
    }

    public City read(int id){
        return getCityById(id);
    }

    public int save(City city){
        session = openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(city);
        transaction.commit();
        return id;
    }

    public void update(City city){
        session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
    }

    public void delete(City city){
        session = openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
    }
    public void deleteById(int id){
        session = openSession();
        Transaction transaction = session.beginTransaction();
        City city = read(id);
        session.delete(city);
        transaction.commit();
    }



    public List<City> getCityByName(String name){
        Session session = openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<City> criteriaQuery = criteriaBuilder.createQuery(City.class);
        Root<City> root = criteriaQuery.from(City.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Session openSession(){
      return   HibernateConf
                .getSessionFactory()
                .openSession();
    }

}
