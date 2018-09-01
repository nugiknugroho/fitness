/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahosi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Microsoft USer's
 */
public class KoneksiMySQL {
    private Connection connect;
    private String driverName = "com.mysql.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database = "bismillahPBO";
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    public Connection getkoneksi() throws SQLException{
        if (connect == null) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Class Driver ditemukan");
                try
                {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                }
                catch(SQLException se)
                {
                    System.out.println("Koneksi Database gagal "+se);
                    System.exit(0);
                }
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println("Class Driver Tidak ditemukan Pada : "+cnfe);
                System.exit(0);
            }
            
        }
        return connect;
    }
    
     public static void main(String[] args) {
        try{
            KoneksiMySQL form = new KoneksiMySQL();
            form.getkoneksi();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

   
}
