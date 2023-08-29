package script.java多线程;

import java.util.concurrent.*;

public class Callable与Runnable {

    public static void main(String[] args) {

    }

}

class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello from " + Thread.currentThread().getName();
            }
        };

        Future[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(task);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(futures[i].get());
        }

        executorService.shutdown();

    }
}

class RunnableDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();

    }
}

class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 创建一系列 Callable
        Callable<Integer>[] tasks = new Callable[5];
        for (int i = 0; i < tasks.length; i++) {
            final int index = i;
            tasks[i] = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    TimeUnit.SECONDS.sleep(index + 1);
                    return (index + 1) * 100;
                }
            };
        }

        // 将 Callable 包装为 FutureTask，并提交到线程池
        FutureTask<Integer>[] futureTask = new FutureTask[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            futureTask[i] = new FutureTask<>(tasks[i]);
            executorService.submit(futureTask[i]);
        }

        // 获取任务结果
        for (int i = 0; i < futureTask.length; i++) {
            System.out.println("Result of task" + (i + 1) + ": " + futureTask[i].get());
        }

        executorService.shutdown();
    }

}



