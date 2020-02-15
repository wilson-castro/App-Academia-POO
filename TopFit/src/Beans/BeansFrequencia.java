
package Beans;


public class BeansFrequencia {
    
    private String id_aluno;
    private String nome;
    private String data;
    private String hora;

    public BeansFrequencia(String id_aluno, String nome, String data, String hora) {

        this.id_aluno = id_aluno;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        
    }

    public BeansFrequencia() {}

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
    


}
