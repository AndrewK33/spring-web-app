package ru.geekbrains.webapp.springwebapp.hibernate;

import javax.persistence.*;


@Entity
@Table (name = "products")
public class Product {
    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "title")
    private String title;

    @Column (name = "price")
    private int price;



    public Product() {
    }

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
