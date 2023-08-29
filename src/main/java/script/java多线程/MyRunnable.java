package script.java多线程;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "打了:" + i + "个小兵");
        }
    }

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();

        Thread t1 = new Thread(myRunnable, "A");
        Thread t2 = new Thread(myRunnable, "B");
        Thread t3 = new Thread(myRunnable, "C");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();


        //守护进程，如果其他线程都执行完毕，main 方法（主线程）也执行完毕，JVM 就会退出，也就是停止运行。
        // 如果 JVM 都停止运行了，守护线程自然也就停止了。
//        t1.setDaemon(true);
//        t2.setDaemon(true);
//        t1.start();
//        t2.start();
//        t3.start();

    }


}
