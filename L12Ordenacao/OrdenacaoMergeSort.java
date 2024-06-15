package L12Ordenacao;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = getInfo().length - 1;
        mergeSort(0, n);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {

        int tamEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = getInfo()[inicio + i];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i < tamDireita; i++) {
            direita[i] = getInfo()[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;
        int i = inicio;

        for (; i < fim; i++) {
            if (cEsq < tamEsquerda && cDir < tamDireita) {
                T[] info = getInfo();
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    setInfo(info);
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    setInfo(info);
                    cDir++;
                }
            }
        }

        while (cEsq < tamEsquerda){
            T[] info = getInfo();
            info[i] = esquerda[cEsq];
            setInfo(info);
            cEsq++;
            i++;
        }

        while (cDir < tamDireita){
            T[] info = getInfo();
            info[i] = direita[cDir];
            setInfo(info);
            cDir++;
            i++;
        }
    }
}
