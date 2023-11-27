package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class StreamA {
    public static void main(String[] args) {

        // iterator 객체 이용 방식 (자바 6 이전)
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String value = iterator.next();
            if ("a".equals(value)) { // StringUtils.equals(value, "a")
                System.out.println("값 : " + value);
            }
        }

        // for-each 방식
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        for (String value : list2) {
            if ("b".equals(value)) {
                System.out.println("값 : " + value);
            }
        }

        // stream 방식
        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        list3.stream()
                .filter("c"::equals)
                .forEach(System.out::println);
    }
}
