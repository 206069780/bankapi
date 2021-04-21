package com.bankapi.bankapi.utils;

import com.bankapi.bankapi.bean.BankIssuedData;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName BankIssuedDataUtils
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 下午3:47
 * @Description 生成银行发放数据的文件
 */

@Component
public class BankIssuedDataUtils {

    public String creteBankIssuedDataTxt(List<BankIssuedData> IssuedData) throws IOException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dirName = dateFormat.format(date);
        String fileName = "";

        for (BankIssuedData bankIssuedData :
                IssuedData) {
            String bacthId = bankIssuedData.getPCID();
            fileName = dateFormat.format(date) + "_" + bacthId + ".txt";
        }


        File dir = new File("/home/kali/IdeaProjects/bankapi/" + dirName);
        File file = new File("/home/kali/IdeaProjects/bankapi/" + dirName + "/" + fileName);

        BufferedWriter writer = null;

        if (dir.exists()) {
            if (!file.exists()) {
                file.createNewFile();
                writeMessage(new FileWriter(file), IssuedData);
                return fileName + "创建成功";
            } else {
                writeMessage(new FileWriter(file), IssuedData);
                return fileName + " 数据已更新";
            }
        } else {
            if (dir.mkdirs()) {
                if (!file.exists()) {
                    file.createNewFile();
                    writeMessage(new FileWriter(file), IssuedData);
                    return fileName + "创建成功";
                }
                {
                    writeMessage(new FileWriter(file), IssuedData);
                    return fileName + " 数据已更新";
                }
            } else {
                return "文件夹 " + dirName + " 创建失败";
            }
        }
    }

    private void writeMessage(FileWriter writer, String str) throws IOException {
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
