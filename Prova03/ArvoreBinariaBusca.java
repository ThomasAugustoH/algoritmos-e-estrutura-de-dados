package Prova03;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);

        // Se está vazia, basta tornar o nó novo a raíz.
        if (estaVazia()) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();
            NoArvoreBinaria<T> pai;

            while (true) {
                pai = p;
                if (info.compareTo(p.getInfo()) < 0) {
                    p = p.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = p.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = getRaiz();

        while (p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }

        return p;
    }

    public NoArvoreBinaria<T> buscarRecursivo(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        if (!info.equals(no.getInfo())) {
            if (info.compareTo(no.getInfo()) < 0) {
                return buscarRecursivo(no.getEsquerda(), info);
            } else {
                return buscarRecursivo(no.getDireita(), info);
            }
        }

        return no;
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != p.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // Localizar nó a ser removido
        while (p != null && !p.getInfo().equals(info)) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) {
            // Caso 1 - Remover folha
            if (p.getEsquerda() == null && p.getDireita() == null) {
                // Se for remover a raíz, então a árvore fica vazia, pois a raíz é uma folha.
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }
                }
            }
            // Caso 2 - Remover nó com 1 filho
            else if (p.getDireita() == null) {
                if (p == getRaiz()) {
                    setRaiz(p.getEsquerda());
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(p.getEsquerda());
                    } else {
                        pai.setDireita(p.getEsquerda());
                    }
                }
            } else if (p.getEsquerda() == null) {
                if (p == getRaiz()) {
                    setRaiz(p.getDireita());
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(p.getDireita());
                    } else {
                        pai.setDireita(p.getDireita());
                    }
                }
            }
            // Caso 3 - Remover nó com 2 filhos
            else {
                NoArvoreBinaria<T> sucessor = extrairSucessor(p);

                if (p == getRaiz()) {
                    setRaiz(sucessor);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(sucessor);
                    } else {
                        pai.setDireita(sucessor);
                    }
                }
                sucessor.setEsquerda(p.getEsquerda());
            }
        }
    }

    public T obterMenorValor() {
        NoArvoreBinaria<T> p = getRaiz();
        if (p == null) {
            return null;
        } else {
            while (p.getEsquerda() != null){
                p = p.getEsquerda();
            }
        }
        return p.getInfo();
    }
}
