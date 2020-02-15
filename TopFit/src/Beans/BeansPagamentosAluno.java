
package Beans;

public class BeansPagamentosAluno {
    private int recibo;
    private String id_aluno;
    private String descricao;
    private float valor;
    private String data;
    private String hora;
    private String data_vencimento;

    public BeansPagamentosAluno() {
    }

    public BeansPagamentosAluno(int recibo, String id_aluno, String descricao, float valor, String data, String hora, String data_vencimento) {
        this.recibo = recibo;
        this.id_aluno = id_aluno;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.data_vencimento = data_vencimento;
    }

    public int getRecibo() {
        return recibo;
    }

    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
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

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }
    
    
}
