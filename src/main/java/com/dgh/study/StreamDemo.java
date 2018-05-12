package com.dgh.study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dingguohang on 2018/5/12
 */
public class StreamDemo {


    private static List<StreamElement> list = new ArrayList<>();
    private static StreamElement e1 = new StreamElement(0, "0s");
    private static StreamElement e2 = new StreamElement(1, "1s");


    static {
        list.add(e1);
        list.add(e2);
    }


    public static void main(String[] args) {
        List<StreamElement> a = list.stream()
                .filter((e) -> e.code > 0)
                .peek((e) -> e.str = "update")
                .collect(Collectors.toList());

        a.forEach((e) -> System.out.println(e.toString()));

        System.out.println(" ************ ");

        list.forEach((e) -> System.out.println(e.toString()));

        System.out.println(" ************ ");

        System.out.println(e1.toString());
        System.out.println(e2.toString());
    }


    static class StreamElement {
        private int code;
        private String str;

        public StreamElement(int code, String str) {
            this.code = code;
            this.str = str;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return "StreamElement{" +
                    "code=" + code +
                    ", str='" + str + '\'' +
                    '}';
        }
    }
}
