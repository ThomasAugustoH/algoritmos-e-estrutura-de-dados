package L10Buscas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        Object[] info = getInfo();
        int tamanho = getTamanho();

        if (tamanho == info.length) {
            redimensionar();
            info = getInfo();
        }

        /*for (int i = 0; i < info.length; i++) {
            if (i == tamanho || valor.compareTo((T) info[i]) < 0) {
                for (int j = tamanho - 1; j >= i; j--) {
                    info[j + 1] = info[j];
                }
                info[i] = valor;
                break;
            }
        }*/

        int posicao = procurarPosicaoInclusao(valor);

        if (posicao<getTamanho()){
            deslocarDados(posicao);
        }

        info = getInfo(); // por causa do redimensionamento
        info[posicao] = valor;

        setTamanho(++tamanho);
    }

    private int procurarPosicaoInclusao (T itemAdicionar){
        Object[] info = getInfo();
        int i;
        for (i=0; i<getTamanho(); i++){
            if (itemAdicionar.compareTo((T)info[i])<0);
        }

        //(((Comparable)info[i]).compareTo(itemAdicionar)>0));
        return i;
    }


    private void deslocarDados(int posicao){
        Object[] info = getInfo();

        for (int j = getTamanho()-1; j >= posicao; j--) {
            info[j+1] = info[j];
        }
    }

    @Override
    public int buscar(T valor) {
        Object[] info = getInfo();
        int inicio = 0;
        int fim = getTamanho() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo((T) info[meio]);

            if (comparacao < 0) {
                fim = meio - 1;
            } else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }
}
