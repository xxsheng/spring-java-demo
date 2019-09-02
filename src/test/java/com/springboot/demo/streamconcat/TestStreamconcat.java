package com.springboot.demo.streamconcat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestStreamconcat {

    private static Stream<String> concat1(List<Collection<String>> collections){
        
        Stream result = Stream.empty();
        
        for (Collection<String> collection : collections) {
            Stream.concat(result, collection.stream());
        }
        
        return result;
    }
    
    private static Stream<String> concat2(List<Collection<String>> collections){
        return collections.stream().flatMap(Collection::stream);
    }
    
    private static Stream<String> concat3(List<String> s1,String[] s2, Set<String> s3) {

        return  Stream.of(s1.stream(), Arrays.stream(s2), s3.stream())

                   .flatMap(item -> item);

        }
}
