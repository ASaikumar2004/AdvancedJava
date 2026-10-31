package com.ecommerce.main;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;
import com.ecommerce.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                HibernateUtil.getemf();

        EntityManager em = factory.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        // 1. Create Address
        Address address = new Address("Hyderabad", "Telangana");
        em.persist(address);

        // 2. Create Customer
        Customer customer = new Customer(
                "Sai Kumar",
                "sai@gmail.com",
                address
        );

        em.persist(customer);

        // 3. Create Products
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 800);

        em.persist(p1);
        em.persist(p2);

        // 4. Create product list
        List<Product> products = new ArrayList();
        products.add(p1);
        products.add(p2);

        // 5. Create Order
        Orders order = new Orders(
                "2026-10-28",
                50800,
                customer,
                products
        );

        em.persist(order);

        et.commit();

        System.out.println("Data inserted successfully!");

        em.close();
        factory.close();
    }
}
