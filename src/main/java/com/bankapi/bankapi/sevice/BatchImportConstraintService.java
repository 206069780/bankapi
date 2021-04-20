package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.BatchImportConstraint;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName BatchImportConstraintService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:37
 * @Description 批次导入约束服务层
 */
public interface BatchImportConstraintService {

    public List<BatchImportConstraint> getBatchImportConstraints();
}
