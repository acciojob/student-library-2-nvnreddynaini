package com.driver.services;

import com.driver.Converter.AuthorConverter;
import com.driver.RequestDto.AuthorRequestDto;
import com.driver.models.Author;
import com.driver.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository1;

    public void create(AuthorRequestDto authorRequestDto){

        try{
            Author author = AuthorConverter.convertDtoToEntity(authorRequestDto);
            authorRepository1.save(author);
        }catch (Exception e){
            log.info("createAuthor has caused an error");
        }

    }

}
