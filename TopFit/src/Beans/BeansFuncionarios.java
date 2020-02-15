package Beans;

public class BeansFuncionarios {

        public BeansFuncionarios(String id_func, String data_cadastro, String nome, String data_nascimento, String sexo,
            String cpf, String rua, String NumDaCasa, String bairro, String cidade, String cep, String uf, String telefone, 
            String celular, String observacao, String email, byte[] img, String idade, String apelido,String estado_civil, 
            String funcao, String salario, String usuario, String senha)
    {
        this.ID = id_func;
        this.data_cadastro = data_cadastro;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rua = rua;
        this.NumDaCasa = NumDaCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
        this.observacao = observacao;
        this.email = email;
        this.imagem = img;
        this.idade = idade;
        this.apelido = apelido;
        this.estado_civil = estado_civil;
        this.funcao = funcao;
        this.salario = salario;
        this.usuario = usuario;
        this.senha = senha;

    }
        
        private String ID;
        private String data_cadastro;
        private String nome;
        private String data_nascimento;
        private String sexo;
        private String cpf;
        private String rua;
        private String NumDaCasa;
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
        private String apelido;
        private String estado_civil;
        private String funcao;
        private String data_admissao;
        private String salario;
        private String usuario;
        private String senha;

    public BeansFuncionarios() {}

    public String getRua() {
        return rua;
    }

    public String getNumDaCasa() {
        return NumDaCasa;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumDaCasa(String NumDaCasa) {
        this.NumDaCasa = NumDaCasa;
    }

    
 public void setPicture(byte[] imagem) {
        this.imagem = imagem;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLogradouro(String rua) {
        this.rua = rua;
    }

    public void setComplemento(String NumDaCasa) {
        this.NumDaCasa = NumDaCasa;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }



    public String getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogradouro() {
        return rua;
    }

    public String getComplemento() {
        return NumDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getUf() {
        return uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPicture() {
        return imagem;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public byte[] getImage()
    {
        return imagem;
    }

}