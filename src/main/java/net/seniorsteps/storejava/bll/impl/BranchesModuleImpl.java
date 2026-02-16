package net.seniorsteps.storejava.bll.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import net.seniorsteps.storejava.bll.BranchesModule;
import net.seniorsteps.storejava.dal.hibernate.HibernateUtil;
import net.seniorsteps.storejava.dal.hibernate.entiy.Branch;

/**
 * Implementation of BranchesModule based on JPA and HibernateUtil.
 *
 * * @author Ahmed
 */
public class BranchesModuleImpl implements BranchesModule {

    @Override
    public Branch addBranch(Branch branch) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(branch);
            entityManager.getTransaction().commit();
            return branch;
        } catch (Exception ex) {
            // يمكنك هنا طباعة الـ stack trace أو التعامل مع الخطأ حسب حاجتك
            throw ex;
        }
    }

    @Override
    public Branch editBranch(Branch branch) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            // استخدام merge لتحديث البيانات وإرجاع الكائن المحدث
            Branch updatedBranch = entityManager.merge(branch);
            entityManager.getTransaction().commit();
            return updatedBranch;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteBranch(Branch branch) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            // في JPA يجب عمل merge قبل الحذف إذا كان الكائن detached
            Branch toDelete = entityManager.merge(branch);
            entityManager.remove(toDelete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Branch findBranch(Branch branch) throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            // استخدام الـ id الخاص بكلاس Branch للبحث
            return entityManager.find(Branch.class, branch.getId());
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Branch> findAllBranches() throws Exception {
        try (EntityManager entityManager = HibernateUtil.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Branch> cq = cb.createQuery(Branch.class);
            Root<Branch> root = cq.from(Branch.class);

            // جلب جميع الفروع مرتبة حسب الاسم تصاعدياً
            cq.select(root).orderBy(cb.asc(root.get("name")));

            return entityManager.createQuery(cq).getResultList();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
