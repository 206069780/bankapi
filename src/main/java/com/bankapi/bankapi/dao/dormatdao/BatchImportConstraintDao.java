package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.BatchImportConstraint;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName BatchImportConstraintDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:30
 * @Description 批次导入约束数据持久化
 */
@Mapper
public interface BatchImportConstraintDao {

    public List<BatchImportConstraint> getBatchImportConstraints();
}
