/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahosi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Microsoft USer's
 */
public class Login implements InterfaceLogin{
    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query, userID, password, pesan;
    
    public Login(){
        KoneksiMySQL connection = new KoneksiMySQL();
        
        try
      {
          koneksi = connection.getkoneksi();
      }
      catch(SQLException ex){
          System.out.println(ex);
      }
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String cekLogin(String userID, String password){
        
        query = "SELECT nama FROM admin WHERE id_admin=? AND password=md5(?)";
        
        try{
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            
            if (dataUser.next()) {
                Session.setUserID(userID);
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("Aktif");
                
                query = "INSERT INTO log_login(id_admin) VALUES(?)";
                try{
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userID);
                    psmt.executeUpdate();
                    psmt.close();
                }
                catch(Exception e){
                    pesan = "Gagal Simpan Log Login";
                }
            }
            else{
                pesan = "Gagal Login";
            }
        } catch (Exception ex) {
           pesan = "Gagal Login, Query Error"; 
        }
        return pesan;
    }
    
    public void Logout(String userID){
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE id_admin=? ORDER BY id DESC LIMIT 1";
        try{
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.executeUpdate();
            psmt.close();
            
            koneksi.close();
            
            Session.setUserID(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        }
        catch(Exception e){
            
        }
    }
}
