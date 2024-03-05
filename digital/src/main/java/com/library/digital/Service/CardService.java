package com.library.digital.Service;

import com.library.digital.Entities.Card;
import com.library.digital.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    public CardRepository cardRepository;

    public List<Card> getAll(){
        return cardRepository.getAll();
    }

    public Optional<Card> getById(int id){
        return cardRepository.findById(id);
    }

    public void create(Card a){
         cardRepository.save(a);
    }

    public void update(Card a){
        cardRepository.save(a);
    }
    public void delete(int id){
        cardRepository.deleteById(id);
    }
}
