package Prova02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaTest {
    ArvoreBinaria<Integer> arvore;
    NoArvoreBinaria<Integer> noRaiz;

    @Before
    public void setUp() throws Exception {
        arvore = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no1);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(3, no3, no4);
        noRaiz = new NoArvoreBinaria<>(1, no2, no5);
    }

    /*
        Conferir se é reconhecida árvore vazia
     */
    @Test
    public void test01() {
        assertTrue(arvore.estaVazia());
    }

    /*
        Conferir se é reconhecida árvore não vazia
     */
    @Test
    public void test02() {
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(5);
        arvore.setRaiz(no1);
        assertFalse(arvore.estaVazia());
    }

    /*
        Conferir a representação textual da árvore usando o caminho pré-ordem
     */
    @Test
    public void test03() {
        arvore.setRaiz(noRaiz);
        String representacaoEsperada = "<1<2<><4<><>>><3<5<><>><6<><>>>>";
        assertEquals(representacaoEsperada, arvore.toString());
    }

    /*
        Conferir se a árvore consegue avaliar se um valor armazenado na raiz pertence à árvore
     */
    @Test
    public void test04() {
        arvore.setRaiz(noRaiz);
        assertTrue(arvore.pertence(1));
    }

    /*
        Conferir se a árvore consegue avaliar se um valor armazenado num nó não raiz e não folha pertence à árvore
     */
    @Test
    public void test05() {
        arvore.setRaiz(noRaiz);
        assertTrue(arvore.pertence(3));
    }

    /*
        Conferir se a árvore consegue avaliar se um valor armazenado num nó folha pertence à árvore
     */
    @Test
    public void test06() {
        arvore.setRaiz(noRaiz);
        assertTrue(arvore.pertence(6));
    }

    /*
        Conferir se a árvore conclui que determinado dado não pertence à árvore
     */
    @Test
    public void test07() {
        arvore.setRaiz(noRaiz);
        assertFalse(arvore.pertence(10));
    }

    /*
        Verificar se o árvore consegue contar a quantidade de nós de uma árvore com altura igual à 2.
     */
    @Test
    public void test08() {
        arvore.setRaiz(noRaiz);
        assertEquals(6, arvore.contarNos());
    }

    @Test
    public void testContarFolhas(){
        arvore.setRaiz(noRaiz);
        assertEquals(3, arvore.contarFolhas(noRaiz));


        NoArvoreBinaria<Integer> no11 = new NoArvoreBinaria<>(11);
        NoArvoreBinaria<Integer> no10 = new NoArvoreBinaria<>(10);
        NoArvoreBinaria<Integer> no9 = new NoArvoreBinaria<>(9);
        NoArvoreBinaria<Integer> no8 = new NoArvoreBinaria<>(8);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4, no10, no11);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, no8);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no9, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);
        assertEquals(6, arvore.contarFolhas(no1));


        NoArvoreBinaria<Integer> no12 = new NoArvoreBinaria<>(12);
        arvore.setRaiz(no12);
        assertEquals(1, arvore.contarFolhas(no12));

    }

}