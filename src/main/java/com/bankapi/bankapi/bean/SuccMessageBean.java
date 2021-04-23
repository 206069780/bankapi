package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName SuccMessageBean
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 下午2:56
 * @Description SuccMessageBean
 */
public class SuccMessageBean implements Serializable {

    public static final Long serialVersionUID = 1619160989128L;

    private String batchId;

    private String subsId;

    private String depId;

    private String fileName;

    private String md5;

    private int count;

    private int sussAmt;

    SuccMessageBean() {
    }

    public SuccMessageBean(String batchId, String subsId, String depId, String fileName, String md5, int count, int sussAmt) {
        this.batchId = batchId;
        this.subsId = subsId;
        this.depId = depId;
        this.fileName = fileName;
        this.md5 = md5;
        this.count = count;
        this.sussAmt = sussAmt;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSussAmt() {
        return sussAmt;
    }

    public void setSussAmt(int sussAmt) {
        this.sussAmt = sussAmt;
    }
}
