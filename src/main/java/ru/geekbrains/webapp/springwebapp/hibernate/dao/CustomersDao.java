package ru.geekbrains.webapp.springwebapp.hibernate.dao;//package ru.geekbrains.webapp.springwebapp.hibernate.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webapp.springwebapp.hibernate.entities.Customer;
import ru.geekbrains.webapp.springwebapp.hibernate.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomersDao {

    public EntityManager em;

    public CustomersDao(EntityManager em) {
        this.em = em;
    }

    public Customer findById(int id) {
        em.getTransaction().begin();
        Customer anotherCustomer = em.find(Customer.class, id);
        em.getTransaction().commit();
        return anotherCustomer;
    }


    public List<Customer> findAll() {
        em.getTransaction().begin();
        List<Customer> customersList = em.createQuery("from Customer", Customer.class).getResultList();
        return customersList;
    }

    public void deleteById(int id) {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Customer AS o WHERE o.id = :id").setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();

    }

    public void insert(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }


    public void update(Customer customer) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }
}
