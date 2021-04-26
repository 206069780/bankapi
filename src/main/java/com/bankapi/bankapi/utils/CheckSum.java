package com.bankapi.bankapi.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName CheckSum
 * @Email fudaopin@gamil.com
 * @date 2021/4/27 下午4:00
 * @Description 文件校验和
 */
public class CheckSum {

    /**
     * 文件就哦啊眼和
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String fileCS(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        return DigestUtils.md5Hex(fileInputStream);
    }

}
