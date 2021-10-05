package com.bootcamp.dao;

import com.bootcamp.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;
import java.util.List;

public class DAO {
    SessionFactory factory;

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
        try {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            for (City o : list)
                session.save(o);

            transaction.commit();
            session.close();
        } catch (PersistenceException e) {
            System.out.println("БД заполнена");
        }
    }

    public List<City> getCitiesFromDB() {
        Session session = factory.openSession();
        return session.createQuery("select c from City c", City.class).getResultList();
    }
}
