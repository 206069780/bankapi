package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.FilePath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName FilePathDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 上午10:08
 * @Description FilePath 数据持久化接口
 */
@Mapper
public interface FilePathDao {

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
