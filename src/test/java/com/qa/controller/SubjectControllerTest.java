package com.qa.controller;


import com.qa.controllers.SubjectsController;
import com.qa.models.Subject;
import org.junit.Test;
import com.qa.repository.subjectRepo;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubjectControllerTest {


    @InjectMocks
    private SubjectsController subjectsController;

    @Mock
    private subjectRepo subrepo;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    //
    @Test
    public void testGetAllNotes() {
        List<Subject> sublist = new ArrayList<>();
        Subject subject = new Subject();
        subject.setName("HTML");
        subject.setCategory("programming");
        sublist.add(subject);
        when(subrepo.findAll()).thenReturn(sublist);
        //when(repository.findAll()).thenReturn(sublist);
        assertEquals(subjectsController.listAllSubs().get(0).getName(), "HTML");

    }

    @Test
    public void testGetOneNote(){
        Subject subject = new Subject();
        subject.setName("HTML");
        subject.setCategory("programming");
        when(subrepo.findOne(1L)).thenReturn(subject);
        subjectsController.getSub(1L);
    }
    //
    @Test
    public void testDeleteNote() {
        Subject subject = new Subject();
        subject.setName("JAVA");
        when(subrepo.findOne(1L)).thenReturn(subject);
        subjectsController.getSub(1l);
    }
//
    @Test
    public void testAddNote(){
        Subject subject = new Subject();
        subject.setName("Java");
        subject.setCategory("Programming");
        when(subrepo.saveAndFlush(subject)).thenReturn(subject);
        subjectsController.addSub(subject);
    }
}
