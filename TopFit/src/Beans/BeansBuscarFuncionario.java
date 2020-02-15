
package Beans;

public class BeansBuscarFuncionario {
    
    public BeansBuscarFuncionario(String id, String nome, String sexo, byte[] img, String idade) {
        this.Id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.imagem = img;
        this.idade = idade;

    }

    public BeansBuscarFuncionario() {

    }

    private String Id;
    private String nome;
    private String sexo;
    private String idade;
    private byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

}
