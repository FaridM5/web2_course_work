package az.edu.ada.librarySystem.service;

import az.edu.ada.librarySystem.entity.Book;
import az.edu.ada.librarySystem.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import az.edu.ada.librarySystem.entity.myBook;

import java.util.List;


@Service
public class myBookService {

    private final MyBookRepository mybookrepo;

    // Constructor injection
    @Autowired
    public myBookService(MyBookRepository mybookrepo) {
        this.mybookrepo = mybookrepo;
    }
    public void saveMyBook(myBook book){
        mybookrepo.save(book);
    }
    public List<myBook> listBooks(){
        return mybookrepo.findAll();
    }
    //
//    public Book getBookById(int id){
//        return mybookrepo.findById(id).get();
//    }
    public void deleteBook(int id){
        mybookrepo.deleteById(id);
    }

    public myBook getBookById(int id){
        return mybookrepo.findById(id).get();
    }

}