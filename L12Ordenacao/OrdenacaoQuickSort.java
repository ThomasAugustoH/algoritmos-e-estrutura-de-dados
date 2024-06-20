package L12Ordenacao;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        int n = getInfo().length - 1;
        quickSort(0, n);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }

    // Identificar a localização final do pivô
    // Coloca os elementos menores à esquerda do pivô
    // Coloca os elementos maiores à direita do pivô
    private int particionar(int inicio, int fim) {
        T[] info = getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }

            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }
}
