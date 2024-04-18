package Lista06;

import Lista03.NoLista;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        if (primeiro == null){
            ultimo = novo;
        }
        primeiro = novo;
    }

    public void inserirNoFinal(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(null);
        if (ultimo == null){
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && !(p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                primeiro = p.getProximo();
            }
            else {
                anterior.setProximo(p.getProximo());
            }
            if (p == ultimo) {
                ultimo = anterior;
            }
        }
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }
        return comprimento;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> p = primeiro;

        while(p != null && idx > 0){
            idx--;
            p = p.getProximo();
        }

        if (p == null){
            throw new IndexOutOfBoundsException();
        }

        return p;
    }

    public String toString() {
        String msg = "";
        NoLista<T> p = primeiro;
        while (p != null) {
            msg += p.getInfo().toString();
            if (p.getProximo() != null) {
                msg += ",";
            }
            p = p.getProximo();
        }
        return msg;
    }
}
