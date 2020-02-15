package Beans;

public class BeansMatricula {

    private String id;
    private String id_aluno;
    private String nome;
    private String id_modalidade;
    private String modalidade;
    private float valor;
    private String data;
    private String vencimento;

    public BeansMatricula(String id, String id_aluno, String nome, String id_modalidade, String modalidade, float valor, String data, String vencimento) {
        this.id = id;
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.id_modalidade = id_modalidade;
        this.modalidade = modalidade;
        this.valor = valor;
        this.data = data;
        this.vencimento = vencimento;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public BeansMatricula() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(String id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
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

    
}
