package L10Buscas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        Object[] info = getInfo();
        int tamanho = getTamanho();

        if (tamanho == info.length) {
            redimensionar();
        }

       info = getInfo();

        for (int i = 0; i < info.length; i++) {
            if (i == tamanho || valor.compareTo((T) info[i]) < 0){
                for (int j = tamanho - 1; j >= i; j--) {
                    info[j+1] = info[j];
                }
                info[i] = valor;
                break;
            }
        }

        setTamanho(++tamanho);
    }

    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int tamanho = getTamanho();
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim){
            int meio = (inicio + fim)/2;
            if (valor.compareTo((T) info[meio]) < 0){
                fim = meio-1;
            } else if (valor.compareTo((T) info[meio]) > 0) {
                inicio = meio+1;
            } else {
                return meio;
            }
        }
        return -1;
    }
}
