package com.changjiang.service;

import com.changjiang.common.utils.Assist;
import com.changjiang.entity.Department;

import java.util.List;

public interface DepartmentService{
    long getDepartmentRowCount(Assist assist);
    List<Department> selectDepartment(Assist assist);
    Department selectDepartmentById(Integer id);
    int insertDepartment(Department value);
    int insertNonEmptyDepartment(Department value);
    int deleteDepartmentById(Integer id);
    int deleteDepartment(Assist assist);
    int updateDepartmentById(Department enti);
    int updateDepartment(Department value, Assist assist);
    int updateNonEmptyDepartmentById(Department enti);
    int updateNonEmptyDepartment(Department value, Assist assist);
	/**
	 * 通过id查询department与其对应的workstation岗位
	 * @param id
	 * @return
	 */
    List<Department> findDepartmentAndWorkStation(Integer id);
}