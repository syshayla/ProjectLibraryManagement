/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.util.List;
import librarymanagement.POJO.BookSummary;

/**
 *
 * @author User
 */
public interface SummaryDao {
      void createTable();

      void save(BookSummary summary);

    void update(BookSummary summary);
       BookSummary getSummarybyISBN(String isbn);
         BookSummary getSummarybyITitle(String title);
    List<BookSummary> getsummary();
}
