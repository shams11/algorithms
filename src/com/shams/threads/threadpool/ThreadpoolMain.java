package com.shams.threads.threadpool;

public class ThreadpoolMain {

    public static void main(String[] args) throws InterruptedException {
        int threadpoolThreads = 3;
        Threadpool tp = new Threadpool(threadpoolThreads, 10);
        for (int i = 0; i < threadpoolThreads; i++) {
            int taskNo = i;
            tp.execute(() -> {
                String message = Thread.currentThread().getName()
                        + ": Task " + taskNo;
                System.out.println(message);
            });
        }
        tp.waitUntilAllThreadsFinish();
        tp.stop();
    }
}
