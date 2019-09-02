package com.springboot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

public class TestMapList {

    @Test
    public  void main() {
        Map<Integer,Set<Long>> map = new HashMap<Integer, Set<Long>>();
        
        HashSet<Long> list = new HashSet<Long>();
        System.out.println(list.add(1L));
        boolean result = list.add(1L);
        System.out.println(result);
        list.add(2L);
        
        map.put(0, list);
        
        if(map.containsKey(0)) {
            
            map.get(0).addAll(Arrays.asList(3L,4L));
        }else {
          //  map.put(0, Arrays.asList(3L,4L));
        }
        
        HashSet<Long> set1 = new HashSet<Long>();
        set1.add(1L);
        set1.add(2L);
        set1.add(6L);
        
        HashSet<Long> set2 = new HashSet<Long>();
        set2.add(7L);
        
        HashSet<Long> set3 = new HashSet<Long>();
        set3.add(8L);
        
        HashSet<Long> set4 = new HashSet<Long>();
        set4.add(9L);
        
        HashSet<Long> set5 = new HashSet<Long>();
        set5.add(10L);
        
        map.put(1, set1);
        map.put(2, set2);
        map.put(3, set4);
        map.put(4, set5);
        
        System.out.println(Runtime.getRuntime().availableProcessors());
        
//        Set<Long> reduce = map.values().parallelStream().map(this::test).reduce(new HashSet<Long>(), (l,item) -> {
//            l.addAll(item);
//            return l;
//        });
          map.values().parallelStream().map(this::test).findAny();
        
        
        //System.out.println(reduce);
    }
    
    private Set<Long> test(Set<Long> list) {
        try {
            Thread.sleep(3 * 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread id = "+Thread.currentThread().getId());
        System.out.println(list);
        return list;
    }
    
    @Test
    public void testArr() {
        
        int arr [] = new int[5];
        System.out.println(arr.length);
        System.out.println(Math.E);
        
    }
    
    @Test
    public void testMap() {

        //System.out.println(squaresList);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
//        Integer aa = 0;
        for(int i = 0;i<100;i++){
            a.add(i);
            b.add(i);
        }
        long startTime=System.currentTimeMillis();
        for (int i = 0;i<a.size();i++){
              a.set(i,i+1);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
        System.out.println("::"+a.get(0));
    
        
        long startTime2=System.currentTimeMillis();
//         b = b.stream().map( i -> i+1).collect(Collectors.toList());
         b.parallelStream().forEach(i -> {
             b.set(i, i+1);
         });
        long endTime2=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime2 - startTime2)+"ms");
        System.out.println("::"+b.get(0));

        
    }
}
