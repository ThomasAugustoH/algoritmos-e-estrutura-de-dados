package L10Buscas;

public class ListaEstatica<T> extends ListaAbstract<T>{

    @Override
    public void inserir(T valor) {
        Object[] info = getInfo();
        int tamanho = getTamanho();

        if (tamanho == info.length) {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int tamanho = getTamanho();

        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
