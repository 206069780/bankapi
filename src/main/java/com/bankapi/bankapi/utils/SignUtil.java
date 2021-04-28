package com.bankapi.bankapi.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName Sign
 * @Email fudaopin@gamil.com
 * @date 2021/4/27 上午10:24
 * @Description 签名工具
 */
public class SignUtil {

    public static String getSign(String str) {

        if (str == null || str.length() == 0) {
            return "参与签名的字符串不能为空";
        } else {
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return Hex.encodeHexString(digest.digest(str.getBytes(StandardCharsets.UTF_8)));
        }
    }

    @Test
    public void getSign() throws Exception {
        System.out.println(getSign("13574791879710720002021042815530720210428155307P22100031234567891011111{\"status\": \"0\", \"batchId\": \"202102241\", \"subsidyCode\": \"B480000582\", \"deptId\": \"582\", \"fileName\": \"RSQ_20210224_202102241.txt\", \"md5\": \"**************************\", \"count\": 0, \"amt\": 0, \"succCount\": 0, \"succAmt\": 0}"));
    }
}
