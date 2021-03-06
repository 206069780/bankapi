package com.bankapi.bankapi.utils;

import com.bankapi.bankapi.bean.BankIssuedData;
import com.bankapi.bankapi.dao.dormatdao.ApprovalProcessEventDao;
import com.bankapi.bankapi.dao.dormatdao.FilePathDao;
import com.bankapi.bankapi.model.dormat.FilePath;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.sevice.iml.FilePathServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${file.dirPath}")
    private String dirPath;

    @Value("${file.filePath}")
    private String filePath;

    public void creteBankIssuedDataTxt(List<BankIssuedData> issuedDat) throws IOException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dirName = dateFormat.format(date);
        writeMessage(issuedDat, dirName);
    }

    private void writeMessage(List<BankIssuedData> dataList, String dirPath) throws IOException {

        File dir = new File(this.dirPath + "/" + dirPath);

        /*如果文件夹存在*/
        if (dir.exists()) {
            writeIntoTxt(dataList, dirPath);
        }
        /*文件夹不再存在 先创建文件夹，在创建文件*/
        else {
            if (dir.mkdirs()) {
                writeIntoTxt(dataList, dirPath);
            } else {
                System.out.println(String.format("文件夹%s创建失败", dirPath));
            }
        }
    }

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventServiceIml;

    private void writeIntoTxt(List<BankIssuedData> dataList, String dirPath) throws IOException {
        for (BankIssuedData bankIssuedData : dataList) {
            String fileName = "REQ_"+ dirPath + "_" + bankIssuedData.getPCID() + ".txt";
            File file = new File(this.filePath + "/" + dirPath + "/" +fileName);

            /*如果文件存在 直接写入数据*/
            if (file.exists()) {

                FileWriter writer = new FileWriter(file, true);

                writer.write(bankIssuedData.getPCID() + ","
                        + bankIssuedData.getName() + ","
                        + bankIssuedData.getBankID() + ","
                        + bankIssuedData.getMory() + ","
                        + bankIssuedData.getSFZH() + ","
                        + bankIssuedData.getBTMC() + "\n");
                writer.flush();
                writer.close();
            }
            /*文件不存在，先创建文件，并且将文件路径保存至数据库并完成txt数据写入*/
            else {
                if (file.createNewFile()) {

                    FileWriter writer = new FileWriter(file, true);

                    writer.write(bankIssuedData.getPCID() + ","
                            + bankIssuedData.getName() + ","
                            + bankIssuedData.getBankID() + ","
                            + bankIssuedData.getMory() + ","
                            + bankIssuedData.getSFZH() + ","
                            + bankIssuedData.getBTMC() + "\n");
                    writer.flush();
                    writer.close();
                    /*存入数据库*/
                    approvalProcessEventServiceIml.updateFileName(bankIssuedData.getPCID(), fileName,CheckSum.fileCS(file.getAbsolutePath()));
                }
            }

        }
    }
}
