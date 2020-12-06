package com.website.company.generator;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.website.company.utils.QiNiu;

import java.util.UUID;

public class QiniuTest {
    public static void main(String[] args) {
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
        System.out.println(qiNiu.getToken() + "||" + qiNiu.getKey());
    }
}
