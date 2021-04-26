package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName BankGetDataParamService
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午4:03
 * @Description TODO
 */
public interface BankGetDataParamService {


    /**
     * 保存银行受理的批次信息
     *
     * @param bank 批次相关信息
     * @return 增加的数据是否成功
     */
    public boolean DataParamSave(BankGetDataParam bank);

    /**
     * 银行受理结果反馈 状态更新
     *
     * @param id
     * @return
     */
    public boolean DataParamUpDataParam(String status, String id);

    /**
     * 获取正在受理的批次号
     *
     * @return
     */
    public List<BankGetDataParam> getParam();

    /**
     * 获取完成的批信息
     * @return
     */
    List<BankGetDataParam> getfinish();
}
