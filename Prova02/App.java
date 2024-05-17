package Prova02;

public class App {

    public static void main(String[] args) {

        FilaVetor<Character> fila = new FilaVetor<>(10);

        fila.inserir('Z');
        fila.inserir('Z');
        fila.inserir('Z');
        fila.inserir('A');
        fila.inserir('B');
        fila.inserir('C');
        fila.inserir('D');
        fila.retirar();
        fila.retirar();
        fila.retirar();
        fila.retirar();
        fila.retirar();
        fila.retirar();
        fila.retirar();
        fila.inserir('A');
        fila.inserir('B');
        fila.inserir('C');
        fila.inserir('D');
        fila.inserir('E');
        fila.inserir('F');
        fila.inserir('G');
        fila.inserir('H');
        fila.inserir('I');
        fila.inserir('J');

        System.out.println(fila.toString());

        fila.encolher();
        System.out.println(fila.toString());


    }
}
