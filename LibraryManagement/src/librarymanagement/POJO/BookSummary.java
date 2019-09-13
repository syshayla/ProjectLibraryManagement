/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.POJO;

/**
 *
 * @author User
 */
public class BookSummary {

    int id;
     String title;
    
     String isbn;
     String author_name;
     String category;
  
     int totalQty;
     int issueQty;
     int avilableQty;
   BookPurchase book;

    public BookSummary() {
    }
    

    public BookSummary(String isbn, int totalQty, int issueQty, int avilableQty) {
        this.isbn = isbn;
        this.totalQty = totalQty;
        this.issueQty = issueQty;
        this.avilableQty = avilableQty;
    }
    

    public BookSummary(String title, String isbn, String author_name, String category, int totalQty, int issueQty, int avilableQty) {
        this.title = title;
        this.isbn = isbn;
        this.author_name = author_name;
        this.category = category;
        this.totalQty = totalQty;
        this.issueQty = issueQty;
        this.avilableQty = avilableQty;
    }

    public BookSummary(BookPurchase book) {
        this.book = book;
    }

    public BookSummary(int id) {
        this.id = id;
    }
    

   
    public BookSummary(String title, String isbn, String author_name, String category, int totalQty, int issueQty, int avilableQty, BookPurchase book) {
        this.title = title;
        this.isbn = isbn;
        this.author_name = author_name;
        this.category = category;
        this.totalQty = totalQty;
        this.issueQty = issueQty;
        this.avilableQty = avilableQty;
        this.book = book;
    }

    public BookSummary(int id, String title, String isbn, String author_name, String category, int totalQty, int issueQty, int avilableQty, BookPurchase book) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author_name = author_name;
        this.category = category;
        this.totalQty = totalQty;
        this.issueQty = issueQty;
        this.avilableQty = avilableQty;
        this.book = book;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(int issueQty) {
        this.issueQty = issueQty;
    }

    public int getAvilableQty() {
        return avilableQty;
    }

    public void setAvilableQty(int avilableQty) {
        this.avilableQty = avilableQty;
    }

    public BookPurchase getBook() {
        return book;
    }

    public void setBook(BookPurchase book) {
        this.book = book;
    }
    
    

}
