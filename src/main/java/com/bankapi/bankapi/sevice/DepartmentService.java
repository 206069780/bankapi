package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.Department;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName DepartmentService
 * @Email fudaopin@gamil.com
 * @date 2021/4/19 下午4:39
 * @Description TODO
 */
public interface DepartmentService {

    /**
     * 获取所有部门
     * @return
     */
    public List<Department> getDepartmentList();
}
