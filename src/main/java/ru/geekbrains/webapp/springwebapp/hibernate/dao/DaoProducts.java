package ru.geekbrains.webapp.springwebapp.hibernate.dao;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.webapp.springwebapp.hibernate.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class DaoProducts {

    static EntityManagerFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();





    public static void main(String[] args) {
        Product product = new Product(9, "Banana", 230);

        findById(3);
        findAll();
        deleteById(2);
        insert(product);
        update(product);
    }

    private static Product findById (int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Product anotherProduct = em.find(Product.class, id);
        em.getTransaction().commit();
        return anotherProduct;
    }


    private static List<Product> findAll() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Product> productList = em.createQuery("from Product", Product.class).getResultList();
        //System.out.println(productList);
        return productList;
    }

    private static void deleteById(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Product AS o WHERE o.id = :id").setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();

    }

    private static void insert(Product product) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }


    private static void update(Product product) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }


}
