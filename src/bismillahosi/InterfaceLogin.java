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
public interface InterfaceLogin {
     public void setUserID(String userID);
    
    public String getUserID();
    
    public void setPassword(String password);
    
    public String getPassword();
    
    public String cekLogin(String userID, String password);
    
    public void Logout(String userID);
}
