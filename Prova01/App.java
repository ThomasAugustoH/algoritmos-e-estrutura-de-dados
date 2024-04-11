package Prova01;

public class App {

    public static void main(String[] args) {

        ListaEstatica<Integer> listae = new ListaEstatica<>();

        listae.inserir(10);
        listae.inserir(20);
        listae.inserir(30);
        listae.inserir(40);
        listae.inserir(50);
        listae.inserir(60);
        listae.inserir(70);
        listae.inserir(80);
        listae.inserir(90);

        listae.inserir(2, 99);

        System.out.println(listae.getTamanho());
        System.out.println(listae.toString());

        listae.inserir(6, 88);

        System.out.println(listae.getTamanho());
        System.out.println(listae.toString());

        System.out.println("\n\n");

        ListaDupla<Integer> lista1 = new ListaDupla<>();
        lista1.inserir(70);
        lista1.inserir(60);
        lista1.inserir(50);
        lista1.inserir(40);
        lista1.inserir(30);
        lista1.inserir(20);
        lista1.inserir(10);

        System.out.println(lista1.toString());

        ListaDupla<Integer> lista2;
        lista2 = lista1.criarSubLista(2,50);

        System.out.println(lista1.toString());
        System.out.println(lista2.toString());

    }
}
