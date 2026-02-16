/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.seniorsteps.storejava.bll;

import java.util.List;
import net.seniorsteps.storejava.dal.hibernate.entiy.Category;
import net.seniorsteps.storejava.dal.hibernate.entiy.Product;

/**
 *
 * @author Ahmed
 */
public interface MenuModule {

    Category addCategories(Category category) throws Exception;

    Category editCategories(Category category) throws Exception;

    void deleteCategories(Category category) throws Exception;

    List<Category> findAllCategories(Category category) throws Exception;

    Category findCategories(Category category) throws Exception;

    List<Category> searchCategoriesByName(String categoryName) throws Exception;

    Product addProduct(Product product) throws Exception;

    Product editProduct(Product product) throws Exception;

    void deleteProduct(Product product) throws Exception;

    List<Product> findAllProduct(Product product) throws Exception;

    Product findProduct(Product product) throws Exception;

}
