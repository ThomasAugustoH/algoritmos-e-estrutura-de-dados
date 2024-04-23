package L05Pilhas;

public class PilhaVetor<T> implements Pilha<T> {

    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        info = new Object[limite];
        this.limite = limite;
        tamanho = 0;
    }

    @Override
    public void push(T info) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        }

        this.info[tamanho] = info;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor = peek();
        this.info[tamanho] = null;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if (tamanho == 0) {
            throw new PilhaVaziaException();
        }

        return (T) info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;

        /*
        while (!estaVazia()){
            pop();
        }
        */

    }

    @Override
    public String toString() {
        String pilha = "";
        for (int i = tamanho - 1; i >= 0; i--) {
            pilha += info[i].toString();
            if (i != 0) {
                pilha += ",";
            }
        }
        return pilha;
    }

    public void concatenar(PilhaVetor<T> p) {
        if (this.tamanho + p.tamanho > this.limite) {
            throw new RuntimeException("Não há espaço para todos os dados");
        }
        for (int i = 0; i < p.tamanho; i++) {
            push((T) p.info[i]);
        }
    }
}
