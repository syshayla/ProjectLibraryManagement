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
import librarymanagement.DAO.StudentDao;
import librarymanagement.POJO.Student;

/**
 *
 * @author User
 */
public class StudentDaoImp implements StudentDao{
 static Connection conn = DBConn.getDBConnection();
    public static void main(String[] args) {
        StudentDaoImp tb = new StudentDaoImp();
        tb.createTable();
    }
     public static void createTable() {
         String sql = "create table `student` (`id` int not null auto_increment primary key, `name` text not null, `photo` blob)";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.execute();
             System.out.println("Created!");
         } catch (Exception e) {
         }
     }
    
            
    @Override
    public void save(Student student, File file) {
        FileInputStream inputstream = null;
        String sql = "insert into student(name, photo) values(?,?)";
     try {
            try {
                inputstream = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, student.getName());
         ps.setBinaryStream(2, (InputStream) inputstream, (int) (file.length()));
         ps.executeUpdate();
         System.out.println("Insert Success");
     } catch (SQLException ex) {
         Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @Override
    public List<Student> getList() {
        List<Student> list = new ArrayList();
        String sql = "select * from student";
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Student student = new Student(rs.getInt(1), rs.getString(2), rs.getBytes("photo"));
            list.add(student);
             }
             System.out.println("Insert Success!");
        } catch (Exception e) {
        }
     return list;
    }
    
}
