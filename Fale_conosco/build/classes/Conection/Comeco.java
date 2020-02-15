/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;
import modelo.Fale_Conoscu;
import modelo.loading;


public class Comeco {
    public static void main(String[] args) {
        Fale_Conoscu f = new Fale_Conoscu();
        loading loading = new loading();
        loading.setVisible(true);
        try {
            for (int i = 0; i <=100; i++) {
               Thread.sleep(40);
               loading.contador.setText(Integer.toString(i)+'%');
               loading.load.setValue(i);
                if (i==100) {    
                    loading.dispose();
                    f.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
}
}
