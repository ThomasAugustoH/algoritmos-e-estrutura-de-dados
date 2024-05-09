package L08ArvoresNarias;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";
        s += no.getInfo().toString();

        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        s += ">";
        return s;
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        } else {
            return pertence(raiz, info);
        }
    }

    public boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo() == info) {
            return true;
        } else {
            NoArvore<T> p;
            p = no.getPrimeiro();

            while (p != null) {
                if (pertence(p, info)) {
                    return true;
                }
                p = p.getProximo();
            }
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    public int contarNos(NoArvore<T> no) {

        if (no == null) {
            return 0;
        }
        else {
            return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
        }
    }
}