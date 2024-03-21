package Testes01.ListaDuplaCircular;

public class NoListaDuplaCircular<T> {
    private T info;
    private NoListaDuplaCircular<T> proximo;
    private NoListaDuplaCircular<T> anterior;

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setProximo(NoListaDuplaCircular<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDuplaCircular<T> getProximo() {
        return proximo;
    }

    public void setAnterior(NoListaDuplaCircular<T> anterior) {
        this.anterior = anterior;
    }

    public NoListaDuplaCircular<T> getAnterior() {
        return anterior;
    }
}
