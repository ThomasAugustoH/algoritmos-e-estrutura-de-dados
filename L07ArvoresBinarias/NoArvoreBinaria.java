package L07ArvoresBinarias;

public class NoArvoreBinaria<T> {

    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;
    private T info;

    public NoArvoreBinaria(T info){
        setInfo(info);
        setEsquerda(null);
        setDireita(null);
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir){
        setInfo(info);
        setEsquerda(esq);
        setDireita(dir);
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}
