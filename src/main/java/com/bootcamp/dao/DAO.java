package com.bootcamp.dao;

import com.bootcamp.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.util.List;

public class DAO {
    private SessionFactory factory;

    public DAO() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(City.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void writeCitiesToDB(List<City> list) {
        try (Session session = factory.openSession()) {
            for (City o : list) {
                try {
                    session.beginTransaction();
                    session.save(o);
                    session.getTransaction().commit();
                } catch (ConstraintViolationException e) {
                    System.out.println("Дубликат: " + o);
                    session.getTransaction().rollback();
                }
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public List<City> getCitiesFromDB() {
        try (Session session = factory.openSession()) {
            return session.createQuery("select c from City c", City.class).getResultList();
        }
    }
}
