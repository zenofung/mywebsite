package com.website.company.controller.api;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.website.company.utils.QiNiu;
import com.website.company.utils.ResponseBo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 返回上传需要的 token 和key
 * @author pengyangyan
 */
@RestController
public class QiniuController {

    /**
     *  获取七牛token
     * @return 七牛token
     */
    @GetMapping("/api/getToken")
    public QiNiu getToken() {
        QiNiu qiNiu = new QiNiu();
        String accessKey = "8M0iH2HBY1oQBKYm02VDVqqncBbU-cbmg_dnk9Km";
        String secretKey = "5YvURgIlwnLIOS0D1BL4XhgIp4HNOIyQsfB761PH";
        String bucket = "gongyi-web";
        long expireSecond = 600;
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);
        String token = auth.uploadToken(bucket, null, expireSecond, putPolicy);
        qiNiu.setKey(UUID.randomUUID().toString().replaceAll("\\-", ""));
        qiNiu.setToken(token);
        return qiNiu;

    }


}