package Beans;

public class BeansBuscarAluno {


    public BeansBuscarAluno(String id_aluno, String nome, String sexo, byte[] img, int idade) {
        this.Id_aluno = id_aluno;
        this.nome = nome;
        this.sexo = sexo;
        this.imagem = img;
        this.idade = idade;

    }

    public BeansBuscarAluno() {

    }

    private String Id_aluno;
    private String nome;
    private String sexo;
    private int idade;
    private byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getId_aluno() {
        return Id_aluno;
    }

    public void setId_aluno(String Id_aluno) {
        this.Id_aluno = Id_aluno;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
