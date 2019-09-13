/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAOImp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarymanagement.Conn.DBConn;
import librarymanagement.POJO.Book;
import librarymanagement.DAO.UserDAO;
import librarymanagement.POJO.Role;
import librarymanagement.POJO.User;

/**
 *
 * @author User
 */
public class UserDaoImp implements UserDAO {
    
    Connection conn = DBConn.getDBConnection();
    
    public static void main(String[] args) {
        UserDaoImp tb = new UserDaoImp();
        tb.createTable();
    }
    
    @Override
    public void createTable() {
        String sql = "create table if not exists user(id int(11)auto_increment primary key, fullname varchar(30), userid varchar(50), username varchar(50)unique, password varchar(30)unique, email varchar(50), institute varchar(50), contact int(11), role_id int(11), FOREIGN KEY(role_id) REFERENCES role(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  /*  @Override
    public void save(User user, File file) {
        String sql = "insert into user(fullname, userid, username, password, email, institute,contact, photo, role_id)values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
         InputStream inputStream=null;
        try {
             inputStream=new FileInputStream(file);
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUserid());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getInstitute());
            ps.setInt(7, user.getContact());
            ps.setInt(8, user.getRole().getId());
             ps.setBinaryStream(9, (InputStream) inputStream, (int) (file.length()));
            ps.executeUpdate();
            System.out.println("Insert");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    } */
    
    @Override
    public void update(User user) {
        String sql = "update user set fullname=?, userid=?, username=?, password=?, email=?, institute=?, contact=?, role_id=? where id=?";
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUserid());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getInstitute());
            ps.setInt(7, user.getContact());
            ps.setInt(8, user.getRole().getId());
            ps.setInt(9, user.getId());
            ps.executeUpdate();
            System.out.println("update!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Book getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Book getUserByName(String bookName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
         //   User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), new Role(rs.getInt(8)));
 //User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), new Role(rs.getInt(9)));
User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), new Role(rs.getInt(9)));
 list.add(user);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public void save(User user) {
         String sql = "insert into user(fullname, userid, username, password, email, institute, contact, role_id)values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps;  
        try {
            ps = conn.prepareStatement(sql);
             ps.setString(1, user.getFullname());
            ps.setString(2, user.getUserid());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getInstitute());
            ps.setInt(7, user.getContact());
            ps.setInt(8, user.getRole().getId());
             ps.executeUpdate();
            System.out.println("Insert");
            
    
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
           
}
}