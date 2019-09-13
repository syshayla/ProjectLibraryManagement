/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;


import java.util.List;
import librarymanagement.POJO.BookPurchase;


/**
 *
 * @author Sumaiya
 */
public interface BookDAO {
     void createTable();

      void save(BookPurchase p);

    void update(BookPurchase p);

  

   BookPurchase getBookbyId(int id);
     BookPurchase getBookbyISBN(String isbn);

    void delete(int id);

    List<BookPurchase> getlist();

   
}
