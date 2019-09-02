/**
 * 
 */
package com.springboot.demo.jackson.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.demo.jackson.domain.User;

/**
 * @author IGEN
 *
 */
public class Test {

    public static ObjectMapper mapper = new ObjectMapper();
    
    static {
        // 转化为格式化的json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // 如果json中有新增的字段并且是实体类中不存在的，不报错
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    @org.junit.Test
    public void testObj() throws JsonGenerationException, JsonMappingException, IOException {
        User user = new User(1, "Hello World", new Date());
        mapper.writeValue(new File("D:/test.txt"), user); // 写到文件中
        User userRead = mapper.readValue(new File("D:/test.txt"), User.class);
        System.out.println(userRead);
//        mapper.writeValue(System.out, user); //写到控制台
        
        String writeValueAsString = mapper.writeValueAsString(user);
        System.out.println("对象转换为字符串：" + writeValueAsString);
        
        byte[] writeValueAsBytes = mapper.writeValueAsBytes(user);
        for (byte b : writeValueAsBytes) {
            
            System.out.println(b);
        }
        System.out.println("对象转换为字节数组" + writeValueAsBytes);
        
        User readValue = mapper.readValue(writeValueAsString, User.class);
        System.out.println("字符串转化为对象：" + readValue);
        
        User readValue2 = mapper.readValue(writeValueAsBytes, User.class);
        System.out.println("数组转换为对象：" + readValue2);
    }
    
    @org.junit.Test
    public void testOther() throws IOException {
        // 修改时间格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        User user = new User(1, "Hello World", new Date());
        user.setIntList(Arrays.asList(1, 2, 3));

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println("对象转为字符串：" + jsonStr);
    }
    
    @SuppressWarnings("unchecked")
    @org.junit.Test
    public void testMap() {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("name", "merry");
        testMap.put("age", 30);
        testMap.put("date", new Date());
        testMap.put("user", new User(1, "Hello World", new Date()));

        try {
            String jsonStr = mapper.writeValueAsString(testMap);
            System.out.println("Map转为字符串：" + jsonStr);
            try {
                Map<String, Object> testMapDes = mapper.readValue(jsonStr, Map.class);
                System.out.println("字符串转Map：" + testMapDes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
    @org.junit.Test
    public void testList() throws JsonGenerationException, JsonMappingException, IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "aaa", new Date()));
        userList.add(new User(2, "bbb", new Date()));
        userList.add(new User(3, "ccc", new Date()));
        userList.add(new User(4, "ddd", new Date()));

        String jsonStr = mapper.writeValueAsString(userList);
        System.out.println("集合转为字符串：" + jsonStr);
        
        List<User> userListDes = mapper.readValue(jsonStr, List.class);
        System.out.println("字符串转集合：" + userListDes);
    }
}
