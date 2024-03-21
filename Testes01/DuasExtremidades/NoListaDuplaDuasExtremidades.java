package Testes01.DuasExtremidades;

public class NoListaDuplaDuasExtremidades<T> {
    private T info;
    private NoListaDuplaDuasExtremidades<T> proximo;
    private NoListaDuplaDuasExtremidades<T> anterior;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDuplaDuasExtremidades<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDuplaDuasExtremidades<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDuplaDuasExtremidades<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDuplaDuasExtremidades<T> anterior) {
        this.anterior = anterior;
    }
}
