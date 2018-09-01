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
public class Main {
    
    public static void main(String[] args) {
        try{
            formFitnes form = new formFitnes();
            form.setVisible(true);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
