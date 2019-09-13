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
import librarymanagement.DAO.BorrowDAO;
import librarymanagement.POJO.BookIssue;
import librarymanagement.POJO.BookPurchase;

/**
 *
 * @author Sumaiya
 */
public class BorrowImp implements BorrowDAO{
 Connection conn = DBConn.getDBConnection();

    public static void main(String[] args) {
        BorrowImp tb = new BorrowImp();
        tb.createTable();
    }
    @Override
    public void createTable() {
        String sql = "create table if not exists issue(id int(11) auto_increment primary key, readerName varchar(30), contact varchar(30), isbn varchar(30), book_title varchar(50), book_id int(11), issueQty int(11), availQty int (11),DateIssue Date, DateExpiry Date, foreign key(book_id) references purchase(id))";
          try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(BookIssue borrow) {
     String sql = "insert into issue(readerName, contact, isbn, book_title, book_id, issueQty, availQty, DateIssue, DateExpiry) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, borrow.getReaderName());
            ps.setString(2, borrow.getContact());
            ps.setString(3, borrow.getISBN());
             ps.setString(4, borrow.getBookTitle());
           
             ps.setInt(5, borrow.getBookid().getId());
              ps.setInt(6, borrow.getIssueQty());
              ps.setInt(7, borrow.getAvailQty());
            
               ps.setDate(8, new java.sql.Date(borrow.getDateOfIssue().getTime()));
               ps.setDate(9, new java.sql.Date(borrow.getDateOfExpiry().getTime()));
               ps.executeUpdate();
            System.out.println("Insert");
        } catch (Exception e) {
        }
    }

    @Override
    public void update(BookIssue borrow) {
        String sql = "update issue set readerName =?, contact=?, isbn=?, book_title=?, book_id=?,issueQty=?, availQty=?, DateIssue=?, DateExpiry=? where id = ?";
       try {
       PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, borrow.getReaderName());
            ps.setString(2, borrow.getContact());
            ps.setString(3, borrow.getISBN());
             ps.setString(4, borrow.getBookTitle());
           
             ps.setInt(5, borrow.getBookid().getId());
             ps.setInt(6, borrow.getIssueQty());
              ps.setInt(7, borrow.getAvailQty());
            
               ps.setDate(8, new java.sql.Date(borrow.getDateOfIssue().getTime()));
               ps.setDate(9, new java.sql.Date(borrow.getDateOfExpiry().getTime()));
               ps.executeUpdate();
              System.out.println("update!"); 
            
     
     
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
        }

    @Override
    public List<BookIssue> getBorrow() {
        List<BookIssue> list = new ArrayList<>();
        String sql = "select * from Issue";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
              BookIssue borrow = new BookIssue(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), new BookPurchase(rs.getInt(6)), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10));
               list.add(borrow);
            }
        } catch (Exception e) {
        }
        return list;
            
    }

    @Override
    public BookIssue getBookbyISBN(String isbn) {
        String sql = "select * from issue where isbn=? limit 1";
        BookIssue b = new BookIssue();
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, isbn);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
           b = new BookIssue(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), new BookPurchase(rs.getInt(6)), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10));
   
         
         }   
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return b;
    }

    @Override
    public BookIssue getBookbyId(int id) {
         String sql = "select * from issue where id=?";
        BookIssue b = new BookIssue();
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setInt(1, id);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
           b = new BookIssue(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), new BookPurchase(rs.getInt(6)), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10));
   
         
         }   
     } catch (SQLException ex) {
         Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return b;
    }   
}
    

