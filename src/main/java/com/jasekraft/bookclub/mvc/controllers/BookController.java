package com.jasekraft.bookclub.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasekraft.bookclub.mvc.models.Book;
import com.jasekraft.bookclub.mvc.services.BookService;
import com.jasekraft.bookclub.mvc.services.UserServ;

@Controller
public class BookController {

	private final BookService bookService;
	private final UserServ userServ;
	
	public BookController(BookService bookService, UserServ userServ) {
		this.bookService = bookService;
		this.userServ = userServ;
	}
	
	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable("id") long id,
			Model model, HttpSession session) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
    	Long user_id = (long) session.getAttribute("user_id");
		model.addAttribute("user", userServ.getUserById(user_id));
		return "books/showBook.jsp";
	}
	
	@RequestMapping("/books")
	public String showAllBooks(Model model, HttpSession session) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		Long user_id = (long) session.getAttribute("user_id");
		model.addAttribute("user", userServ.getUserById(user_id));
		return "books/showAll.jsp";
	}
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Long user_id = (long) session.getAttribute("user_id");
		model.addAttribute("user", userServ.getUserById(user_id));
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/{id}/edit")
    public String update(@ModelAttribute("book") Book book, Model model, HttpSession session, @PathVariable("id") long id) {
		model.addAttribute("oldbook", userServ.getUserById(id));
       return "books/edit.jsp";
    }
    
    @RequestMapping(value="/books/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		Long id = book.getId();
    		return String.format("books/%s/edit", id);
    	} else {
    		bookService.updateBook(book);
    		return "redirect:/books";
    	}
    }
}
