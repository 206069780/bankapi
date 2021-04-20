package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.DataDictionaryDao;
import com.bankapi.bankapi.model.dormatsys.DataDictionary;
import com.bankapi.bankapi.sevice.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName DataDictionaryServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:05
 * @Description TODO
 */
@Service
public class DataDictionaryServiceIml implements DataDictionaryService {

    @Autowired
    DataDictionaryDao dataDictionaryDao;

    @Override
    public List<DataDictionary> getDataDictionary() {
        return dataDictionaryDao.getDataDictionary();
    }
}
