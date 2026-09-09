package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

//        Runnable tsk = () -> System.out.println("Executed task");
            //submit method takes either a Runnable or callable. This above runnable is an FunctionalInterface so we can either create an implementation for this Runnable interface or since its a FunctionalInterface we can directly write the lambda function inside the below submit method.
//        executor.submit(tsk);
            executor.submit(() -> System.out.println("Executed task on " + Thread.currentThread().getName()));
        }

        System.out.println("Main execution on "+ Thread.currentThread().getName());
    }

}
