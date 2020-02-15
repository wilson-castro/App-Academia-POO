package Beans;

public class BeansAluno {
    
    public BeansAluno(String Id_aluno, String data_cadastro, String nome,String data_nascimento,String sexo,
                String cpf,String rua,String NºDaCasa,String bairro,String cidade,
                String cep,String uf,String telefone,String celular,String observacao,String email,byte[] img,int idade)
    {
        this.Id_aluno = Id_aluno;
        this.data_cadastro = data_cadastro;
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
        this.imagem = img;
        this.idade = idade;

    }

    public BeansAluno() {
    
    }
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
        private int idade;
        private int pagamento;
        private byte[] imagem;
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

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }


  
    public void setPicture(byte[] imagem) {
        this.imagem = imagem;
    }

    public void setID(String Id_aluno) {
        this.Id_aluno = Id_aluno;
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

    public void setLogradouro(String logradouro) {
        this.rua = logradouro;
    }

    public void setComplemento(String NºDaCasa) {
        this.NºDaCasa = NºDaCasa;
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
    
/**---------------------------------------------------------------**/
    
    public String getId_aluno() {
        return Id_aluno;
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
        return NºDaCasa;
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
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public byte[] getImage()
    {
        return imagem;
    }

}