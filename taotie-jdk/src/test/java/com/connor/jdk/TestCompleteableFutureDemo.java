package com.connor.jdk;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCompleteableFutureDemo {

    @Test
    public void testSimpleCompletableFuture() {
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Hello mghio");
        assertTrue(completableFuture.isDone());
        try {
            assertEquals("Hello mghio", completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCompletableFutureRunAsync() {
        AtomicInteger variable = new AtomicInteger(0);
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> process(variable));
        runAsync.join();
        assertEquals(100, variable.get());
    }

    public void process(AtomicInteger variable) {
        System.out.println(Thread.currentThread() + " Process...");
        variable.set(100);
    }


    @Test
    public void testCompletableFutureSupplyAsync() {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(this::process);
        try {
            assertEquals("Hello mghio", supplyAsync.get()); // Blocking
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String process() {
        return "Hello mghio";
    }
}
