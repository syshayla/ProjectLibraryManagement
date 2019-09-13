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
public class User {
    private int id;
    private String fullname;
     private String userid;
    private String username;
    private String password;
    private String email;
    private String institute;
    private int contact;
    private Role role;
   private byte[] photo;

    public User() {
    }

    public User(String fullname, String userid, String username, String password, String email, String institute, int contact, Role role, byte[] photo) {
        this.fullname = fullname;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.institute = institute;
        this.contact = contact;
        this.role = role;
        this.photo = photo;
    }

    public User(String fullname, String userid, String username, String password, String email, String institute, int contact, Role role) {
        this.fullname = fullname;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.institute = institute;
        this.contact = contact;
        this.role = role;
    }

    public User(int id, String fullname, String userid, String username, String password, String email, String institute, int contact, Role role) {
        this.id = id;
        this.fullname = fullname;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.institute = institute;
        this.contact = contact;
        this.role = role;
    }
    

    public User(int id, String fullname, String userid, String username, String password, String email, String institute, int contact, Role role, byte[] photo) {
        this.id = id;
        this.fullname = fullname;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.institute = institute;
        this.contact = contact;
        this.role = role;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    
    
}
