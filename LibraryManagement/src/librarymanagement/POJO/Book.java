/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.POJO;

/**
 *
 * @author Sumaiya
 */
public class Book {

    private int id;           // ID given by a library to a book to make it distinguishable from other books
    private String title;    // Title of a book 
    private int quantity;

    private String isbn;
    private String subject;       // Subject to which a book is related!
    private String author;        // Author of book!
    private String publisher;       //name of publications
    private String isIssued;        // this will be true if the book is currently issued to some borrower.

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(String title, int quantity, String isbn, String subject, String author, String publisher, String isIssued) {
        this.title = title;
        this.quantity = quantity;
        this.isbn = isbn;
        this.subject = subject;
        this.author = author;
        this.publisher = publisher;
        this.isIssued = isIssued;
    }

    public Book(int id, String title, int quantity, String isbn, String subject, String author, String publisher, String isIssued) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.isbn = isbn;
        this.subject = subject;
        this.author = author;
        this.publisher = publisher;
        this.isIssued = isIssued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(String isIssued) {
        this.isIssued = isIssued;
    }

  
  

}
