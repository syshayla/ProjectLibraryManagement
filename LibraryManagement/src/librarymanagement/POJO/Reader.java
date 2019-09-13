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
public class Reader {
     private int id;  
       private String ReaderId;    // ID of every person related to library
    private String FullName;  // Password of every person related to library
    private String UserName;      // Name of every person related to library
    private String Email;   // Address of every person related to library
    private int Contact;      // PhoneNo of every person related to library

    public Reader() {
    }

    public Reader(int id, String ReaderId, String FullName, String UserName, String Email, int Contact) {
        this.id = id;
        this.ReaderId = ReaderId;
        this.FullName = FullName;
        this.UserName = UserName;
        this.Email = Email;
        this.Contact = Contact;
    }

    public Reader(String ReaderId, String FullName, String UserName, String Email, int Contact) {
        this.ReaderId = ReaderId;
        this.FullName = FullName;
        this.UserName = UserName;
        this.Email = Email;
        this.Contact = Contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderId() {
        return ReaderId;
    }

    public void setReaderId(String ReaderId) {
        this.ReaderId = ReaderId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }
   
}
