/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class BookX implements Serializable {
    private static final long serialVersionUID = 20241124L;
    
    private String id, title, author;
    private int yearPublished;
    private String genre, code;

    public BookX() {
        
    }
    
    public BookX(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + ", genre=" + genre + '}';
    }
    
    
    
}
