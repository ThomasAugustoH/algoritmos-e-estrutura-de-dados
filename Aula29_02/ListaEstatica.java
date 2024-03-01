package Aula29_02;

public class ListaEstatica<ClasseInformadaPeloProgramador> {

    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] infoNovo = new Object[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            infoNovo[i] = info[i];
        }

        info = infoNovo;
    }

    // Primeira versão possuia Object em vez de ClasseInformadaPeloProgramador
    public void inserir(ClasseInformadaPeloProgramador valor) {
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

    public int buscar(ClasseInformadaPeloProgramador valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) { // Usar == não funciona se for buscar um Objeto do tipo String ou um vetor
                return i;
            }
        }
        return -1;
    }

    public void retirar(ClasseInformadaPeloProgramador valor) {
        int indiceValor = buscar(valor);
        if (indiceValor > -1) {
            for (int i = indiceValor + 1; i < tamanho; i++) {
                info[i - 1] = info[i];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    /* Usar a ClasseInformadaPeloProgramador em vez de Object permite usar métodos das classes armazenadas
     *  Sem precisar usar cast na hora de chamar o método */
    public ClasseInformadaPeloProgramador obterElemento(int posicao) {
        if (posicao > tamanho || posicao < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (ClasseInformadaPeloProgramador) info[posicao]; // Precisa do cast
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
}