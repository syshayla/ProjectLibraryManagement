/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.io.File;
import java.util.List;
import librarymanagement.POJO.Book;
import librarymanagement.POJO.User;


/**
 *
 * @author Sumaiya
 */
public interface UserDAO {
     void createTable();

      //void save(User user, File file);
      void save(User user);

    void update(User user);

    Book getUserById(int id);

    Book getUserByName(String bookName);

    void delete(int id);

    List<User> getUsers();

   
}
