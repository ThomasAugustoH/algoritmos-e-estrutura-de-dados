package Testes02;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore(){

    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null){
            return "";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        String s = "<";
        s += no.getInfo().toString();

        NoArvore<T> p = no.getPrimeiro();
        while (p != null){
            s += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        s += ">";
        return s;
    }

    public boolean pertence(T info){
        return false;
    }

    private boolean pertence(NoArvore<T> no, T info){
        return false;
    }

    public int contarNos(){
        return 0;
    }

    private int contarNos(NoArvore<T> no){
        return 0;
    }
}
