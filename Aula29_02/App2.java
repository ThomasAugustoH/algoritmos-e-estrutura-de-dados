package Aula29_02;

import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
        ListaEstatica<String> nomes = new ListaEstatica<>();

        nomes.inserir("Lucas");
        nomes.inserir("Ana"); // new String("Ana");
        nomes.inserir("Maria");
        nomes.inserir("Pedro");

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome para pesquisar: ");
        String nomeProcurar = teclado.nextLine();

        int posicao = nomes.buscar(nomeProcurar);
        System.out.println(posicao);
    }
}
