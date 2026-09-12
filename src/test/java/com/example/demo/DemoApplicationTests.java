package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws InterruptedException, ExecutionException {
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

//        executorService.execute(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Email sent");
//        });
//
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("SMS sent");
//        });
//
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Whatsapp sent");
//        });
//
//        System.out.println("ALL notifications sent");


    //the problem with executor is it a fire and forger. And also since it take runnable and runnable returns only void so if there is any operation that might return something we cant use that and we cant know if the operation is done also if any errors and exceptions occurs the thread execution will be stopped.
        //so better use this for any background job or logging etc

        //so for resolving the issue of not knowing when the thread is executed and also to may be get the value of the execution we should use the method submit.
        //        executorService.submit(tsk); // this accept either Runnable or callable
        //and submit return the type of future.
        //future's get() method stops the main thread execution and wait till that future's thread(any thread that is calling future.get()) is completed . and also get() method can also return a value which we can use
        //also for submit if any error or exception happens it boil to the main method that calls but the thread doesn't stop execution

        Future<Integer> exec1 = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("FD balance");
            return 300;
        });

        Future<Integer> exec2 = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Current balance");
            return 3400;
        });

        Future<Integer> exec3 = executorService.submit(() -> {
            Thread.sleep(2000);
            System.out.println("Savings balance");
            return 7000;
        });

        System.out.println("Total: "+ (exec1.get() + exec2.get() + exec3.get()));


        executorService.shutdown(); // this is also needed to tell JVM that no need for threads to wait for any other methods

//        executorService.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);


        //Notes for shutdown vs shutdown : Refer the NOTION notes
    }

}
