package com.klu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.config.HibernateUtil;
import com.klu.model.Product;

public class ProductDAO 
{

    // Insert Product
    public void addProduct(Product product)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        session.close();
    }

    // Retrieve Product by ID
    public Product getProduct(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product p = session.get(Product.class, id);
        session.close();
        return p;
    }

    // Update Product
    public void updateProduct(int id, double price, int quantity)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if(p != null)
        {
            p.setPrice(price);
            p.setQuantity(quantity);
            session.update(p);
            System.out.println("Product updated successfully");
        }
        else
        {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }

    // Delete Product
    public void deleteProduct(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if(p != null)
        {
            session.delete(p);
            System.out.println("Product deleted successfully");
        }
        else
        {
            System.out.println("Product not found");
        }

        tx.commit();
        session.close();
    }
}