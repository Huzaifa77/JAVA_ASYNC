package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        Runnable tsk = () -> System.out.println("Executed task");
            //execute method takes either only Runnable . This above runnable is an FunctionalInterface so we can either create an implementation for this Runnable interface or since its a FunctionalInterface we can directly write the lambda function inside the below submit method.

//        executorService.execute(() -> System.out.println("Executed task on 1 " + Thread.currentThread().getName()));
//        executorService.execute(() -> System.out.println("Executed task on 2 " + Thread.currentThread().getName()));
//        executorService.execute(() -> System.out.println("Executed task on 3 " + Thread.currentThread().getName()));
//        executorService.execute(() -> System.out.println("Executed task on 4 " + Thread.currentThread().getName()));
//
//
//        System.out.println("Main execution on "+ Thread.currentThread().getName());

        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Email sent");
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("SMS sent");
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Whatsapp sent");
        });

        System.out.println("ALL notifications sent");

        //        executorService.submit(tsk); // this accept either Runnable or callable

    //the problem with executor is it a fire and forger. And also since it take runnable and runnable returns only void so if there is any operation that might return something we cant use that and we cant know if the operation is done. Also if any errors and exceptions occurs the thread execution will be stopeed.
        //so better use this for any background job or logging etc
        executorService.shutdown();

        executorService.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);

    }

}
