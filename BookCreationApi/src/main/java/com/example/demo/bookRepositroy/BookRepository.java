package com.example.demo.bookRepositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bookEntity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
