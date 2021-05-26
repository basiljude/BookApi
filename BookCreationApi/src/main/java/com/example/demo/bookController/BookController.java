package com.example.demo.bookController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bookEntity.BookEntity;
import com.example.demo.bookService.BookService;


@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/findallBooks")
	public List<BookEntity> Booklist() {

		return bookService.createBookList();
	}

	@PostMapping("/saveProduct")
	public BookEntity posting(@RequestBody BookEntity book) {


		return bookService.saveBook(book);

	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookEntity> getBookId(@PathVariable Integer id) {

		try {
			BookEntity book = bookService.getBookId(id);
			return new ResponseEntity<BookEntity>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			return new ResponseEntity<BookEntity>(HttpStatus.NOT_FOUND);

		}
	}
	
	
	@DeleteMapping("/BookDelete/{id}")

	public void delete(@PathVariable Integer id) {

		bookService.delete(id);

	}
	
	

	@PutMapping("/putmapping/{id}")
	public ResponseEntity<BookEntity> putBook(@RequestBody BookEntity book, @PathVariable Integer id) {

		try {
			BookEntity produc1t = bookService.getBookId(id);
			bookService.saveBook(book);
			return new ResponseEntity<BookEntity>(book, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			// TODO: handle exception

			return new ResponseEntity<BookEntity>(HttpStatus.NOT_FOUND);

		}

	}
	
	

}
