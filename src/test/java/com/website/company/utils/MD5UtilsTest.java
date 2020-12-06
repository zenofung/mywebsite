package com.website.company.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest {

    private static final String SALT = "website";

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    @Test
    public void encrypt() {
        String pswd = "123456";
        String username = "admin";
        String res = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username.toLowerCase() + SALT),
                HASH_ITERATIONS).toHex();
        System.out.println(res);

    }
}