/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import librarymanagement.Conn.DBConn;
import librarymanagement.DAO.ReaderDAO;
import librarymanagement.POJO.Book;
import librarymanagement.POJO.Reader;

/**
 *
 * @author User
 */
public class ReaderDaoImp implements ReaderDAO{
    Connection conn = DBConn.getDBConnection();
    public static void main(String[] args) {
        ReaderDaoImp tb = new ReaderDaoImp();
        tb.createTable();
    }
            

    @Override
    public void createTable() {
        String sql = "create table if not exists reader(id int(11)auto_increment primary key, readerid varchar(30), fullname varchar(50), username varchar(50)unique, email varchar(50), contact int(14))";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.execute();
             System.out.println("Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Reader read) {
       String sql = "insert into reader(readerid, fullname, username, email,contact)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, read.getReaderId());
            ps.setString(2, read.getFullName());
            ps.setString(3, read.getUserName());

            ps.setString(4, read.getEmail());
            ps.setInt(5, read.getContact());
            ps.executeUpdate();
            System.out.println("Inserted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reader read) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book getReaderById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book getReaderByName(String bookName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reader> getReaders() {
       List <Reader> list = new ArrayList<>();
       String sql = "select * from reader";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reader r = new Reader(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            list.add(r);
            }
        } catch (Exception e) {
        }
        return list;
    } 
    
}
