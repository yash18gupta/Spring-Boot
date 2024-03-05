package com.example.minorproject1.dto;

import com.example.minorproject1.model.Author;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank // notNull + notEmpty
    private String name;

    @NotNull
    private Genre genre;

    private Integer pages;

    @NotBlank
    private String authorName;

    private String authorCountry;

    @NotBlank
    private String authorEmail;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .pages(this.pages)
                .author(Author.builder()
                                .name(this.authorName)
                                .email(this.authorEmail)
                                .country(this.authorCountry)
                                .build()
                                )
                .build();
    }
}
