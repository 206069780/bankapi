package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName FilePath
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 上午9:57
 * @Description 文件保存路径
 */
public class FilePath implements Serializable {

    public static final Long serialVersionUID = 1619056942584L;

    /*自增id*/
    private int id;

    /*批次id*/
    private String batchID;

    /*生成的文件路径*/
    private String localPath;

    /*银行反馈的文件路径*/
    private String bankPath;

    /*银行受理状态 0 1*/
    private char status;

    public FilePath() {

    }

    public FilePath(int id, String batchID, String localPath, String bankPath, char status) {
        this.id = id;
        this.batchID = batchID;
        this.localPath = localPath;
        this.bankPath = bankPath;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getBankPath() {
        return bankPath;
    }

    public void setBankPath(String bankPath) {
        this.bankPath = bankPath;
    }
    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
//    @Override
//    public String toString() {
//        return "FilePath{" +
//                "id:" + id +
//                ", batchID:" + batchID +
//                ", localPath:'" + localPath + '\'' +
//                ", bankPath:'" + bankPath + '\'' +
//                '}';
//    }

}
