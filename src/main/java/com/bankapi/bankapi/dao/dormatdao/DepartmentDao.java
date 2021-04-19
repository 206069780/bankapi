package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName DepartmentDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/19 下午3:31
 * @Description TODO
 */

@Mapper
public interface DepartmentDao {

    public List<Department> getAllDepartment();

}
