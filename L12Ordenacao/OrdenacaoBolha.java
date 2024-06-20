package L12Ordenacao;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        T[] info = getInfo();
        int n = info.length;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
