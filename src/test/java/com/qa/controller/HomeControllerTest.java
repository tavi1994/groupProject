package com.qa.controller;
import com.qa.controllers.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @InjectMocks
    //For the field that we declare; this is the class that we are going to be testing.
    // If it has any dependencies that reqiure an instance; those dependies will be automatically injected.
    private HomeController homeController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHomePage(){
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/",String.class)).contains("Hello World");

    }



}
