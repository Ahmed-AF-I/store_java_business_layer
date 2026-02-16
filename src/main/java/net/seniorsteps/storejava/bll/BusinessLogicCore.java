/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.seniorsteps.storejava.bll;

import java.util.List;
import net.seniorsteps.storejava.bll.impl.BranchesModuleImpl;
import net.seniorsteps.storejava.bll.impl.MenuModuleimpl;
import net.seniorsteps.storejava.dal.hibernate.entiy.Branch;
import net.seniorsteps.storejava.dal.hibernate.entiy.Category;
import net.seniorsteps.storejava.dal.hibernate.entiy.Product;

/**
 *
 * @author Ahmed
 */
public class BusinessLogicCore {

    private MenuModule menuModule;

    private BranchesModule branchesModule;

    public BusinessLogicCore() {
        menuModule = new MenuModuleimpl();
        branchesModule = new BranchesModuleImpl();
    }

    public Category addCategories(Category category) throws Exception {
        return menuModule.addCategories(category);
    }

    public Category editCategories(Category category) throws Exception {
        return menuModule.editCategories(category);
    }

    public void deleteCategories(Category category) throws Exception {
        menuModule.deleteCategories(category);
    }

    public List<Category> findAllCategories(Category category) throws Exception {
        return menuModule.findAllCategories(category);
    }

    public Category findCategories(Category category) throws Exception {
        return menuModule.findCategories(category);
    }

    public List<Category> searchCategoriesByName(String categoryName) throws Exception {
        return menuModule.searchCategoriesByName(categoryName);
    }

    public Product addProduct(Product product) throws Exception {
        return menuModule.addProduct(product);
    }

    public Product editProduct(Product product) throws Exception {
        return menuModule.editProduct(product);
    }

    public void deleteProduct(Product product) throws Exception {
        menuModule.deleteProduct(product);
    }

    public List<Product> findAllProduct(Product product) throws Exception {
        return menuModule.findAllProduct(product);
    }

    public Product findProduct(Product product) throws Exception {
        return menuModule.findProduct(product);
    }

    // Branches //
    public Branch addBranch(Branch branch) throws Exception {
        return branchesModule.addBranch(branch);
    }

    public Branch editBranch(Branch branch) throws Exception {
        return branchesModule.editBranch(branch);
    }

    public void deletBranch(Branch branch) throws Exception {
        branchesModule.deleteBranch(branch);
    }

    public Branch findBranch(Branch branch) throws Exception {
        return branchesModule.findBranch(branch);
    }

    public List<Branch> findAllBranches() throws Exception {
        return branchesModule.findAllBranches();
    }

}
