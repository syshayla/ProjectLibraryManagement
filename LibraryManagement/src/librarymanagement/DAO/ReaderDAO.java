/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.util.List;
import librarymanagement.POJO.Book;
import librarymanagement.POJO.Reader;


/**
 *
 * @author Sumaiya
 */
public interface ReaderDAO {
     void createTable();

      void save(Reader read);

    void update(Reader read);

    Book getReaderById(int id);

    Book getReaderByName(String bookName);

    void delete(int id);

    List<Reader> getReaders();

   
}
