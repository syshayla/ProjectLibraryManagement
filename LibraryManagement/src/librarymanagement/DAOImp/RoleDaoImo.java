/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.DAOImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import librarymanagement.POJO.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarymanagement.Conn.DBConn;
import librarymanagement.DAO.RoleDAO;

/**
 *
 * @author Sumaiya
 */
public class RoleDaoImo implements RoleDAO{
Connection conn = DBConn.getDBConnection();
    public static void main(String[] args) {
        RoleDaoImo tb = new RoleDaoImo();
        tb.createTable();
    }
    @Override
    public void createTable() {
         String sql = "create table IF NOT EXISTS role(id int(11) auto_increment primary key, role_name varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Role role) {
           String sql = "insert into role(role_name) values(?)";
        try {
          PreparedStatement pstm = conn.prepareStatement(sql);
                  pstm.setString(1, role.getRoleName());
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Role role) {
       }

    @Override
    public Role getRoleById(int id) {
        Role role = new Role();
        String sql = "select * from role where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role.setId(rs.getInt(1));
                role.setRoleName(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
       }

    @Override
    public Role getRoleByRoleName(String roleName) {
         Role role = new Role();
        String sql = "select * from role where role_name=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role.setId(rs.getInt(1));
                role.setRoleName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    @Override
    public void delete(int id) {
       }

    @Override
    public List<Role> getRoles() {
       List<Role> list = new ArrayList<>();
        String sql = "select * from role";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                list.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

  
    
}
