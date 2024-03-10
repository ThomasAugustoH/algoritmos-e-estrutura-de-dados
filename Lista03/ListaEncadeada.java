package Lista03;

public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        primeiro = novo;
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
        while (p != null && p.getInfo() != info) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p.equals(primeiro)) {
                primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
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
        if (idx < 0 || idx > obterComprimento()) {
            throw new IndexOutOfBoundsException();
        }
        NoLista<T> p = primeiro;
        for (int i = 0; i < idx; i++) {
            p = p.getProximo();
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
