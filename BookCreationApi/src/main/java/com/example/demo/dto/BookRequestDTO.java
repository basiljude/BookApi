package com.example.demo.dto;

import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

public class BookRequestDTO {

	private String name;

	private String description;
	private String author;
	private String price;

	@Pattern(regexp = "[A-Z]{3}-[1-9]{3}", message = "isbn should follow this pattern: XXX-123")
	@NonNull
	private String isbn;
	private String classification;

	public BookRequestDTO(String name, String description, String author, String price, String isbn,
			String classification) {
		super();
		this.name = name;
		this.description = description;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.classification = classification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
