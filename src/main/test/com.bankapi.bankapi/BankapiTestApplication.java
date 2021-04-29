package com.bankapi.bankapi;

import com.alibaba.fastjson.JSONObject;
import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.bean.BankIssuedData;
import com.bankapi.bankapi.dao.dormatdao.APIDataDao;
import com.bankapi.bankapi.dao.dormatdao.ApprovalBatchReplyDao;
import com.bankapi.bankapi.dao.dormatdao.BankIssuedDataDao;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.iml.ApprovalBatchReplyServiceIml;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.utils.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi
 * @ProjectName bankapi
 * @ClassName BankapiTestApplication
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 下午2:18
 * @Description TODO
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BankapiTestApplication {

    @Autowired
    APIDataDao apiDataDao;

    @Autowired
    StringUtils stringUtils;

    @Autowired
    ParamUtils paramUtils;

    @Test

    public void testTest() {

        List<ApiData> list = apiDataDao.getApiDataList();

        for (int i = 0; i < apiDataDao.getApiDataList().size(); i++) {
            list.get(i).setPlatFormId(stringUtils.getRandomString());
        }
        System.out.println(list);
    }

    @Autowired
    BankIssuedDataDao bankIssuedDataDao;

    @Autowired
    BankIssuedDataUtils bankIssuedDataUtils;

    @Value("${file.filePath}")
    private String filePaeh;

    @Test
    public void get() throws Exception {
        List<BankIssuedData> bankIssuedDatas = bankIssuedDataDao.getBankIssuedDataList();
        bankIssuedDataUtils.creteBankIssuedDataTxt(bankIssuedDatas);
//        System.out.println(this.filePaeh);
    }

    @Autowired
    ApprovalProcessEventServiceIml approvalProcessEventServiceIml;

    @Test
    public void updateApprovalProcessEventServiceIml() {

        int i = approvalProcessEventServiceIml.statusUpdat("2021030826", "2", "1");
        System.out.println(i);
    }

    @Autowired
    ApprovalBatchReplyDao approvalBatchReplyDao;

    @Autowired
    BankReplyMessage bankReplyMessage;

    @Test
    public void ApprovalBatchReplyDaoTest() {
//        BankReplyMessage bankReplyMessage = new BankReplyMessage();
        bankReplyMessage.readTxt("/home/kali/IdeaProjects/bankapi/src/main/resources/DIR_TXT/20210423/20210423_20210330105.txt.txt");

//        Map<BigDecimal, BigDecimal> map=approvalBatchReplyDao.getapprovalId("2021030821", "7287011010040108");
//        System.out.println(map.get("ID") );

    }

    @Value("${AESKEY}")
    String key;

    @Test
    public void aesUtilsTest() throws Exception {

        System.out.println(key + " " + key.length());

        // 需要加密的字串
        String cSrc = "{\"platformId\":\"bank0833\",\"platformSeqId\":\"2019031910414749\",\"platformTransDate\":\"20190319\",\"platformTransTime\":\"104618\",\"transCode\":\"P2210003\",\"sign\":\"441c4f364a72d8aa37248246bb67e4dd3f532ffbfb5b32c6cd5b948f204d6666\",\"dataString\":\"{\\\"projectNum\\\":\\\"A01800\\\",\\\"batchNum\\\":\\\"LSYKT_1102123_20190301101345\\\",\\\"departmentId\\\":\\\"1102123\\\",\\\"departmentAccount\\\":\\\"42860152622000615616\\\",\\\"departmentAccountName\\\":\\\"乐山惠民惠农财政补贴内部户\\\",\\\"handedOutDate\\\":\\\"20190319\\\",\\\"amt\\\":\\\"1000.0\\\",\\\"count\\\":1,\\\"succAmt\\\":\\\"\\\",\\\"succCount\\\":0,\\\"failAmt\\\":\\\"1000.0\\\",\\\"failCount\\\":1,\\\"dataList\\\":\\\"[{\\\\\\\"serialNum\\\\\\\":\\\\\\\"7550607\\\\\\\",\\\\\\\"bankAccountNumber\\\\\\\":\\\\\\\"402665010024\\\\\\\",\\\\\\\"bankName\\\\\\\":\\\\\\\"乐山农信\\\\\\\",\\\\\\\"payeeId\\\\\\\":\\\\\\\"511126200208305433\\\\\\\",\\\\\\\"payeeName\\\\\\\":\\\\\\\"电信诈骗三\\\\\\\",\\\\\\\"collAccount\\\\\\\":\\\\\\\"6214570381000694450\\\\\\\",\\\\\\\"money\\\\\\\":\\\\\\\"1000.0\\\\\\\",\\\\\\\"status\\\\\\\":\\\\\\\"02\\\\\\\",\\\\\\\"comment\\\\\\\":\\\\\\\"\\\\\\\"}]\\\"}\"}";

        System.out.println(cSrc);
        // 加密
        String enString = AesUtils.Encrypt(cSrc, key);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String str = "WBdeoUWiJxklb3mZuCb4sqp+1/Jr8ZHAJCHk/I8K8xcKS8Uo6zW/bfBQs2LrbWQR4lDx2bX9Pl/0ymPYapmQVIPw/MeU/MOVw07gA2RzxqZU2bJxhUjhUxqzAaVSPYOa/NQXEyXARt9JU3IyQFUHjdDtq2ZfPuEb4rjpSm1hrmUVhwHjftV3ug6L5cMHSlflZKr4NCoiKxzF1QOjgsEdjF0lD+ohWWFIQaZ700ZvLwl5rsKm9HbrJCWF2S1LBqIDGyMq5roM6cRv9QKaTUtrcMErx8S0t2avEvPhG9Xf60rLpiYVrfwt7N3keu9gvOZUNZ9naWe6Rev4l7wns0M1xClY2F3x2E9YIaJ+yb5LBJBiz1Cr3e6fNidUSembyGT2DiiUBz8nHk9EtajOeoobAKUViLZhyWOkZJQfSCWLD8heRh0+M8WzKwBqyfCjXrfv4WL53HxPQjlvh6K1AeQ6Jm7m15N2vf9viHbTigfWUQP0RC95hKIzFpdnBxZHbxTCeLUdv7JptGCSLRNpY9b2acM4Tsf33l/oRTGbsl+xfZsGBF7VYyZVkxLxCqPamEZWR93VgbMcRDVsLaNnHqDRdKpLF3vh59r7PH32I4NwhIj14c7MIL9Bso0urwNzMQM59Wn8akcOU5swlGhnk4CrVnwD1AitFp16f5zdL+Wsclo=";
        String DeString = AesUtils.Decrypt(str, key);
        System.out.println("解密后的字串是：" + DeString);
    }


    @Autowired
    ApprovalBatchReplyServiceIml approvalBatchReplyServiceIml;

    @Test
    public void ApprovalBatchReplyServiceIml() {
        System.out.println(approvalBatchReplyServiceIml.findByDtilId(1400));
    }

    @Test
    public void test() throws Exception {

        paramUtils.pram2(JSONObject.parseObject("{\n" +
                " \"platformId\": \"1364825837773385728\",\n" +
                " \"platformSeqId\": \"1364825837773385728\",\n" +
                " \"platformTransDate\": \"20210225\",\n" +
                " \"platformTransTime\": \"171500\",\n" +
                " \"transCode\": \"P2210003\",\n" +
                " \"sign\": \"f74989214b52c3f4d0b30adf35007a1f9a2f72e1e645c93ce048ead3f852073c\",\n" +
                " \"dataString\": \"{\\\"batchId\\\":\\\"202102241\\\",\\\"subsidyCode\\\":\\\"B480000582\\\",\\\"deptId\\\":\\\"582\\\",\\\"fileName\\\":\\\"RSQ_20210224_202102241.txt\\\",\\\"md5\\\":\\\"29df3b916d7230792fd6f9b989e0b5a4\\\",\\\"count\\\":2,\\\"amt\\\":200,\\\"succCount\\\":1,\\\"succAmt\\\":100}\"\n" +
                "}"));
    }
}
