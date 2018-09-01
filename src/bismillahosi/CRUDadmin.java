/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahosi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Microsoft USer's
 */
public class CRUDadmin extends AbstractCRUDadmin{
    
    private String id, password, nama, tempatlahir, tanggallahir, gender, no_telp;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDadmin(){
        
        try {
            KoneksiMySQL connection = new KoneksiMySQL();
            CRUDkoneksi = connection.getkoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTempat(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getTempat() {
        return tempatlahir;
    }

    public void setTanggal(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getTanggal() {
        return tanggallahir;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
    
    public void setTelp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getTelp() {
        return no_telp;
    }
    
     public ResultSet tampilData() {
        CRUDquery = "select id_admin, password, nama, tempatlahir, tanggallahir, gender, no_telp from admin, gender where admin.id_gender=gender.id_gender";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);

        } catch (Exception e) {

        }
        return CRUDhasil;
    }

    public void simpanData(String id_admin, String password, String nama, String tempatlahir, String tanggallahir, String gender, String no_telp) {
        CRUDquery = "insert into admin(id_admin,password,nama,tempatlahir,tanggallahir,id_gender,no_telp) values(?,md5(?),?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_admin);
            CRUDpsmt.setString(2, password);
            CRUDpsmt.setString(3, nama);
            CRUDpsmt.setString(4, tempatlahir);
            CRUDpsmt.setString(5, tanggallahir);
            CRUDpsmt.setString(6, gender);
            CRUDpsmt.setString(7, no_telp);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ubahData(String id_admin, String password, String nama, String tempatlahir, String tanggallahir, String gender, String no_telp) {
        CRUDquery = "update admin set password=?, nama=?, tempatlahir=?, tanggallahir=?, id_gender=?, no_telp=? where id_admin=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, password);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, tempatlahir);
            CRUDpsmt.setString(4, tanggallahir);
            CRUDpsmt.setString(5, gender);
            CRUDpsmt.setString(6, no_telp);
            CRUDpsmt.setString(7, id_admin);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void hapusData(String id_admin) {
        CRUDquery = "delete from admin where id_admin=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_admin);

            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
