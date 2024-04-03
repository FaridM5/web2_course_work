package az.edu.ada.librarySystem.service;

import az.edu.ada.librarySystem.entity.Book;
import az.edu.ada.librarySystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    private final BookRepository bookRepository;

    // Constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book){
        bookRepository.save(book);
    }




    //    @Autowired
//    private BookRepository bookRepository;
//    public void save(Book book){
//        bookRepository.save(book);
//    }
    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void deleteById(int id){
        bookRepository.deleteById(id);
    }
}

