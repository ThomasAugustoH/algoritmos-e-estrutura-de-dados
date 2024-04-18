package Lista06;

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
        while (lista.getPrimeiro() != null){
            retirar();
        }
    }

    @Override
    public String toString(){
        return lista.toString();
    }
}
