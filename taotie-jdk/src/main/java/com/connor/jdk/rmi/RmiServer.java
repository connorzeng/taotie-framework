package com.connor.jdk.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {

    /**
     * RMI对服务器的IP地址和端口依赖很紧密，
     * 但是在开发的时候不知道将来的服务器IP和端口如何，
     * 但是客户端程序依赖这个IP和端口。这也是RMI的局限性之一。
     * <p>
     * RMI不能动态的发现服务
     *
     * @param args
     * @throws RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        System.out.println("create World clock remote service...");
        // 实例化一个WorldClock:
        WorldClock worldClock = new WorldClockService();
        // 将此服务转换为远程服务接口:
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);
        // 将RMI服务注册到1099端口:
        Registry registry = LocateRegistry.createRegistry(1099);
        // 注册此服务，服务名为"WorldClock":
        registry.rebind("WorldClock", skeleton);
    }



}
