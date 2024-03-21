package Testes01.ListaDuplaCircular;

public class ListaDuplaCircular<T> {

    private NoListaDuplaCircular<T> primeiro;

    public ListaDuplaCircular() {
        primeiro = null;
    }

    public NoListaDuplaCircular<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDuplaCircular<T> novo = new NoListaDuplaCircular<>();
        novo.setInfo(valor);
        if (primeiro != null) {
            novo.setProximo(primeiro);
            novo.setAnterior(primeiro.getAnterior());
            primeiro.getAnterior().setProximo(novo);
            primeiro.setAnterior(novo);
        } else {
            novo.setAnterior(novo);
            novo.setProximo(novo);
        }
        primeiro = novo;
    }

    public NoListaDuplaCircular<T> buscar(T valor) {
        NoListaDuplaCircular<T> p = primeiro;

        if (p != null) {
            do {
                if (p.getInfo().equals(valor)) {
                    return p;
                }
                p = p.getProximo();
            } while (p != primeiro);
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDuplaCircular<T> p = buscar(valor);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            }
            p.getAnterior().setProximo(p.getProximo());
            p.getProximo().setAnterior(p.getAnterior());
        }
    }

    public void exibirOrdemCircular() {
        NoListaDuplaCircular<T> p = primeiro;

        if (p != null) {
            do {
                System.out.println(p.getInfo());
                p = p.getProximo();
            } while (p != primeiro);
        }
    }

    public void exibirOrdemCiruclarInversa() {
        NoListaDuplaCircular<T> p = primeiro;

        if (p != null) {
            do {
                System.out.println(p.getInfo());
                p = p.getAnterior();
            } while (p != primeiro);
        }
    }

    public void liberar() {
        NoListaDuplaCircular<T> p = primeiro;

        while (p != null) {
            p.getAnterior().setProximo(null);
            p.setAnterior(null);
            p = p.getProximo();
        }
        primeiro = null;
    }

    public String toString() {
        String msg = "";
        NoListaDuplaCircular<T> p = primeiro;
        do {
            msg += p.getInfo().toString();
            if (p.getProximo() != null) {
                msg += ",";
            }
            p = p.getProximo();
        } while (p != primeiro);
        return msg;
    }
}
