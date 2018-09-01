/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahosi;

/**
 *
 * @author Microsoft USer's
 */
public abstract class AbstractCRUDadmin {
    
    public abstract void setID(String id);

    public abstract String getID();
    
    public abstract void setPassword(String password);

    public abstract String getPassword();

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void setTempat(String tempatlahir);

    public abstract String getTempat();

    public abstract void setTanggal(String tanggallahir);

    public abstract String getTanggal();

    public abstract void setGender(String gender);

    public abstract String getGender();
    
    public abstract void setTelp(String no_telp);

    public abstract String getTelp();
}
