/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarymanagement.Conn.DBConn;
import librarymanagement.DAO.BookDAO;

import librarymanagement.POJO.BookPurchase;

/**
 *
 * @author User
 */
public class BookDaoImp implements BookDAO{
Connection conn = DBConn.getDBConnection();

    public static void main(String[] args) {
        BookDAO tb = new BookDaoImp();
        tb.createTable();
    }
    @Override
    public void createTable() {
      String sql = "create table purchase(id int(11) auto_increment primary key, title varchar(30), isbn varchar(30), authorname varchar(30), booktype varchar(30), qty int(11), date Date)";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.execute();
         System.out.println("Created!");
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     } }

    @Override
    public void save(BookPurchase p) {
         String sql= "insert into purchase(title, isbn, authorname, booktype, qty, date)values(?,?,?,?,?,?)";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, p.getTitle());
         pstm.setString(2, p.getIsbn());
         pstm.setString(3, p.getAuthorname());
          pstm.setString(4, p.getPublisher());
      pstm.setInt(5, p.getQty());
       pstm.setDate(6, p.getDate());
       pstm.executeUpdate();
         System.out.println("Inserted"); 
            
     
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }  
    }

    @Override
    public void update(BookPurchase p) {
         String sql = "update purchase set title =?, isbn=?, authorname=?, booktype=?, qty=?, date=? where id = ?";
       try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, p.getTitle());
         pstm.setString(2, p.getIsbn());
         pstm.setString(3, p.getAuthorname());
          pstm.setString(4, p.getPublisher());
      pstm.setInt(5, p.getQty());
       pstm.setDate(6, p.getDate());
       pstm.setInt(7, p.getId());
       pstm.executeUpdate();
         System.out.println("update!"); 
            
     
     
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
           }

    @Override
    public BookPurchase getBookbyISBN(String isbn) {
          String sql = "select * from purchase where isbn=? limit 1";
        BookPurchase b = new BookPurchase();
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, isbn);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
           b = new BookPurchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7));
         
         
         }   
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return b;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BookPurchase> getlist() {
         List<BookPurchase> list = new ArrayList<>();
       String sql = "select * from purchase";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
             BookPurchase book = new BookPurchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7));        
         list.add(book);
         }
     
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
   
    return list;
          }

    @Override
    public BookPurchase getBookbyId(int id) {
       String sql = "select * from purchase where id=? limit 1";
        BookPurchase b = new BookPurchase();
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setInt(1, id);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
           b = new BookPurchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7));
         
         
         }   
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return b;
    }
    
}
