package com.example.demo.bookService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.IsbnConstraintViolationException;
import com.example.demo.bookEntity.BookEntity;
import com.example.demo.bookRepositroy.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	Pattern pattern = Pattern.compile("\\b[A-Z]{3}\\b-\\b[0-9]{3}\\b");

	public List<BookEntity> createBookList()

	{

		return bookRepository.findAll();

	}

	public BookEntity saveBook(BookEntity book) {

		Matcher matcher = pattern.matcher(book.getIsbn());
		if (matcher.find()) {
			return bookRepository.save(book);
		} else {
			throw new IsbnConstraintViolationException("Isbn is not a valid pattern");
		}

	}

	public BookEntity getBookId(Integer id) {

		return bookRepository.findById(id).get();

	}

	public void delete(Integer id) {

		bookRepository.deleteById(id);

	}

}
