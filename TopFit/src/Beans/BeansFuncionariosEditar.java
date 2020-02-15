/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author erinaldo
 */
public class BeansFuncionariosEditar {
    
    public BeansFuncionariosEditar(String pid,Date data_cadastro, String nome,Date data_nascimento,String sexo,
                String cpf,String rg,String uf_doc,String logradouro,String complemento,String bairro,String cidade,
                String cep,String uf,String telefone,String celular,String observacao,String email,byte[] img,int idade,String apelido,
                String estado_civil,String funcao,Date data_admissao,float salario,String usuario, String senha)
    {
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
        this.apelido = apelido;
        this.estado_civil = estado_civil;
        this.funcao = funcao;
        this.data_admissao = data_admissao;
        this.salario = salario;
        this.usuario = usuario;
        this.senha = senha;

    }
        
        private String ID;
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
        private String apelido;
        private String estado_civil;
        private String funcao;
        private Date data_admissao;
        private float salario;
        private String usuario;
        private String senha;

    public BeansFuncionariosEditar() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUf_doc() {
        return uf_doc;
    }

    public void setUf_doc(String uf_doc) {
        this.uf_doc = uf_doc;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
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
        
        
}
