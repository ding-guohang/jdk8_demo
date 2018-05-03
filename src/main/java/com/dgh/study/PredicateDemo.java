package com.dgh.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dingguohang on 2018/5/3
 */
public class PredicateDemo {

    private static void filter(List<String> list, Predicate<String> condition) {
        list.forEach((str) -> {
            if (condition.test(str)) {
                System.out.print(str);
            }
        });

        for (String str : list) {
            if (condition.test(str)) {
//                System.out.println(str);
            }
        }
        System.out.println();
    }

    public static void run() {
        List<String> languages = Arrays.asList("Java ", "Scala ", "C++ ", "Haskell ", "Lisp ");

        System.out.print("Languages which starts with J: ");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.print("Languages which ends with a: ");
        filter(languages, (str) -> str.endsWith("a "));

        System.out.print("Print all languages: ");
        filter(languages, (str) -> true);

        System.out.print("Print no language: ");
        filter(languages, (str) -> false);

        System.out.print("Print language whose length greater than 4: ");
        filter(languages, (str) -> str.trim().length() > 4);
    }
}
