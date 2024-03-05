package com.library.digital.Repository;

import com.library.digital.Entities.Author;
import com.library.digital.Entities.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface CardRepository extends JpaRepository<Card,Integer> {

    @Query(value = "select c from Card c")
    public List<Card> getAll();
}
