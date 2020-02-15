
package Beans;


public class BeansContaMatricula {
    
    public BeansContaMatricula(String mid_aluno, String mid_modalidade, int mdia_pagamento , String mdata_matricula) {
        this.id_aluno = mid_aluno;
        this.id_modalidades = mid_modalidade;
        this.dia_pagamento = mdia_pagamento;
        this.data_matricula = mdata_matricula;

    }
    
    private String id_matricula;
    private String id_aluno;
    private String id_modalidades;
    private int dia_pagamento;
    private String data_matricula;

    public BeansContaMatricula() {}

    
    public String getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(String id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getId_modalidades() {
        return id_modalidades;
    }

    public void setId_modalidades(String id_modalidades) {
        this.id_modalidades = id_modalidades;
    }

    public int getDia_pagamento() {
        return dia_pagamento;
    }

    public void setDia_pagamento(int dia_pagamento) {
        this.dia_pagamento = dia_pagamento;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }
   
}
