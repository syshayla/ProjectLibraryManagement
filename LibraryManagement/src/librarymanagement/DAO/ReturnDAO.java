/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.util.List;
import librarymanagement.POJO.BookReturn;

/**
 *
 * @author Sumaiya
 */
public interface ReturnDAO {
     void createTable();

      void save(BookReturn br);

    void update(BookReturn br);
    BookReturn getProductById(int id);
    List<BookReturn> getBorrow();


}
