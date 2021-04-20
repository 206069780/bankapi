package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.SubsidyItem;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName SubsidyItemService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午3:55
 * @Description SubsidyItemService  interface 补贴项目服务层接口
 */
public interface SubsidyItemService {

    public List<SubsidyItem> getSubsidyItems();
}
