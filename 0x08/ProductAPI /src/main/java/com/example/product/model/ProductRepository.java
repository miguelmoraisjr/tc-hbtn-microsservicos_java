package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Integer id) {
        for (Product product : list){
            if (product.getId() == Long.valueOf(id.longValue())) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product s) {
        boolean check = false;
        if (list.isEmpty()) {
            list.add(s);
        }
        for (Product product : list) {
            if (product.getId() == Long.valueOf(s.getId().longValue())) {
                check = true;
            }
        }
        if (check == false) {
            list.add(s);
        }
    }

    public void updateProduct(Product s) {
        Product product = getProductById(s.getId().intValue());
        int indice = list.indexOf(product);
        if (product != null) {
            product.setCode(s.getCode());
            product.setName(s.getName());
            product.setDescription(s.getDescription());
            product.setPrice(s.getPrice());
            product.setCreatedOne(s.getCreatedOne());
            product.setStatus(s.getStatus());
            list.set(indice, product);
        }
    }

    public void removeProduct(Product s) {
        Product product = getProductById(s.getId().intValue());
        if (product != null) {
            list.remove(s);
        }
    }

    public void addList(List<Product> listOfProducts) {
        for (Product product : listOfProducts) {
            list.add(product);
        }
    }
}
