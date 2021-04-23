package com.bankapi.bankapi;

import com.bankapi.bankapi.bean.ApiData;
import com.bankapi.bankapi.bean.BankIssuedData;
import com.bankapi.bankapi.dao.dormatdao.APIDataDao;
import com.bankapi.bankapi.dao.dormatdao.ApprovalBatchReplyDao;
import com.bankapi.bankapi.dao.dormatdao.BankIssuedDataDao;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.iml.ApprovalProcessEventServiceIml;
import com.bankapi.bankapi.utils.BankIssuedDataUtils;
import com.bankapi.bankapi.utils.BankReplyMessage;
import com.bankapi.bankapi.utils.StringUtils;
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

        int i = approvalProcessEventServiceIml.statusUpdat("2021030826","2","1");
        System.out.println(i);
    }

    @Autowired
    ApprovalBatchReplyDao approvalBatchReplyDao;

    @Autowired
    BankReplyMessage bankReplyMessage;

    @Test
    public void ApprovalBatchReplyDaoTest() {
//        BankReplyMessage bankReplyMessage = new BankReplyMessage();
        bankReplyMessage.readTxt("/home/kali/IdeaProjects/bankapi/src/main/resources/DIR_TXT/20210423/20210423_2021030829.txt");

//        Map<BigDecimal, BigDecimal> map=approvalBatchReplyDao.getapprovalId("2021030821", "7287011010040108");
//        System.out.println(map.get("ID") );

    }
}
