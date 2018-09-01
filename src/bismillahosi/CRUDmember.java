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
public class CRUDmember extends AbstractCRUDmember{
    
    private String id, nama, tempatlahir, tanggallahir, gender, usia, alamat, no_telp, tipe, harga;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
     public CRUDmember(){
        
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
    
    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getUsia() {
        return usia;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public void setTelp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getTelp() {
        return no_telp;
    }
    
     public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }
    
     public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getHarga() {
        return harga;
    }
    
     public ResultSet tampilData() {
        CRUDquery = "select id, nama, tempatlahir, tanggallahir, gender, usia, alamat, no_telp, Tipe, harga from member, gender, tipemember, harga "
                + "where member.id_gender=gender.id_gender "
                + "AND member.idTipe=tipemember.idTipe AND member.id_harga=harga.id_harga";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);

        } catch (Exception e) {

        }
        return CRUDhasil;
    }

    public void simpanData(String id, String nama, String tempatlahir, String tanggallahir, String gender, String usia,
            String alamat, String no_telp, String tipe, String harga) {
        CRUDquery = "insert into member(id,nama,tempatlahir,tanggallahir,id_gender,usia,alamat,no_telp, idTipe, id_harga) values(?,?,?,?,?,?,?,?,?,?)";
        try {         
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, tempatlahir);
            CRUDpsmt.setString(4, tanggallahir);
            CRUDpsmt.setString(5, gender);
            CRUDpsmt.setString(6, usia);
            CRUDpsmt.setString(7, alamat);
            CRUDpsmt.setString(8, no_telp);
            CRUDpsmt.setString(9, tipe);
            CRUDpsmt.setString(10, harga);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ubahData(String id, String nama, String tempatlahir, String tanggallahir, String gender, String usia,
            String alamat, String no_telp, String tipe, String harga) {
        CRUDquery = "update member set nama=?, tempatlahir=?, tanggallahir=?, id_gender=?, usia=?, alamat=?,no_telp=?, idTipe=?, id_harga=? where id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, tempatlahir);
            CRUDpsmt.setString(3, tanggallahir);
            CRUDpsmt.setString(4, gender);
            CRUDpsmt.setString(5, usia);
            CRUDpsmt.setString(6, alamat);
            CRUDpsmt.setString(7, no_telp);
            CRUDpsmt.setString(8, tipe);
            CRUDpsmt.setString(9, harga);
            CRUDpsmt.setString(10, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void hapusData(String id) {
        CRUDquery = "delete from member where id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);

            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ResultSet cariData(String data) {
        CRUDquery = "select id, nama, tempatlahir, tanggallahir, gender, usia, alamat, no_telp, Tipe, harga from member, gender, tipemember, harga "
                + "where member.id_gender=gender.id_gender "
                + "AND member.idTipe=tipemember.idTipe AND member.id_harga=harga.id_harga";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
//          CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
//          CRUDpsmt.setString(1, id);
//          CRUDpsmt.setString(2, nama);
//          CRUDpsmt.setString(3, alamat);

            //CRUDpsmt.executeQuery(CRUDquery);
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
}
