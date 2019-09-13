package librarymanagement.POJO;

import java.util.Date;

/**
 *
 * @author Sumaiya
 */
public class BookIssue {

    private int id;
    private String readerName;
    private String contact;
      private String ISBN;
  
    private String bookTitle;
    private  BookPurchase bookid;
    private int issueQty;
     private int availQty;
    private Date dateOfIssue;
    private Date dateOfExpiry;

    public BookIssue() {
    }

    public BookIssue(int id) {
        this.id = id;
    }

    public BookIssue(int id, String readerName, String contact, String ISBN, String bookTitle, BookPurchase bookid, int issueQty, int availQty, Date dateOfIssue, Date dateOfExpiry) {
        this.id = id;
        this.readerName = readerName;
        this.contact = contact;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.bookid = bookid;
        this.issueQty = issueQty;
        this.availQty = availQty;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
    }

    public BookIssue(String readerName, String contact, String ISBN, String bookTitle, BookPurchase bookid, int issueQty, int availQty, Date dateOfIssue, Date dateOfExpiry) {
        this.readerName = readerName;
        this.contact = contact;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.bookid = bookid;
        this.issueQty = issueQty;
        this.availQty = availQty;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
    }

   

   
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookPurchase getBookid() {
        return bookid;
    }

    public void setBookid(BookPurchase bookid) {
        this.bookid = bookid;
    }

    public int getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(int issueQty) {
        this.issueQty = issueQty;
    }

    public int getAvailQty() {
        return availQty;
    }

    public void setAvailQty(int availQty) {
        this.availQty = availQty;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    
}
