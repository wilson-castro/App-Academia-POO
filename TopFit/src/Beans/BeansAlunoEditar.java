
package Beans;

import java.util.Date;

public class BeansAlunoEditar {

     public BeansAlunoEditar(String Id_aluno, Date data_cadastro, String nome,Date data_nascimento,String sexo,
                String cpf,String rg,String uf_doc,String logradouro,String complemento,String bairro,String cidade,
                String cep,String uf,String telefone,String celular,String observacao,String email,byte[] img,int idade)
    {
        this.Id_aluno = Id_aluno;
        this.data_cadastro = data_cadastro;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.uf_doc = uf_doc;
        this.logradouro = logradouro;
        this.complemento = complemento;
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
    
    public BeansAlunoEditar(){
    
    }
        private String Id_aluno;
        private Date data_cadastro;
        private String nome;
        private Date data_nascimento;
        private String sexo;
        private String cpf;
        private String rg;
        private String uf_doc;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String cidade;
        private String cep;
        private String uf;
        private String telefone;
        private String celular;
        private String observacao;
        private String email;
        private int idade;
        private byte[] imagem;

  
 public void setPicture(byte[] imagem) {
        this.imagem = imagem;
    }

    public void setID(String Id_aluno) {
        this.Id_aluno = Id_aluno;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setUf_doc(String uf_doc) {
        this.uf_doc = uf_doc;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getUf_doc() {
        return uf_doc;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
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
