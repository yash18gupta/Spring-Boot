package com.example.minorproject1.service;

import com.example.minorproject1.dto.BookFrontend;
import com.example.minorproject1.dto.CreateBookRequest;
import com.example.minorproject1.model.Author;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.model.enums.Genre;
import com.example.minorproject1.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Book createBook(CreateBookRequest createBookResponse) {

        Book book = createBookResponse.to();
        Author author = authorService.createOrGet(book.getAuthor());

        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.getAvailableBook();
    }

    @Transactional
    public Book deleteBookById(int bookId) throws Exception {
        Book book;

        try {
            book = bookRepository.findById(bookId).orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new Exception("Book not found!");
        }

        if(book.getStudent()==null){
            bookRepository.deleteById(bookId);
            return book;
        }
        else{
            throw new Exception("Book can't be deleted - Allocated to student");
        }
    }

    public List<Book> getAllAvailable(Optional<String> name, Optional<String> author, Optional<Genre> genre, Optional<Integer> minPages, Optional<Integer> maxPages) {
        return bookRepository.getAllAvailable(
                name.orElse(null),
                author.orElse(null),
                genre.orElse(null),
                minPages.orElse(0),
                maxPages.orElse(Integer.MAX_VALUE)
        );
    }

    public void assignBookToStudent(Book book, Student student){
        bookRepository.assignBookToStudent(book.getId(), student);
    }

    public void unassignBookFromStudent(Book book){
        bookRepository.unassignBook(book.getId());
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<BookFrontend> showBooks() {
        List<Book> availableBooks = bookRepository.getAvailableBook();


        Map<String,Integer> bookCountMap = new HashMap<>();
        Set<Book> uniqueBooks = new HashSet<>();

        for(Book b:availableBooks){
            String bookName = b.getName();
            bookCountMap.put(bookName,bookCountMap.getOrDefault(bookName, 0) + 1);
            uniqueBooks.add(b);
        }
        System.out.println(uniqueBooks.size());

        List<BookFrontend> responseList =  uniqueBooks.stream()
                .map(book -> BookFrontend.builder()
                        .name(book.getName())
                        .genre(book.getGenre())
                        .pages(book.getPages())
                        .authorName(book.getAuthor().getName())
                        .count(bookCountMap.getOrDefault(book.getName(),0))
                        .build())
                        .toList();

        return responseList;

    }
}
