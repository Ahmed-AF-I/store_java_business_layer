/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.seniorsteps.storejava.bll;

import java.util.List;
import net.seniorsteps.storejava.dal.hibernate.entiy.Branch;

/**
 *
 * @author Ahmed
 */
public interface BranchesModule {

    Branch addBranch(Branch branch) throws Exception;

    Branch editBranch(Branch branch) throws Exception;

    void deleteBranch(Branch branch) throws Exception;

    Branch findBranch(Branch branch) throws Exception;

    List<Branch> findAllBranches() throws Exception;
}
