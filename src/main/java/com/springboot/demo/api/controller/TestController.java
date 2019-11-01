package com.springboot.demo.api.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springboot.demo.api.abstractClass.AbstractTest1;
import com.springboot.demo.api.service.ITestService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.TestSpringInit;
import com.springboot.demo.api.config.ServerConfig;
import com.springboot.demo.api.domain.User;
import com.springboot.demo.api.exception.ApplicationException;
import com.springboot.demo.api.service.TestService;
import com.springboot.demo.api.tool.AuthToolException;

import sun.misc.BASE64Encoder;

@RestController
@RequestMapping("/test")
@Transactional(readOnly = true)
public class TestController {
    
    @Autowired
    TestSpringInit testSpringInit;
    public  List<Object> clazz = new ArrayList<Object>();

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    
    @Autowired
    private ITestService testService2;

    @GetMapping("/filter")
    public String testFilter() {
//        ThreadLocal local = new ThreadLocal();
        System.out.println(2/0);
        return ThreadContext.get("uuid");
    }

    @GetMapping("/{userId}/user")
    public User testUser(@PathVariable Integer userId, String languarge, @TestAnnotation String testId) {

        testService2.testService();

        User user = new User();
        user.setUserId(userId);
        testSpringInit.testMethod();
        
        System.out.println(TestController.class.getClassLoader());
        
        clazz.add(new TestController());
        for (Object object : clazz) {
            TestController test1= (TestController) object;
            System.out.println(test1.getClass().getClassLoader());
        }
        
        System.out.println(sqlSessionFactory);
//        Object object = AopContext.currentProxy();
//        System.out.println(object);
        testService2.testService();
        return user;
        //throw new NullPointerException("userId is null");
        //throw new ApplicationException(AuthToolException.AU_NO_OUT_OPERATION_PERMISSION);
        
//        User user = new User();
//        user.setUserId(userId);
//        return user;
        
    }
    
    @GetMapping("/file")
    public void testFile(HttpServletResponse response) throws IOException {
        String [] split = new String [] {"测试"};
                
        String str = new String(split[0].getBytes("UTF-8"),"ISO-8859-1");
//        str = new String(str.getBytes());
        str = new String(str.getBytes("ISO-8859-1"));
//        str = new String(str.getBytes("UTF-8"),"UTF-8");
        
        System.out.println(Charset.defaultCharset().name());
        String str1 = new String(str.getBytes("ISO-8859-1"),"UTF-8");
//        response.setCharacterEncoding("xxxx");
        response.setContentType("text/html;charset=UTF-8");
        
        response.getWriter().write(str);
    }
    
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response)
    {
        try {
//            URL url = new URL(request.getParameter("filePath"));
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(10 * 1000);
            File file = new File("C:/Users/IGEN/Desktop/igen/igen-document/参数模板-电表.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
//            InputStream inStream = file.getInputStream();
            byte[] data = readInputStream(inputStream);
//            String filename = request.getParameter("fileName");
            String filename = "新建文本文档 (2)";
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String agent = request.getHeader("User-Agent");
            String encodeFilename = "";
            if (agent.contains("MSIE")) {
                //IE
                encodeFilename = URLEncoder.encode(filename, "utf-8");
            } else if (agent.contains("Firefox")) {
                //火狐
                BASE64Encoder base64Encoder = new BASE64Encoder();
                encodeFilename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            } else {
                //其他
//                encodeFilename = URLEncoder.encode(filename, "utf-8");
                encodeFilename = new String(filename.getBytes("UTF8"),"ISO-8859-1");
            }
            response.setHeader("content-disposition", "attachment;filename=" + encodeFilename);

            OutputStream os = response.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
        } catch (Exception e) {
//            logger.error("下载文件异常：", e);
            e.printStackTrace();
        }
    }

    private  byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

}
