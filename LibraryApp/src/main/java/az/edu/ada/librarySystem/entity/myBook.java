package az.edu.ada.librarySystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myBook")
public class myBook {

    @Id
    private int id;
    private String name;
    private String author;
    private String location;

    public myBook(int id, String name, String author, String location) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.location = location;
    }
    public myBook(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
