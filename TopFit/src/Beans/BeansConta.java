package Beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BeansConta {

    public BeansConta(int Crecibo, String Cid_aluno, String Cdescricao, float Cvalor, Date Cdata, String Chora, Date Cdata_venc) {
        this.recibo = Crecibo;
        this.id_aluno = Cid_aluno;
        this.descricao = Cdescricao;
        this.valor = Cvalor;
        this.data = Cdata;
        this.hora = Chora;
        this.data_venc = Cdata_venc;

    }

    public BeansConta() {
    }

    private int recibo;
    private String descricao;
    private String id_aluno;
    private float valor;
    private Date data;
    private String hora;
    private Date data_venc;
    private String dataPagamento;

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

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getData_venc() {
        return data_venc;
    }

    public void setData_venc(Date data_venc) {
        this.data_venc = data_venc;
    }

    public String getDataPagamento() {

        if (data_venc.before(data)) {
            return "atrasado";
        } else if (data_venc.after(data)) {
            return "pago";
        }
        return null;

    }
}
