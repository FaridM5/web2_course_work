package az.edu.ada.librarySystem.controller;

import az.edu.ada.librarySystem.entity.Book;
import az.edu.ada.librarySystem.entity.myBook;
import az.edu.ada.librarySystem.service.BookService;
import az.edu.ada.librarySystem.service.myBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private myBookService myservice;

    @GetMapping("/")
    public String home(){
        return "homepage";
    }

    @GetMapping("/add")
    public String bookRegister(){
        return "add";
    }

    @GetMapping("/books")
    public ModelAndView listBooks(){
        List<Book>list=service.listBooks();
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("books");
//        mav.addObject("book", list);
        return new ModelAndView("books", "book", list);
    }

    @GetMapping("/mybooks")
    public String listmyBooks(Model model){
        List<myBook>list=myservice.listBooks();
        model.addAttribute("book", list);
        return "mybooks";
    }

    @GetMapping("/save")
    public String addBook(@ModelAttribute Book book){
        service.save(book);
        return "redirect:/books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        myBook mb = new myBook(b.getId(), b.getName(), b.getAuthor(), b.getLocation());
        myservice.saveMyBook(mb);
        service.deleteById(id);
        return "redirect:/mybooks";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBooks(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "edit";
    }
}