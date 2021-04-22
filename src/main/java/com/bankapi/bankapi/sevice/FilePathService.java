package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.FilePath;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName FilePathService
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 上午11:20
 * @Description FilePath 服务层接口
 */
public interface FilePathService {
    /**
     * 保存生成的文件地址
     *
     * @param filePath 文件实体
     * @return 保存成功的数量
     */
    public int saveLocalPath( FilePath filePath);

    /**
     * 银行反馈的文件地址
     *
     * @param filePath
     * @return
     */
    public int saveBankPath( FilePath filePath);

    /**
     * 根据 batchId 获取当前批次的文档地址
     *
     * @param batchId
     * @return
     */
    public FilePath findPath(@Param("batchId") String batchId);

}
