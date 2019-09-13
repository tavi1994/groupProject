package com.qa.controllers;


import com.qa.models.Note;
import com.qa.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//CORS
@CrossOrigin()
public class NotesController {

    @Autowired
    private NotesRepository repo;

    @RequestMapping(value = "trainer", method = RequestMethod.GET)
        public List<Note> listAllNotes(){
        return repo.findAll();
        }

    @RequestMapping(value="notes", method=RequestMethod.POST)
        //Request Body means we are gonna get the object as a response which we can then store within the DB
        public Note addNote(@RequestBody Note note) {
            return repo.saveAndFlush(note);
    }


    @RequestMapping(value="trainer/{id}", method=RequestMethod.GET)
    public Note getNotes(@PathVariable Long id){
            return repo.findOne(id);
    }

    @RequestMapping(value="trainer/{id}", method=RequestMethod.DELETE)
    public Note deleteNote(@PathVariable Long id){
        Note existing = repo.findOne(id);
        repo.delete(existing);
        return existing;
    }
}
