package com.springboot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestHashMap {

    
    @Test
    public void testkeynull() {
        
        User user1 = new User("1", "1");
        User user2 = new User("2", "2");
        User user3 = new User("3", "3name");
        
        
        
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        StringBuilder sql = new StringBuilder();
        String sql1;
        users.stream().forEach(item -> {
            String sql2 = null;
            sql2 = item.getId() == null?  sql.append("a").toString(): sql.append("B").toString();
//            sql1 = sql2;
        });
//        Map<String, String> collect = users.stream().collect(Collectors.toMap(User::getId, User::getName,(a,b) -> b));
        users.stream().forEach(item -> {
            if(item.getId() == null) {
                sql.append("d");
            }
        });
        
        Stream<Class> stream = Stream.of(User.class);
        Map<Object, List<Class>> collect = stream.collect(Collectors.groupingBy(Class::getSuperclass));
        System.out.println(collect);
        
    }
    
    @SuppressWarnings("rawtypes")
    @Test
    public void test2() {
        Stream<Class> stream = Stream.of(ArrayList.class);
        Map<Class, List<Class>> collect = stream.collect(Collectors.groupingBy(Class::getSuperclass));
        System.out.println(collect);
    }
    
    @Test
    public void test3() {
        System.out.println(List.class.getSuperclass());
        String[] strs = { "aaa", "bbb", "ccc" };
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);// Ljava.lang.String;@53d8d10a
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::println);// aaabbbccc
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);// aaabbbccc
    }
    @Test
    public void test4() {
        List<Integer> numbers = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        Integer aa = 0;
        for (Integer i : numbers) {
            aa += i;
        }
        Integer dd = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a - b);
        Optional<Integer> dd1 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(aa);
        System.out.println(dd);
        System.out.println(dd1.get());
    }
    // 三个参数
    @Test
    public void testReduce3() {
        // 串行操作
        List<Integer> list = Arrays.asList(3, 2, 4, 1);
        System.out.println(list.stream().reduce(100
                , (acc, tmp) -> acc - tmp
                , (a, b) -> a + b).intValue());  // out ==> 110

        // 并行操作
        System.out.println(list.stream().parallel().reduce(100
                , (acc, tmp) -> acc + tmp
                , (a, b) -> a + b).intValue());  // out ==> 410
       
    }
}
