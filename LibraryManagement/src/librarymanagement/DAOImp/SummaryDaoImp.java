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
import librarymanagement.DAO.SummaryDao;
import librarymanagement.POJO.BookSummary;

/**
 *
 * @author User
 */
public class SummaryDaoImp implements SummaryDao{
    Connection conn = DBConn.getDBConnection();

    public static void main(String[] args) {
        SummaryDaoImp tb = new SummaryDaoImp();
        tb.createTable();
    }

    @Override
    public void createTable() {
       String sql = "create table if not exists summary(id int(11)auto_increment primary key, title varchar(30), isbn varchar(30), authorname varchar(30), booktype varchar(30), qty int(11), issueQty int(11), availableQty int(11), bookid int(11), foreign key (bookid) references purchase(id))";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.execute();
         System.out.println("Created!");
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }   }

    @Override
    public void save(BookSummary summary) {
       String sql= "insert into summary(title, isbn, authorname, booktype, qty, issueQty, availableQty, bookid)values(?,?,?,?,?,?,?,?)";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, summary.getTitle());
         pstm.setString(2, summary.getIsbn());
         pstm.setString(3, summary.getAuthor_name());
          pstm.setString(4, summary.getCategory());
      pstm.setInt(5, summary.getTotalQty());
       pstm.setInt(6, summary.getIssueQty());
       pstm.setInt(7, summary.getAvilableQty());
       pstm.setInt(8, summary.getBook().getId());
       
       pstm.executeUpdate();
         System.out.println("Inserted"); 
            
     
     
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
    @Override
    public void update(BookSummary summary) {
        String sql = "update summary set title =?, isbn=?, authorname=?, booktype=?, qty=?, issueQty=?, availableQty=?, bookid=? where id = ?";
       try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, summary.getTitle());
         pstm.setString(2, summary.getIsbn());
         pstm.setString(3, summary.getAuthor_name());
          pstm.setString(4, summary.getCategory());
      pstm.setInt(5, summary.getTotalQty());
       pstm.setInt(6, summary.getIssueQty());
       pstm.setInt(7, summary.getAvilableQty());
       pstm.setInt(8, summary.getBook().getId());
        System.out.println("update!"); 
            
     
     
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
           }

    @Override
    public BookSummary getSummarybyISBN(String isbn) {
         BookSummary sm = null;
        String sql = "select * from summary where isbn=?";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, isbn);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
            sm = new BookSummary(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), new librarymanagement.POJO.BookPurchase(rs.getInt(9)));
                    }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return sm;
     }

    @Override
    public List<BookSummary> getsummary() {
        List<BookSummary> list = new ArrayList<>();
           String sql = "select * from summary";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
             BookSummary sm = new BookSummary(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), new librarymanagement.POJO.BookPurchase(rs.getInt(9)));
                     list.add(sm);
         }
     
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
   
    return list;
    }

    @Override
    public BookSummary getSummarybyITitle(String title) {
        BookSummary sm = null;
        String sql = "select * from summary where title=?";
     try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, title);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()){
            sm = new BookSummary(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), new librarymanagement.POJO.BookPurchase(rs.getInt(9)));
                    }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(SummaryDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return sm;
    }
}
