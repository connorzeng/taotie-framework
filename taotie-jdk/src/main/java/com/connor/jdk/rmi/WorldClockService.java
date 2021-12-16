package com.connor.jdk.rmi;

import lombok.extern.slf4j.Slf4j;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class WorldClockService  implements  WorldClock{

    static {
        //log.info("hello worldClockService");
        System.out.println("my name is devil");
    }
    @Override
    public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}