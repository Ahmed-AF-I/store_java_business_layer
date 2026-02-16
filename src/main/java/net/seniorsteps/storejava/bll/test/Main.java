/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.seniorsteps.storejava.bll.test;

import java.util.List;
import net.seniorsteps.storejava.dal.hibernate.Repository.CategoryRepository;
import net.seniorsteps.storejava.dal.hibernate.entiy.Category;

/**
 *
 * @author Ahmed
 */
public class Main {

    public static void main(String[] args) {
        CategoryRepository repository = new CategoryRepository();
//        ProductRepository rp = new ProductRepository();
//        BrandRepository br = new BrandRepository();
//
//        Brand brand = br.findBrandById(1);
//
//        Category cat = repository.findCategoryById(2);
//
//        Product product = new Product();
//        product.setName("new Product");
//        product.setCategories(cat);
//        product.setBrand(brand);
//        rp.insertProduct(product);

//        List<Category> cate = repository.findAllCategoriesSQL();
//        for (Category ic : cate) {
//            System.out.print("id -> " + ic.getId());
//            System.out.print(" : ");
//            System.out.println("name -> " + ic.getName());
//
//        }
        List<Category> categ = repository.findAllCategoriesHQL();
        for (Category ic : categ) {
            System.out.print("id -> " + ic.getId());
            System.out.print(" : ");
            System.out.println("name -> " + ic.getName());

        }

    }
}
