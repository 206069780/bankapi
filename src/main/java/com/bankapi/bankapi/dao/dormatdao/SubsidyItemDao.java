package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.SubsidyItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName SubsidyItemDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午3:49
 * @Description SubsidyItem 补贴项目
 */
@Mapper
public interface SubsidyItemDao {

    public List<SubsidyItem> getSubsidyItemList();
}