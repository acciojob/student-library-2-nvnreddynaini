package com.driver.Converter;

import com.driver.RequestDto.BookRequestDto;
import com.driver.models.Book;

public class BookConverter {

    public static Book convertDtoToEntity(BookRequestDto bookRequestDto){

        Book book = Book.builder().
                name(bookRequestDto.getName()).genre(bookRequestDto.getGenre())
                .available(bookRequestDto.isAvailable()).build();

        return book;

    }

}
