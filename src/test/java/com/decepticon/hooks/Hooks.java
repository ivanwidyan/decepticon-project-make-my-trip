package com.decepticon.hooks;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.lang.management.ManagementFactory;

public class Hooks {

    @AfterClass
    public void after() {
        System.out.println("Scenario2 Name: ");
        System.out.println("Scenario2 Status: ");
    }

    @BeforeClass
    public void before() {
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Started in thread2: " + threadId + ", in JVM: " + processName);
    }

    @After
    public void afterRun() {
        System.out.println("Scenario Name: ");
        System.out.println("Scenario Status: ");
    }

    @Before
    public void beforeRun() {
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
    }
}