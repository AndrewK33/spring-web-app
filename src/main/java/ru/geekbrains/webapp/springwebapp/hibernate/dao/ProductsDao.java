package ru.geekbrains.webapp.springwebapp.hibernate.dao;

import org.hibernate.engine.spi.EntityEntryFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webapp.springwebapp.hibernate.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductsDao {

    private final EntityManager em;

    public ProductsDao(@Qualifier("db1EntityManager") EntityManager entityManager) {
        this.em = entityManager;
    }

    public Product findById(int id) {
        em.getTransaction().begin();
        Product anotherProduct = em.find(Product.class, id);
        em.getTransaction().commit();
        return anotherProduct;
    }


    public List<Product> findAll() {
        em.getTransaction().begin();
        List<Product> productList = em.createQuery("from Product", Product.class).getResultList();
        em.getTransaction().commit();
        return productList;
    }

    public void deleteById(int id) {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Product AS o WHERE o.id = :id").setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();

    }

    public void insert(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }


    public void update(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

}
