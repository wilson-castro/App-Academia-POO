
package Beans;

import java.util.List;

public class BeansModalidades {
    
        public BeansModalidades(String Mid_modalidade, String Mmodalidades, float Mpreço) {
            
        this.id_modalidade = Mid_modalidade;
        this.modalidades = Mmodalidades;
        this.preço = Mpreço;

    }
    
    private String id_modalidade;
    private String modalidades;
    private float preço;

    public BeansModalidades() {
      
    }

    public String getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(String id_modalidade) {
        this.id_modalidade = id_modalidade;
    }


    public String getModalidades() {
        return modalidades;
    }

    public void setModalidades(String modalidades) {
        this.modalidades = modalidades;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public void add(List<BeansModalidades> buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                
}

