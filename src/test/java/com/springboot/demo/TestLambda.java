package com.springboot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.junit.Test;

public class TestLambda {

    @Test
    public  void main1() {
        List<List<String>> ipQueryList = new ArrayList<List<String>>();
        List<String> list1 = Arrays.asList("0-test1","0-test2","0-test3");
        List<String> list2 = Arrays.asList("1-test1","1-test2","1-test3");
        ipQueryList.add(list1);
        ipQueryList.add(list2);
        
        Map<Integer, String> resultsList = ipQueryList .parallelStream().map(this::getMap).collect(new Collector<Map<Integer,String>, Map<Integer,String>, Map<Integer,String>>() {

            @Override
            public Supplier<Map<Integer, String>> supplier() {
                // TODO Auto-generated method stub
                return HashMap::new;
            }

            @Override
            public BiConsumer<Map<Integer, String>, Map<Integer, String>> accumulator() {
                // TODO Auto-generated method stub
                return (map,item) -> {
                    map.putAll(item);
                };
            }

            @Override
            public BinaryOperator<Map<Integer, String>> combiner() {
                // TODO Auto-generated method stub
                return (map1,map2) -> {
                    map1.putAll(map2);
                    
                    return map1;
                };
            }

            @Override
            public Function<Map<Integer, String>, Map<Integer, String>> finisher() {
                // TODO Auto-generated method stub
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                // TODO Auto-generated method stub
                return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
            }
            
        });

        System.out.println(resultsList);
    }
    
    private Map<Integer,String> getMap(List<String> params){
        System.out.println(params);
        Map<Integer, String> map = params.stream().collect(Collectors.toMap((p) -> params.indexOf(p)+p.hashCode(), (p) -> p));
        return map;
    }
    
    
    @Test
    public void testOptional() {
//        Optional<User> findFirst = list.stream().filter(item -> item.getId() == "2").findFirst();
//        System.out.println(findFirst.get().getName());
//        findFirst.get().setId("3");
        
        
        
        User user1 = new User();
        user1.setId("1");
        user1.setName("1");
        
        User user2 = new User();
        user2.setId("2");
        user2.setName("2");
        
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        
        User user = new User();
        user = list.get(1);
        user.setName("3");
        
        System.out.println(list);
    }
    
    @Test
    public void testLambdaOptional() {
        List<User> list = new ArrayList<User>();
        User user1 = new User("id1","name1");
        User user2 = new User("id2",null);
        User user3 = new User("id3","name3");
        User user4 = new User("id4","name4");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        
        Optional<User> findFirst = list.stream().filter(item -> item.getId() == "id2").findFirst();
        
        if(findFirst.isPresent()) {
            User user = findFirst.get();
            System.out.println(user);
        }
        
    }
}
