package L06Filas;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()){
            throw new FilaVaziaException();
        }
        
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public String toString(){
        return lista.toString();
    }
}
