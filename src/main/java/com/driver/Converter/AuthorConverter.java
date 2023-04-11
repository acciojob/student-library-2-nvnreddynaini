package com.driver.Converter;

import com.driver.RequestDto.AuthorRequestDto;
import com.driver.models.Author;

public class AuthorConverter {

    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto){

        Author author = Author.builder().
                name(authorRequestDto.getName()).age(authorRequestDto.getAge()).country(authorRequestDto.getCountry())
                .email(authorRequestDto.getEmail()).build();

        return author;

    }

}
