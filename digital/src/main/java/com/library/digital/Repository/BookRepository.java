package com.library.digital.Repository;

import com.library.digital.Entities.Author;
import com.library.digital.Entities.Book;
import com.library.digital.Entities.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select b from Book b")
    List<Book> getAll();

    @Query("SELECT b FROM Book b " +
            "WHERE b.available = :available AND b.genre = :genre " +
            "AND (:author IS NULL OR b.author.name = :author)")
    List<Book> findAvailableByGenre(@Param("genre")Genre genre, @Param("available")boolean available,@Param("author") String author);

    @Query(value = "select b from Book b where b.available=true")
    List<Book> findAvailable(boolean available);
}
