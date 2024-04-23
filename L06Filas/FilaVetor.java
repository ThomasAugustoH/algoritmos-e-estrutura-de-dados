package L06Filas;

public class FilaVetor<T> implements Fila<T>{

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite){
        info = new Object[limite];
        this.limite = limite;
        inicio = 0;
        tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int pos = (inicio + tamanho) % limite;
        info[pos] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()){
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();

        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(limite + f2.limite);

        for (int i = 0; i < tamanho; i++) {
            f3.inserir((T) info[(inicio + i) % limite]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            f3.inserir((T) f2.info[(f2.inicio + i) % f2.limite]);
        }

        return f3;
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < tamanho; i++) {
            retorno += info[(inicio + i) % limite].toString();
            if (i < tamanho - 1) {
                retorno += ",";
            }
        }

        return retorno;
    }

    public int getLimite(){
        return limite;
    }
}
