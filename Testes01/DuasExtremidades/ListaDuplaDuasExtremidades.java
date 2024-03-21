package Testes01.DuasExtremidades;

public class ListaDuplaDuasExtremidades<T> {
    private NoListaDuplaDuasExtremidades<T> primeiro;
    private NoListaDuplaDuasExtremidades<T> ultimo;

    public ListaDuplaDuasExtremidades() {
        primeiro = null;
        ultimo = null;
    }

    public NoListaDuplaDuasExtremidades<T> getPrimeiro() {
        return primeiro;
    }

    public NoListaDuplaDuasExtremidades<T> getUltimo() {
        return ultimo;
    }

    public void inserir(T valor) {
        NoListaDuplaDuasExtremidades<T> novo = new NoListaDuplaDuasExtremidades<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) { //se o primeiro já existir
            primeiro.setAnterior(novo);
        } else { // se for o primeiro a ser colocado
            ultimo = novo;
        }
        primeiro = novo;
    }

    public void inserir(T valor, boolean reverso) {
        if (!reverso) {
            inserir(valor);
            return;
        }
        NoListaDuplaDuasExtremidades<T> novo = new NoListaDuplaDuasExtremidades<>();
        novo.setInfo(valor);
        novo.setProximo(null);
        novo.setAnterior(ultimo);
        if (ultimo != null) {
            ultimo.setProximo(novo);
        } else {
            primeiro = novo;
        }
        ultimo = novo;
    }

    public NoListaDuplaDuasExtremidades<T> buscar(T valor) {
        NoListaDuplaDuasExtremidades<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDuplaDuasExtremidades<T> p = buscar(valor);

        if (p != null) {
            if (p == primeiro) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p == ultimo) {
                ultimo = p.getAnterior();
            } else {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa() {
        NoListaDuplaDuasExtremidades<T> p = ultimo;

        while (p.getAnterior() != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDuplaDuasExtremidades<T> p = primeiro.getProximo();

        while (p != null) {
            p.getAnterior().setProximo(null);
            p.setAnterior(null);
            p = p.getProximo();
        }

        primeiro = null;
        ultimo = null;
    }

    public String toString() {
        String msg = "";
        NoListaDuplaDuasExtremidades<T> p = primeiro;
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
