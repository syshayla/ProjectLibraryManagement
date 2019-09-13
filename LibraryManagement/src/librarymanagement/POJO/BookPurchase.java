/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.POJO;

import java.sql.Date;

/**
 *
 * @author User
 */
public class BookPurchase {
      private  int id;
   private  String title;
    private  String isbn;
     private  String authorname;
      private String publisher;
     private  int qty;
      private  Date date;

    public BookPurchase() {
    }

    public BookPurchase(int id) {
        this.id = id;
    }
    

    public BookPurchase(String title, String isbn, String authorname, String publisher, int qty, Date date) {
        this.title = title;
        this.isbn = isbn;
        this.authorname = authorname;
        this.publisher = publisher;
        this.qty = qty;
        this.date = date;
    }

    public BookPurchase(int id, String title, String isbn, String authorname, String publisher, int qty, Date date) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorname = authorname;
        this.publisher = publisher;
        this.qty = qty;
        this.date = date;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
      
        
       
}
