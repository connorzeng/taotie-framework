package com.connnot.taotie.provier;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestPidMod {

    @Test
    public void testPid() {

        String pid = "ABC001";
        log.info(String.valueOf(pid.hashCode() % 4));

        pid = "ABC002";
        log.info(String.valueOf(pid.hashCode() % 4));

        pid = "ABC003";
        log.info(String.valueOf(pid.hashCode() % 4));

        pid = "ABC004";
        log.info(String.valueOf(pid.hashCode() % 4));



    }

}
