package L08ArvoresNarias;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreTest {

    Arvore<Integer> arvore = new Arvore<>();
    NoArvore<Integer> no1 = new NoArvore<>(1);

    @Before
    public void setUp() throws Exception {
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no10 = new NoArvore<>(10);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        no3.inserirFilho(no8);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        arvore.setRaiz(no1);
    }

    /*
        Validar representação textual de uma árvore
     */

    @Test
    public void testToString() {
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    /*
        Validar que o método buscar() consegue localizar um nó numa árvore
     */
    @Test
    public void testBuscar() {
        assertTrue(arvore.pertence(7));
    }

    /*
        Validar que o método pertence() identifica que dado não consta na árvore
     */
    @Test
    public void testPertence() {
        assertFalse(arvore.pertence(55));
    }

    /*
        Validar o método contarNos()
     */
    @Test
    public void testContarNos() {
        assertEquals(10, arvore.contarNos());
    }
}