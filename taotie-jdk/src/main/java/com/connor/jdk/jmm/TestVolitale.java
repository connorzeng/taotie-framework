package com.connor.jdk.jmm;

public class TestVolitale {

    //    private static int STATE = 1;
    private static volatile int STATE = 1;
    private static Object STATE_O = null;

    static int x = 0, y = 0;
    static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {

        //testVolatile();
        testVolatile();
        //testRecord();



    }

    private static void testRecord() throws InterruptedException {
        int i = 0;
        while (true) {
            int i1 = testReorder(i);
            if (i1 == 0){
                break;
            }
            i++;
        }
    }

    private static int testReorder(int i) throws InterruptedException {

        x = 0;
        y = 0;
        a = 0;
        b = 0;

        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        // 如果出现了重排序, 就会出现x==0 y==0
        if (x == 0 && y == 0) {
            System.out.println(i);
            System.out.println("(" + x + "," + y + ")");
            return 0;
        }
        return  1;
    }


    private static void testVolatile() {

        Thread a = new Thread(() -> {

            System.out.println(" 等待STATE变更 ");

            // 如果STATE不加voliate,该线程永远无法感知变化
            while (STATE == 1) {

            }

            System.out.println(" STATE change,now state value: " + STATE);
        });
        a.start();

        Thread b = new Thread(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" OK,我要变更STATE状态了 ");
            changeState();
        });
        b.start();
    }

    private static void changeState() {
        STATE = 2;
    }


    // 要使用volitale关键字是因为要达到一个线程的可见性.
    // 不使用volitale,在check two的步骤无法感知TestVolitale已经被创建.
    private volatile TestVolitale testVolitale = null;

    /**
     * DCL
     */
    public TestVolitale getSingleton() {

        int i = 0;
        i++;
        // check one
        if (testVolitale == null) {
            synchronized (TestVolitale.class) {
                // check two
                // 两次检查,因为在锁等待的时候,其他线程已经在这之前已经将单例bean实例化了.
                // 所以要在进行一次判断
                if (testVolitale == null) {
                    testVolitale = new TestVolitale();
                }
            }
        }
        return testVolitale;
    }


}
