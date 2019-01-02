package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.PageBean;
import com.example.demo.bean.PageParam;
import com.example.demo.bean.User;
import com.example.demo.dao.UserRepository;
import com.example.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests  {
 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "ab@126.com", "bb", "ab123456",formattedDate));
        userRepository.save(new User("cc3", "ac@126.com", "cc", "ac123456",formattedDate));
 
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
    @Test
    public void test1() {
    	PageBean pb = new PageBean();
    	pb.setCurPage(1);
    	pb.setPageSize(2);
    	PageBean page = userService.getUsersPage(pb, "a");
    	System.out.println(JSONObject.toJSON(page));
    }
    @Test
    public void test2() {
    	System.out.println(JSONObject.toJSON(userService.getUser()));
    }
}
