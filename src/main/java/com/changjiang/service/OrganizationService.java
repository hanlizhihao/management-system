package com.changjiang.service;

import com.changjiang.common.Assist;
import com.changjiang.entity.Organization;
import com.changjiang.viewModel.FunctionNode;

import java.util.List;

public interface OrganizationService{
    long getOrganizationRowCount(Assist assist);
    List<Organization> selectOrganization(Assist assist);
    Organization selectOrganizationById(Integer id);
    int insertOrganization(Organization value);
    int insertNonEmptyOrganization(String name, Integer pId);
    int deleteOrganizationById(Integer id);
    int deleteOrganization(Assist assist);
    int updateOrganizationById(Organization enti);
    int updateOrganization(Organization value, Assist assist);
    int updateNonEmptyOrganizationById(Organization enti);
    int updateNonEmptyOrganization(Organization value, Assist assist);
    /**
     * 通过currentLevelId查找其下所有的组织
     * @param currentLevelId
     * @return
     */
    List<Organization> selectOrganizationByCurrentLevelId(Integer currentLevelId);
    List<FunctionNode> getAllOrganization();
}