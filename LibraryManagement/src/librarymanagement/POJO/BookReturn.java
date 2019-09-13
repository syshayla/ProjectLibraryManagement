package librarymanagement.POJO;

import java.util.Date;

/**
 *
 * @author Sumaiya
 */
public class BookReturn {

    private int id;
    private String readerName;
    private String ISBN;
    private String bookTitle;
    private  BookIssue issueid;
    private Date dateOfReceive;
 private int returnQty;
     private int availQty;
   
    public BookReturn() {
    }

    public BookReturn(int id) {
        this.id = id;
    }

    public BookReturn(int id, String readerName, String ISBN, String bookTitle, BookIssue issueid, Date dateOfReceive, int returnQty, int availQty) {
        this.id = id;
        this.readerName = readerName;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.issueid = issueid;
        this.dateOfReceive = dateOfReceive;
        this.returnQty = returnQty;
        this.availQty = availQty;
    }

    public BookReturn(String readerName, String ISBN, String bookTitle, BookIssue issueid, Date dateOfReceive, int returnQty, int availQty) {
        this.readerName = readerName;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.issueid = issueid;
        this.dateOfReceive = dateOfReceive;
        this.returnQty = returnQty;
        this.availQty = availQty;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookIssue getIssueid() {
        return issueid;
    }

    public void setIssueid(BookIssue issueid) {
        this.issueid = issueid;
    }

    public Date getDateOfReceive() {
        return dateOfReceive;
    }

    public void setDateOfReceive(Date dateOfReceive) {
        this.dateOfReceive = dateOfReceive;
    }

    public int getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }

    public int getAvailQty() {
        return availQty;
    }

    public void setAvailQty(int availQty) {
        this.availQty = availQty;
    }

    
}
