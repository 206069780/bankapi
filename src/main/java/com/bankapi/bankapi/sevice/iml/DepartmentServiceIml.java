package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.DepartmentDao;
import com.bankapi.bankapi.model.dormat.Department;
import com.bankapi.bankapi.sevice.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName DepartmentServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/19 下午4:40
 * @Description TODO
 */

@Service
public class DepartmentServiceIml implements DepartmentService {


    @Autowired
    DepartmentDao departmentDao;
    /**
     * 获取所有部门信息
     * @return
     */
    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.getAllDepartment();
    }
}
