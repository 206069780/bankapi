package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.FilePathDao;
import com.bankapi.bankapi.model.dormat.FilePath;
import com.bankapi.bankapi.sevice.FilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName FilePathServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 上午11:21
 * @Description TODO
 */

@Service
public class FilePathServiceIml implements FilePathService {

    @Autowired
    FilePathDao filePathDao;

    @Override
    public int saveLocalPath(FilePath filePath) {
        int resNum = filePathDao.saveLocalPath(filePath);
        if (resNum > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int saveBankPath(FilePath filePath) {
        return 0;
    }

    @Override
    public FilePath findPath(String batchId) {
        return null;
    }
}
