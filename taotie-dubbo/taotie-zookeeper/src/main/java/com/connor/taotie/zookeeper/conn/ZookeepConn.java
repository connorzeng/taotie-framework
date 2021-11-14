package com.connor.taotie.zookeeper.conn;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class ZookeepConn {


    /**
     * 这里要
     */
    private static CountDownLatch connectionLatch = new CountDownLatch(1);

    @PostConstruct
    public void initZookeep() throws IOException, KeeperException, InterruptedException {

        ZooKeeper zk = new ZooKeeper("192.168.31.18:2181", 5000, (e) -> {
            log.info("recive event: " + e);
            if (e.getState() == Watcher.Event.KeeperState.SyncConnected) {
                connectionLatch.countDown();
            }
        });
        connectionLatch.await();


        String s = zk.create("/connor", "zenggang".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);

        //
        zk.exists("/connor", (e) -> {
            log.info("reviced /connor" + e.getType());
            if (Watcher.Event.EventType.NodeCreated.equals(e.getType())) {
                log.info("node created");
            } else if (Watcher.Event.EventType.NodeDeleted.equals(e.getType())) {
                log.info("node deleted");
            } else if (Watcher.Event.EventType.NodeDataChanged.equals(e.getType())) {
                log.info("node change ");
            }
        });

        Stat stat = zk.setData("/connor", "zengkai1".getBytes(), 0);

        Stat stat1 = zk.setData("/connor", "zengkai2".getBytes(), stat.getVersion());

        zk.setData("/connor", "zengkai3".getBytes(), stat1.getVersion());


        //zk.delete("/connor", 0);
        System.out.println();
    }

    private void process(WatchedEvent e) {

        System.out.println(e);

    }


}
