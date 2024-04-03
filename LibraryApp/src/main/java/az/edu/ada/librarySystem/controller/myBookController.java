package az.edu.ada.librarySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import az.edu.ada.librarySystem.service.myBookService;
import az.edu.ada.librarySystem.service.BookService;
import az.edu.ada.librarySystem.entity.Book;
import az.edu.ada.librarySystem.entity.myBook;

@Controller
public class myBookController {

    @Autowired
    private BookService bookservice;

    @Autowired
    private myBookService service;
    @RequestMapping("/deletemyBook/{id}")
    public String deletemyBook(@PathVariable("id") int id){
        myBook b = service.getBookById(id);
        Book mb = new Book(b.getId(), b.getName(), b.getAuthor(), b.getLocation());
        bookservice.save(mb);
        service.deleteBook(id);
        return "redirect:/mybooks";
    }
}