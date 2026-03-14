package com.klu.main;

import com.klu.dao.ProductDAO;
import com.klu.model.Product;

public class MainApp
{

public static void main(String[] args)
{

ProductDAO dao = new ProductDAO();

// Insert Products
dao.addProduct(new Product("Laptop","Dell Laptop",65000,10));
dao.addProduct(new Product("Mobile","Samsung Phone",25000,20));

// Retrieve Product
Product p = dao.getProduct(1);
System.out.println("Product Name: "+p.getName());

// Update Product
dao.updateProduct(1,60000,15);

// Delete Product
dao.deleteProduct(2);

System.out.println("CRUD Operations Completed");

}

}