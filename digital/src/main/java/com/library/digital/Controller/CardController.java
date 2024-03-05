package com.library.digital.Controller;

import com.library.digital.Entities.Card;
import com.library.digital.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    public CardService cardService;

    @GetMapping("/getAll")
    public List<Card> getAll(){
        return cardService.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Optional<Card> a = cardService.getById(id);
        return new ResponseEntity(a.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Card a){
        cardService.create(a);
        return new ResponseEntity("Card Created", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Card a){
        cardService.update(a);
        return new ResponseEntity("Card Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        cardService.delete(id);
        return new ResponseEntity("Card Deleted", HttpStatus.OK);
    }

}
