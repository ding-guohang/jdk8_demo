package com.dgh.study;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dingguohang on 2018/5/12
 */
public class EnumDemo {


    public static void main(String[] args) {
        Set<EnumBean> set = new HashSet<>();
        set.add(EnumBean.FIRST);
        set.add(EnumBean.LAST);


        for (int i = 0; i < 100; i ++) {
            if (set.contains(i)) {
                System.out.println("contains " + i);
            }
        }
    }

    enum EnumBean {
        FIRST,
        SECOND,
        LAST;
    }
}
