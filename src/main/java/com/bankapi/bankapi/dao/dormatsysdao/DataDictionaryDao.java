package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.DataDictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatsysdao
 * @ProjectName bankapi
 * @ClassName DataDictionaryDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:56
 * @Description DataDictionary数据持久化操作
 */

@Mapper
public interface DataDictionaryDao{

    public List<DataDictionary> getDataDictionary();
}
