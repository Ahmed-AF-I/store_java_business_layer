package net.seniorsteps.storejava.bll.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import net.seniorsteps.storejava.bll.MenuModule;
import net.seniorsteps.storejava.dal.hibernate.HibernateUtil;
import net.seniorsteps.storejava.dal.hibernate.entiy.Category;
import net.seniorsteps.storejava.dal.hibernate.entiy.Product;

/**
 * Implementation of MenuModule for Category and Product management.
 *
 * @author Ahmed
 */
public class MenuModuleimpl implements MenuModule {

    // --- Category Methods ---
    @Override
    public Category addCategories(Category category) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
            return category;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Category editCategories(Category category) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            Category updatedCategory = entityManager.merge(category);
            entityManager.getTransaction().commit();
            return updatedCategory;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteCategories(Category category) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            Category toDelete = entityManager.merge(category);
            entityManager.remove(toDelete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Category> findAllCategories(Category category) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> root = cq.from(Category.class);

            cq.select(root).orderBy(cb.asc(root.get("name")));
            return entityManager.createQuery(cq).getResultList();
        }
    }

    @Override
    public Category findCategories(Category category) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
        return entityManager.find(Category.class, category.getId());
        }
    }

    @Override
    public List<Category> searchCategoriesByName(String categoryName) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> root = cq.from(Category.class);

            cq.select(root)
                    .where(cb.like(root.get("name"), "%" + categoryName + "%"))
                    .orderBy(cb.asc(root.get("name")));

            return entityManager.createQuery(cq).getResultList();
        }
    }

    // --- Product Methods ---
    @Override
    public Product addProduct(Product product) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return product;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Product editProduct(Product product) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            Product updatedProduct = entityManager.merge(product);
            entityManager.getTransaction().commit();
            return updatedProduct;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteProduct(Product product) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            Product toDelete = entityManager.merge(product);
            entityManager.remove(toDelete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Product> findAllProduct(Product product) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);

            cq.select(root).orderBy(cb.asc(root.get("name")));
            return entityManager.createQuery(cq).getResultList();
        }
    }

    @Override
    public Product findProduct(Product product) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            return entityManager.find(Product.class, product.getId());
        }
    }
}
