/**
 * 
 */
package com.springboot.demo.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author IGEN
 *
 */

//map：map方法返回的是一个object，map将流中的当前元素替换为此返回值；
//flatMap：flatMap方法返回的是一个stream，flatMap将流中的当前元素替换为此返回流拆解的流元素；
public class Map_FlatMap {

    List<String[]> eggs = new ArrayList<>();
    
    @Before
    public void init() {
        eggs.add(new String[] {"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        eggs.add(new String[] {"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});
        
    }
    
    // 自增生成组编号
    static int group = 1;
    static int student = 1;
    
    /**
     * 把俩箱鸡蛋分别加工成煎蛋，还是放在原来的俩箱，分给俩组学生
     * */
    @Test
    public void map() {
        eggs.stream().map(item -> Arrays.stream(item).map(y -> y.replace("鸡", "煎"))).forEach(item -> System.out.println("组" + group++ + ":" + Arrays.toString(item.toArray())));
    } 
    
    @Test
    public void flatMap() {
        eggs.stream().flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎"))).forEach(x -> System.out.println("学生" + student++ + ":" + x));
    }
}
