package com.example.demo.java.utils.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample3 {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.acquireUninterruptibly();
                    // semaphore.acquire();
                     TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println("T1 finished.");
            }
        };

        t1.start();

        TimeUnit.MILLISECONDS.sleep(50);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println("T2 finished");
            }
        };

        t2.start();

        TimeUnit.MILLISECONDS.sleep(50);

        t1.interrupt();
    }
}
