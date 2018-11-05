package com.huawei.oss.action_manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionManagerApplicationTests {

    @Test
    public void contextLoads() {
        Duration duration = Duration.ofMillis(1200L);
        System.err.println(duration);
    }

}
