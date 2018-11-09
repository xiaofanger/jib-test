package com.fanger.jib.tools;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ToolsTest {

    public static void main(String[] args) {
//        Map<String, Object> map = new ConcurrentHashMap<>();
//        map.put()
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("f");
        System.out.println(list);
        list.forEach(l -> {
            System.out.println(list);
            list.forEach(i -> {
                if (l.equals(i)) {
                    list.remove(i);
                }
            });
        });
        System.out.println(list);
    }

}
