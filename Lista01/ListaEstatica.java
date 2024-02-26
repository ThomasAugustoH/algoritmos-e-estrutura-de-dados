package Lista01;

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    private void redimensionar() {
        int[] infoNovo = new int[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            infoNovo[i] = info[i];
        }

        info = infoNovo;
    }

    public void inserir(int valor) {
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

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int indiceValor = buscar(valor);
        if (indiceValor != -1) {
            for (int i = indiceValor; i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao > tamanho) {
            throw new IndexOutOfBoundsException();
        }
        return info[posicao];
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
            msg = msg + info[i];
            if (i < tamanho - 1) {
                msg = msg + ",";
            }
        }
        return msg;
    }
}