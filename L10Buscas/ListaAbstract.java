package L10Buscas;

public abstract class ListaAbstract<T> {

    private Object[] info;
    private int tamanho;

    public ListaAbstract() {
        info = new Object[10];
        tamanho = 0;
    }

    protected void redimensionar() {
        Object[] infoNovo = new Object[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            infoNovo[i] = info[i];
        }

        info = infoNovo;
    }

    public abstract void inserir(T valor);

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public abstract int buscar(T valor);

    public void retirar(T valor) {
        int indiceValor = buscar(valor);
        if (indiceValor > -1) {
            for (int i = indiceValor + 1; i < tamanho; i++) {
                {
                    info[i - 1] = info[i];
                }
            }
            tamanho--;
            info[tamanho] = null; // Precisa limpar o objeto no final da lista
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao > tamanho || posicao < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    protected Object[] getInfo() {
        return info;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
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
            Object temp = info[i];
            info[i] = info[tamanho - i - 1];
            info[tamanho - i - 1] = temp;
        }
    }
}