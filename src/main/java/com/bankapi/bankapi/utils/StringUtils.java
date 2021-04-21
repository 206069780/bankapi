package com.bankapi.bankapi.utils;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.utils
 * @ProjectName bankapi
 * @ClassName StringUtils
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 下午1:06
 * @Description 字符串工具类
 */
@Component
public class StringUtils {

    public String getRandomString(){

        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(r.nextInt(9));
        }
        return stringBuilder.toString();
    }
}
