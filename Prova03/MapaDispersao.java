package Prova03;

import L03ListaEncadeada.ListaEncadeada;
import L03ListaEncadeada.NoLista;

public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        // Se a chave onde for inserido o objeto ainda estiver vazia, cria uma nova ListaEncadeada
        if (info[indice] == null) {
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        // Verifica se existe uma ListaEncadeada naquele índice do vetor
        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            // Procurar dentro da ListaEncadeada
            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                info[indice].retirar(no.getInfo());
            }
        }
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        // Verifica se existe uma ListaEncadeada naquele índice do vetor
        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            // Procurar dentro da ListaEncadeada
            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getInfo();
            }
        }
        return null;
    }

    public void realocarMapa(int novoTamanho) {
        ListaEncadeada<NoMapa<T>>[] infoNovo = new ListaEncadeada[novoTamanho];

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                ListaEncadeada<NoMapa<T>> listaEncadeada = info[i];
                for (int j = 0; j < listaEncadeada.obterComprimento(); j++) {
                    NoMapa<T> noMapa = listaEncadeada.obterNo(j).getInfo();
                    int indice = noMapa.getChave() % novoTamanho;

                    if (infoNovo[indice] == null) {
                        infoNovo[indice] = new ListaEncadeada<>();
                    }

                    infoNovo[indice].inserir(noMapa);
                }
            }
        }

        info = infoNovo;
    }
}

