package com.bankapi.bankapi.utils;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

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
            return "参与签名的字符串为空，返回的为null";
        }
        else {
            byte [] bytes = Base64.decodeBase64(str);
            StringBuilder buf = new StringBuilder(bytes.length * 2);

            /*转换为十六进制的字符*/
            for(byte b : bytes) { // 使用String的format方法进行转换

                buf.append(String.format("%02x", b & 0xff));
            }
            /*返回字符串*/
            return buf.toString();
        }
    }
}
