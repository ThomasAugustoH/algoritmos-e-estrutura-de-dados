package Aula29_02;

public class App {

    public static void main(String[] args) {
        ListaEstatica nomes = new ListaEstatica();
        nomes.inserir("a");
        nomes.inserir("b");
        nomes.inserir("c");

        ListaEstatica numeros = new ListaEstatica();
        numeros.inserir(1);
        numeros.inserir(2);
        numeros.inserir(3);

        // Permite armazenar objetos até mesmo se não forem correspondentes com o resto da lista
        /*
        ListaEstaticaGenerico alunos = new ListaEstaticaGenerico();
        alunos.inserir(new Aluno(32590, "Ana"));
        alunos.inserir(new Aluno(43676, "Eduardo"));
        alunos.inserir(new Aluno(96402, "Pedro"));
        alunos.inserir("Maria");
        */

        ListaEstatica<Aluno> alunos = new ListaEstatica<>();
        alunos.inserir(new Aluno(32590, "Ana"));
        alunos.inserir(new Aluno(43676, "Eduardo"));
        alunos.inserir(new Aluno(96402, "Pedro"));
        //alunos.inserir("Maria"); // Com o parâmetro <>, o compilador recusa classes não informadas
    }
}
