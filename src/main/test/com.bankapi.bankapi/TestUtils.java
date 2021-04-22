package com.bankapi.bankapi;

import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.ParamResponseBean;
import com.bankapi.bankapi.bean.ParamResponseMessage;
import com.bankapi.bankapi.bean.RequestMessageBean;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import org.junit.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi
 * @ProjectName bankapi
 * @ClassName Test
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 上午10:00
 * @Description utils 测试类
 */
public class TestUtils {

    @Test
    public void getUID() {
        Long uid = System.currentTimeMillis();
        if (uid % 2 == 0) {
            System.out.println("public static final Long serialVersionUID =" + uid + "L;");
        } else {
            System.out.println("public static final Long serialVersionUID =" + "-" + uid + "L;");
        }
    }


    @Test
    public void classtojsontest() {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat timeFormat = new SimpleDateFormat("HHmmss");

        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
//        System.out.println(JSONObject.toJSON(
//                new ParamResponseBean("fas", "fsa", new Date(),new Date(),"fsha","fadshy",new ParamResponseMessage("fhasdf",'0'))));
        System.out.println(date);
        System.out.println(time);
    }

}
