
package Beans;

public class BeansFinanceiro {
    private int recibo;
    private String descricao;
    private double valor;
    private String data;
    private String hora;
    private String data_venc;
    private String data_pag;

    public BeansFinanceiro() {
    }

    public int getRecibo() {
        return recibo;
    }

    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData_venc() {
        return data_venc;
    }

    public void setData_venc(String data_venc) {
        this.data_venc = data_venc;
    }

    public String getData_pag() {
        return data_pag;
    }

    public void setData_pag(String data_pag) {
        this.data_pag = data_pag;
    }

}
