package com.library.digital.Controller;

import com.library.digital.Entities.Author;
import com.library.digital.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    public AuthorService authorService;

    @GetMapping("/getAll")
    public List<Author> getAll(){
        return authorService.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Optional<Author> a = authorService.getById(id);
        return new ResponseEntity(a.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Author a){
        authorService.create(a);
        return new ResponseEntity("Author Created", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Author a){
        authorService.update(a);
        return new ResponseEntity("Author Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        authorService.delete(id);
        return new ResponseEntity("Author Deleted", HttpStatus.OK);
    }

}
