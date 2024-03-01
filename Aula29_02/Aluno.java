package Aula29_02;

public class Aluno {

    private int matricula;
    private String nome;

    public Aluno(int matricula, String nome){
        setMatricula(matricula);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
