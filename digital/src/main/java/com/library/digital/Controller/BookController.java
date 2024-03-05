package com.library.digital.Controller;

import com.library.digital.Entities.Author;
import com.library.digital.Entities.Book;
import com.library.digital.Entities.Genre;
import com.library.digital.Service.AuthorService;
import com.library.digital.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    public BookService bookService;

    @Autowired
    public AuthorService authorService;

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Optional<Book> a = bookService.getById(id);
        return new ResponseEntity(a.get(), HttpStatus.OK);
    }

    @GetMapping("/get/available")
    public ResponseEntity getAllAvailable(@RequestParam(value="genre", required=false) Genre genre,
                                          @RequestParam(value="available", required=false,defaultValue="false") boolean available,
                                          @RequestParam(value = "author",required=false)String author){

        List<Book> bookList = bookService.getAllAvailable(genre, available,author);
        return new ResponseEntity(bookList, HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Book a){
        bookService.create(a);
        return new ResponseEntity("Book Created", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Book a){
        bookService.update(a);
        return new ResponseEntity("Book Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        bookService.delete(id);
        return new ResponseEntity("Book Deleted", HttpStatus.OK);
    }

}
