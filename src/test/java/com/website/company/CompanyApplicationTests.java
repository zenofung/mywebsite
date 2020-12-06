package com.website.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(new Date());
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("hh:mm:ss");
        System.out.println(sdf.format(date));
    }

}
