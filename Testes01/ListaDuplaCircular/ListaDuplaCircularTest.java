package Testes01.ListaDuplaCircular;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListaDuplaCircularTest {
    private ListaDuplaCircular<Integer> l;

    @Before
    public void setUp() throws Exception {
        l = new ListaDuplaCircular<>();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
        Testar método de inclusão de dados na lista encadeada, validando que as ligações proximo e
        anterior estejam consistentes
    */
    @Test
    public void Test01() {
        NoListaDuplaCircular<Integer> p = l.getPrimeiro();
        String msg = "";
        do {
            msg += p.getInfo() + " ";
            p = p.getProximo();
        } while (p != l.getPrimeiro());

        assertEquals("20 15 10 5 ", msg);

        msg = "";
        do {
            p = p.getAnterior();
            msg += p.getInfo() + " ";
        } while (p != l.getPrimeiro());
        assertEquals("5 10 15 20 ", msg);
    }

    /*
        Buscar elemento no início da estrutura de dados
     */
    @Test
    public void Test02() {
        assertEquals((Integer) 20, l.buscar(20).getInfo());
    }

    /*
        Buscar elemento no meio da estrutura de dados
     */
    @Test
    public void Test03() {
        assertEquals((Integer) 10, l.buscar(10).getInfo());
    }

    /*
        Remover elemento no início da lista
     */
    @Test
    public void Test04() {
        l.retirar(20);
        NoListaDuplaCircular<Integer> p = l.getPrimeiro();
        String msg = "";
        do {
            msg += p.getInfo() + " ";
            p = p.getProximo();
        } while (p != l.getPrimeiro());
        assertEquals("15 10 5 ", msg);

        msg = "";
        do {
            p = p.getAnterior();
            msg += p.getInfo() + " ";
        } while (p != l.getPrimeiro());
        assertEquals("5 10 15 ", msg);
    }

    /*
        Retirar elemento no meio da lista
     */
    @Test
    public void Test05() {
        l.retirar(10);
        NoListaDuplaCircular<Integer> p = l.getPrimeiro();
        String msg = "";
        do {
            msg += p.getInfo() + " ";
            p = p.getProximo();
        } while (p != l.getPrimeiro());
        assertEquals("20 15 5 ", msg);

        msg = "";
        do {
            p = p.getAnterior();
            msg += p.getInfo() + " ";
        } while (p != l.getPrimeiro());
        assertEquals("5 15 20 ", msg);
    }

    /*
        Retirar elemento no fim da lista
     */
    @Test
    public void Test06() {
        l.retirar(5);
        NoListaDuplaCircular<Integer> p = l.getPrimeiro();
        String msg = "";
        do {
            msg += p.getInfo() + " ";
            p = p.getProximo();
        } while (p != l.getPrimeiro());
        assertEquals("20 15 10 ", msg);

        msg = "";
        do {
            p = p.getAnterior();
            msg += p.getInfo() + " ";
        } while (p != l.getPrimeiro());
        assertEquals("10 15 20 ", msg);
    }

    /*
        Liberar dados da lista
     */
    @Test
    public void Test07() {
        NoListaDuplaCircular<Integer> n1 = l.buscar(5);
        NoListaDuplaCircular<Integer> n2 = l.buscar(10);
        NoListaDuplaCircular<Integer> n3 = l.buscar(15);
        NoListaDuplaCircular<Integer> n4 = l.buscar(20);
        l.liberar();
        assertNull(n1.getAnterior());
        assertNull(n1.getProximo());
        assertNull(n2.getAnterior());
        assertNull(n2.getProximo());
        assertNull(n3.getAnterior());
        assertNull(n3.getProximo());
        assertNull(n4.getAnterior());
        assertNull(n4.getProximo());
        l.inserir(1);
        assertEquals((Integer) 1, l.getPrimeiro().getInfo());
    }
}