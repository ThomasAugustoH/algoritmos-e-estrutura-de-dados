package L06Filas;

public class App {

    public static void main(String[] args) {
        FilaVetor<Character> fila = new FilaVetor<>(5);

        fila.inserir('A');
        fila.retirar();
        fila.inserir('B');
        fila.inserir('C');
        fila.inserir('D');
        fila.inserir('E');
        fila.retirar();

    }
}
