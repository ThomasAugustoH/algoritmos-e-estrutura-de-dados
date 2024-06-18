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
            // Quebrando sub-vetores à esquerda
            mergeSort(inicio, meio);
            // Quebrando sub-vetores à direita
            mergeSort(meio + 1, fim);
            // Juntando vetores
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {

        /*
            Calcular tamanho do array esquerdo e copiar os elementos para esse vetor temporário
         */
        int tamEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = getInfo()[inicio + i];
        }

         /*
            Calcular tamanho do array direito e copiar os elementos para esse vetor temporário
         */
        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i < tamDireita; i++) {
            direita[i] = getInfo()[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;
        int i = inicio;

        // Faz a fusão dos arrays temporários no array principal
        for (; cEsq < tamEsquerda && cDir < tamDireita; i++) {
            T[] info = getInfo(); // Obtém o array principal
            // Compara os elementos dos arrays esquerdo e direito
            if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                // Se o elemento do array esquerdo é menor, copia-o para o array principal
                info[i] = esquerda[cEsq];
                setInfo(info);
                cEsq++; // Incrementa o índice do array esquerdo
            } else {
                // Se o elemento do array direito é menor ou igual, copia-o para o array principal
                info[i] = direita[cDir];
                setInfo(info);
                cDir++; // Incrementa o índice do array direito
            }
        }

        // Copia os elementos restantes do array esquerdo, se houver
        while (cEsq < tamEsquerda) {
            T[] info = getInfo();
            info[i] = esquerda[cEsq]; // Copia o elemento do array esquerdo para o array principal
            setInfo(info);
            cEsq++;
            i++;
        }

        // Copia os elementos restantes do array direito, se houver
        while (cDir < tamDireita) {
            T[] info = getInfo();
            info[i] = direita[cDir]; // Copia o elemento do array direito para o array principal
            setInfo(info);
            cDir++;
            i++;
        }
    }
}
