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
public class Session {
    private static String UserID, Nama, StatusLogin;
    
    public static void setUserID(String userID)
    {
        Session.UserID = userID;
    }
    
    public static String getUserID()
    {
        return UserID;
    }
    public static void setNama(String Nama)
    {
        Session.Nama = Nama;
    }
    
     public static String getNama()
    {
        return Nama;
    }
     
     public static void setStatusLogin(String StatusLogin)
    {
        Session.StatusLogin = StatusLogin;
    }
     public static String getStatusLogin()
    {
        return StatusLogin;
    }
    
}
