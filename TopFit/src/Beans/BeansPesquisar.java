package Beans;

public class BeansPesquisar {

    public static String LISTAR = "SELECT * FROM alunos";

    public static String REGISTRAR = "INSERT INTO alunos("
            + "id_aluno,"
            + "data_cadastro,"
            + "nome,"
            + "data_nascimento,"
            + "sexo,"
            + "cpf,"
            + "rua,"
            + "NumDaCasa,"
            + "bairro,"
            + "cidade,"
            + "cep,"
            + "uf,"
            + "telefone,"
            + "celular,"
            + "observacao,"
            + "email,"
            + "img,"
            + "idade)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String ATUALIZAR = "UPDATE alunos SET "
            + "id_aluno = ?,"
            + "data_cadastro = ?,"
            + "nome,"
            + "data_nascimento = ?,"
            + "sexo = ?,"
            + "cpf = ?,"
            + "rua = ?,"
            + "NumDaCasa = ?,"
            + "bairro = ?,"
            + "cidade = ?,"
            + "cep = ?,"
            + "uf = ?,"
            + "telefone = ?,"
            + "celular = ?,"
            + "observacao = ?,"
            + "email = ?,"
            + "img = ?,"
            + "idade = ?";

    public static String DELETAR = "DELETE FROM alunos WHERE id_aluno = ?";

    public static String DELETAR_TUDO = "TRUNCATE TABLE alunos";

    private String Id_aluno;
    private String data_cadastro;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String cpf;
    private String rua;
    private String NºDaCasa;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String telefone;
    private String celular;
    private String observacao;
    private String email;
    private String idade;
    private byte[] imagem;

    public BeansPesquisar(String id_aluno, String nome, String data_nascimento, String sexo, String cpf,
            String rua, String NºDaCasa, String bairro, String cidade, String cep, String uf, String telefone,
            String celular, String observacao, String email, String idade, byte[] imagem) {

        this.Id_aluno = id_aluno;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rua = rua;
        this.NºDaCasa = NºDaCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
        this.observacao = observacao;
        this.email = email;
        this.idade = idade;
        this.imagem = imagem;

    }

    public BeansPesquisar() {

    }

    public BeansPesquisar(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, byte[] bytes, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId_aluno() {
        return Id_aluno;
    }

    public void setId_aluno(String Id_aluno) {
        this.Id_aluno = Id_aluno;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNºDaCasa() {
        return NºDaCasa;
    }

    public void setNºDaCasa(String NºDaCasa) {
        this.NºDaCasa = NºDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

}
