package Testes01.Lista02;

public class ListaEstatica<T> {
    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] novo = new Object[tamanho + 10];

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int pos = buscar(valor);

        if (pos > -1) {
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            info[tamanho] = null;
            tamanho--;
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao < tamanho) {
            throw new IndexOutOfBoundsException();
        }
        return (T) info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        String msg = "";
        for (int i = 0; i < tamanho; i++) {
            msg += info[i].toString();
            if (i < tamanho - 1) {
                msg += ",";
            }
        }
        return msg;
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            Object tmp = info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = tmp;
        }
    }
}
