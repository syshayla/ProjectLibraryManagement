/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAO;

import java.util.List;
import librarymanagement.POJO.Role;

/**
 *
 * @author Sumaiya
 */
public interface RoleDAO {
     void createTable();

      void save(Role role);

    void update(Role role);

    Role getRoleById(int id);

    Role getRoleByRoleName(String roleName);

    void delete(int id);

    List<Role> getRoles();

   
}
