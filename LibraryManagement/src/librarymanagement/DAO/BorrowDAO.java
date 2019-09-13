/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.util.List;
import librarymanagement.POJO.BookIssue;

/**
 *
 * @author Sumaiya
 */
public interface BorrowDAO {
     void createTable();

      void save(BookIssue borrow);

    void update(BookIssue borrow);
  BookIssue getBookbyISBN(String isbn);
   BookIssue getBookbyId(int id);
    List<BookIssue> getBorrow();


}
