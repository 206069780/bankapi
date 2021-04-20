package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.DataDictionary;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName DataDictionaryService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:03
 * @Description DataDictionary 实现层
 */
public interface DataDictionaryService {

    public List<DataDictionary> getDataDictionary();
}
