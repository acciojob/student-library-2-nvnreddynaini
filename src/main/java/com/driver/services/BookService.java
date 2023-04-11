package com.driver.services;

import com.driver.Converter.BookConverter;
import com.driver.RequestDto.BookRequestDto;
import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository1;

    @Autowired
    BookRepository bookRepository2;

    public void createBook(BookRequestDto bookRequestDto){

        Book book = BookConverter.convertDtoToEntity(bookRequestDto);

        int authorId = bookRequestDto.getAuthorId();

        Author author = authorRepository1.findById(authorId).get();

        book.setAuthor(author);

        List<Book> currentListOfBooks = author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);

        //Save the Author
        authorRepository1.save(author);

    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books;
        //find the elements of the list by yourself
        if(genre != null && author != null){
            books = bookRepository2.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            books = bookRepository2.findBooksByGenre(genre, available);
        }else if(author != null){
            books = bookRepository2.findBooksByAuthor(author,available);
        }else{
            books = bookRepository2.findByAvailability(available);
        }
        if(books == null){
            books = new ArrayList<>();
        }
        return books;
    }
}
