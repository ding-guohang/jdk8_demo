package com.dgh.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dingguohang on 2018/5/3
 */
public class PredicateDemo {

    private static void filter(List<String> list, Predicate<String> condition) {
        list.stream().filter(condition).forEach(System.out::print);
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



    public static void multiPredicatesRun() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("Languages, which starts with 'J' and four letter long is : " + n));
    }
}
