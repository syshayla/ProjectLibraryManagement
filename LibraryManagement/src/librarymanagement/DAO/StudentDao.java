/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.io.File;
import java.util.List;
import librarymanagement.POJO.Student;

/**
 *
 * @author User
 */
public interface StudentDao {
    void save(Student student, File file);
    List<Student> getList();
}
