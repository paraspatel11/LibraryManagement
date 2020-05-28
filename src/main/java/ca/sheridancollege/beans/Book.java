package ca.sheridancollege.beans;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue
	private int bookId;
	
	private String bookName;
	private String author;
	private String genre;
	
	private String location;
	
	@Transient //This doesn't store the field and dees not show up.
	private String[] genreList = {"Horror","Comedy","Action","Art","Sci-Fi","Romantic"};

	@Transient //This doesn't store the field and dees not show up.
	private String search;
	
	public Book(String bookName, String author, String genre, String location) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.location = location;
	}
	
}

