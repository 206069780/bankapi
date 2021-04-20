package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.BatchImportConstraintDao;
import com.bankapi.bankapi.model.dormat.BatchImportConstraint;
import com.bankapi.bankapi.sevice.BatchImportConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName BatchImportConstraintServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:39
 * @Description 批次导入约束服务层接口实现
 */

@Service
public class BatchImportConstraintServiceIml implements BatchImportConstraintService {

    @Autowired
    BatchImportConstraintDao baseBatchImportConstraintDao;

    @Override
    public List<BatchImportConstraint> getBatchImportConstraints() {
        return baseBatchImportConstraintDao.getBatchImportConstraints();
    }

}
