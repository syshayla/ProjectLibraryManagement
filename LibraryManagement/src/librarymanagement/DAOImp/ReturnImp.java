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
import librarymanagement.DAO.ReturnDAO;
import librarymanagement.POJO.BookIssue;
import librarymanagement.POJO.BookPurchase;
import librarymanagement.POJO.BookReturn;

/**
 *
 * @author Sumaiya
 */
public class ReturnImp implements ReturnDAO {

    Connection conn = DBConn.getDBConnection();

    public static void main(String[] args) {
        ReturnDAO tb = new ReturnImp();
        tb.createTable();
    }

    @Override
    public void createTable() {
        String sql = "create table if not exists bookreturn(id int(11) auto_increment primary key, readerName varchar(30), isbn varchar(30), book_title varchar(50), issue_id int(11), DateOfReceive Date, returnQty int(11), availQty int (11),foreign key(issue_id) references issue(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(BookReturn br) {
        String sql = "insert into bookreturn(readerName, isbn, book_title, issue_id, DateOfReceive, returnQty, AvailQty) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, br.getReaderName());
            ps.setString(2, br.getISBN());
            ps.setString(3, br.getBookTitle());

            ps.setInt(4, br.getIssueid().getId());
            ps.setDate(5, new java.sql.Date(br.getDateOfReceive().getTime()));
            ps.setInt(6, br.getReturnQty());
            ps.setInt(7, br.getAvailQty());

            ps.executeUpdate();
            System.out.println("Insert");
        } catch (Exception e) {
        }

    }

    @Override
    public void update(BookReturn br) {
        String sql = "update bookreturn set readerName =?, isbn=?, book_title=?, DateOfReceive=?, returnQty=?, AvailQty=? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, br.getReaderName());
            ps.setString(2, br.getISBN());
            ps.setString(3, br.getBookTitle());

            ps.setInt(4, br.getIssueid().getId());
            ps.setDate(5, new java.sql.Date(br.getDateOfReceive().getTime()));
            ps.setInt(6, br.getReturnQty());
            ps.setInt(7, br.getAvailQty());

            ps.executeUpdate();
            System.out.println("update!");

        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<BookReturn> getBorrow() {
        List<BookReturn> list = new ArrayList<>();
        String sql = "select * from receive";
        BookReturn receive = new BookReturn();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //  BookReturn borrow = new BookReturn(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new BookPurchase(rs.getInt(5)), rs.getDate(5), rs.getDate(6));
                receive = new BookReturn(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new BookIssue(rs.getInt(5)), rs.getDate(6), rs.getInt(7), rs.getInt(8));
                list.add(receive);
            }
        } catch (Exception e) {
        }
        return list;

    }

    @Override
    public BookReturn getProductById(int id) {
        BookReturn br = null;
        String sql = "select * from bookreturn where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                br = new BookReturn(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new BookIssue(rs.getInt(5)), rs.getDate(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return br;
    }

}
