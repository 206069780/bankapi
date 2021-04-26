package com.bankapi.bankapi;

import com.bankapi.bankapi.utils.AesUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi
 * @ProjectName bankapi
 * @ClassName AesUtilsTest
 * @Email fudaopin@gamil.com
 * @date 2021/4/27 上午10:06
 * @Description 加密解密工具类
 */
public class AesUtilsTest {

    @Value("${AESKEY}")
    String key;
    @Test
    public void aesUtilsTest() throws Exception {



        // 需要加密的字串
        String cSrc = "{\"platformId\":\"bank0833\",\"platformSeqId\":\"2019031910414749\",\"platformTransDate\":\"20190319\",\"platformTransTime\":\"104618\",\"transCode\":\"P2210003\",\"sign\":\"441c4f364a72d8aa37248246bb67e4dd3f532ffbfb5b32c6cd5b948f204d6666\",\"dataString\":\"{\\\"projectNum\\\":\\\"A01800\\\",\\\"batchNum\\\":\\\"LSYKT_1102123_20190301101345\\\",\\\"departmentId\\\":\\\"1102123\\\",\\\"departmentAccount\\\":\\\"42860152622000615616\\\",\\\"departmentAccountName\\\":\\\"乐山惠民惠农财政补贴内部户\\\",\\\"handedOutDate\\\":\\\"20190319\\\",\\\"amt\\\":\\\"1000.0\\\",\\\"count\\\":1,\\\"succAmt\\\":\\\"\\\",\\\"succCount\\\":0,\\\"failAmt\\\":\\\"1000.0\\\",\\\"failCount\\\":1,\\\"dataList\\\":\\\"[{\\\\\\\"serialNum\\\\\\\":\\\\\\\"7550607\\\\\\\",\\\\\\\"bankAccountNumber\\\\\\\":\\\\\\\"402665010024\\\\\\\",\\\\\\\"bankName\\\\\\\":\\\\\\\"乐山农信\\\\\\\",\\\\\\\"payeeId\\\\\\\":\\\\\\\"511126200208305433\\\\\\\",\\\\\\\"payeeName\\\\\\\":\\\\\\\"电信诈骗三\\\\\\\",\\\\\\\"collAccount\\\\\\\":\\\\\\\"6214570381000694450\\\\\\\",\\\\\\\"money\\\\\\\":\\\\\\\"1000.0\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"02\\\\\\\",\\\\\\\"comment\\\\\\\":\\\\\\\"\\\\\\\"}]\\\"}\"}";

        System.out.println(cSrc);
        // 加密
        String enString = AesUtils.Encrypt(cSrc, key);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AesUtils.Decrypt(enString, key);
        System.out.println("解密后的字串是：" + DeString);
    }
}
