package com.jasekraft.bookclub.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jasekraft.bookclub.mvc.models.Book;
import com.jasekraft.bookclub.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(long id) {
    	bookRepository.deleteById(id);
    }
    
    public Book updateBook(Book book) {
    	Optional<Book> optionalBook = bookRepository.findById(book.getId());
    	if(optionalBook.isPresent()) {
    		bookRepository.save(book);
    		return book;
    	}
    	else {
    		return null;
    	}
    }
}
