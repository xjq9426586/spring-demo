package com.example.demo;

import com.example.demo.amqp.Send;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
 
    @Autowired
    private Send helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}
