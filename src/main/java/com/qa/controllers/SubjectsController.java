package com.qa.controllers;

import com.qa.models.Note;
import com.qa.models.Subject;
import com.qa.repository.subjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//CORS
@CrossOrigin()
public class SubjectsController {


    @Autowired
    private subjectRepo subrepo;

    @RequestMapping(value = "subject", method = RequestMethod.GET)
    public List<Subject> listAllSubs(){
        return subrepo.findAll();
    }

    @RequestMapping(value="newSubject", method=RequestMethod.POST)
    //Request Body means we are gonna get the object as a response which we can then store within the DB
    public Subject addSub(@RequestBody Subject sub) {
        return subrepo.saveAndFlush(sub);
    }


    @RequestMapping(value="subject/{id}", method=RequestMethod.GET)
    public Subject getSub(@PathVariable Long id){
        return subrepo.findOne(id);
    }

    @RequestMapping(value="subject/{id}", method=RequestMethod.DELETE)
    public Subject deleteSubject(@PathVariable Long id){
        Subject existing = subrepo.findOne(id);
        subrepo.delete(existing);
        return existing;
    }


}
