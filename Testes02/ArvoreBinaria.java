package Testes02;

public class ArvoreBinaria<T> {
    NoArvoreBinaria<T> raiz;

    public ArvoreBinaria(){
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(T info){
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info){
        if (no == null){
            return false;
        } else {
            return no.getInfo().equals(info)
                    || pertence(no.getEsquerda().getInfo())
                    || pertence(no.getDireita(), info);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private String arvorePre(NoArvoreBinaria<T> no){
        return null;
    }

    public int contarNos(){
    return 0;
    }

    private int contarNos(NoArvoreBinaria<T> no){
        return 0;
    }
}
