package com.dgh.study;

import java.util.Arrays;
import java.util.List;

/**
 * for lambda
 *
 * @author dingguohang on 2018/5/3
 */
public class Lambda {

    private static void doThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        // 用 "() -> {}" 代替了整个匿名类
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks")).start();
    }


    private static void doImplements(int a, int b) {
        RunnableDemo runnableDemo = new RunnableDemo();

        runnableDemo.run(new InterfaceDemo() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        }, a, b);


        runnableDemo.run((add1, add2) -> {
            System.out.print("lambda add demo: ");
            return add1 + add2;
        }, a, b);
    }


    private static void forEach() {
        List<String> features = Arrays.asList("Lambdas  ", "Default Method  ", "Stream API  ", "Date and Time API\n");

        System.out.print("Before Java8: ");
        for (String feature : features) {
            System.out.print(feature);
        }

        System.out.print("In Java8: ");
        features.forEach((param) -> System.out.print(param));

        System.out.print("In Java8 With 引用: ");
        features.forEach(System.out::print);
    }


    public static void main(String[] args) {
        doThread();
        doImplements(10, 12);
        forEach();
        PredicateDemo.run();
    }
}
