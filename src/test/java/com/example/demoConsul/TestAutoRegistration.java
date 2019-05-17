package com.example.demoConsul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoConsulApplication.class)
public class TestAutoRegistration {

    @Autowired
    DiscoveryClient client;

    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp(){
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void testConsulAgentIsRunning(){
        ResponseEntity<String> getResult = testRestTemplate.exchange("http://localhost:8500",
                HttpMethod.GET, HttpEntity.EMPTY, String.class);

        Assert.assertEquals(getResult.getStatusCode(), HttpStatus.MOVED_PERMANENTLY);
    }


}
