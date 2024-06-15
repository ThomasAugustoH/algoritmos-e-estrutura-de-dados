package L11ArvoreBinariaBusca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTest {

    ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

    /*
        Conferir se o método inserir() mantém os dados armazenados adequadamente, mantendo a árvore com a
        característica de ser uma árvore binária de busca.
     */
    @Test
    public void testeArmazenar() {
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);

        String esperado = "<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>";

        assertEquals(esperado, arvore.toString());
    }

    /*
        Conferir se a árvore consegue remover um nó folha
     */
    @Test
    public void testeRemoverFolha() {
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);

        arvore.retirar(40);

        String esperado = "<50<30<25<><>><>><>>";

        assertEquals(esperado, arvore.toString());
    }

    /*
        Conferir se a árvore consegue remover nó com um filho
     */
    @Test
    public void testeRemoverUmFilho() {
        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);

        arvore.retirar(71);

        String esperado = "<80<52<48<><>><63<><67<><>>>><90<><>>>";

        assertEquals(esperado, arvore.toString());
    }

    /*
        Conferir se a árvore consegue remover um nó com dois filhos
     */
    @Test
    public void testeRemoverDoisFilhos() {
        arvore.inserir(250);
        arvore.inserir(38);
        arvore.inserir(26);
        arvore.inserir(72);
        arvore.inserir(55);
        arvore.inserir(90);
        arvore.inserir(41);
        arvore.inserir(60);
        arvore.inserir(43);
        arvore.inserir(78);
        arvore.inserir(92);
        arvore.inserir(74);

        arvore.retirar(38);

        String esperado = "<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>";

        assertEquals(esperado, arvore.toString());
    }
}