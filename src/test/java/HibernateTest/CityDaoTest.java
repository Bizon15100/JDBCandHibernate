package HibernateTest;

import hibernate.configuration.HibernateConf;
import hibernate.dao.CityDao;
import hibernate.entity.City;
import hibernate.entity.Country;
import hibernate.entity.CountryLanguage;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

public class CityDaoTest {


    @Test
    void readCityById(){
        CityDao cityDao = new CityDao();
        City cityById = cityDao.getCityById(3);

        System.out.println(cityById.toString());

    }


    @Test
    void saveTest(){
        CityDao cityDao = new CityDao();
        City city = new City();
        city.setCountryCode("AAA");
        city.setDistrict("Black Mesa");
        city.setPopulation(12);
        city.setName("City17");
        city.setId(5001);

        cityDao.save(city);

    }
    @Test
    void updateTest(){
        CityDao cityDao = new CityDao();
        City city = cityDao.read(2);
        city.setName("Swidnik-Hamburg");

        cityDao.update(city);
        HibernateConf.shutdown();

    }

    @Test
    void deleteByIdTest(){
        CityDao cityDao = new CityDao();
        cityDao.deleteById(2);
        HibernateConf.shutdown();
    }


    @Test
    void readCityByName(){
        CityDao cityDao = new CityDao();
        List<City> cityByName = cityDao.getCityByName("City17");
        cityByName.forEach(System.out::println);
    }

    @Test
    public void createsomething(){
        EntityManager entityManager = HibernateConf.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new CountryLanguage());
        entityManager.persist(new City());
        entityManager.persist(new Country());
        entityManager.getTransaction().commit();
    }
}
