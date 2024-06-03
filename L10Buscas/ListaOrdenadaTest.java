package L10Buscas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaOrdenadaTest {

    ListaOrdenada<Integer> lo = new ListaOrdenada<>();

    @Before
    public void setUp() throws Exception {
        lo.inserir(0);
        lo.inserir(10);
        lo.inserir(20);
        lo.inserir(30);
        lo.inserir(40);
        lo.inserir(50);
        lo.inserir(60);
        lo.inserir(70);
        lo.inserir(80);
        lo.inserir(90);
        lo.inserir(100);
    }

    /*
        Conferir se o método inserir() mantém os dados ordenados
     */
    @Test
    public void TestManterOrdenado() {
        ListaOrdenada<Integer> lo1 = new ListaOrdenada<>();
        lo1.inserir(100);
        lo1.inserir(20);
        lo1.inserir(70);
        lo1.inserir(1);

        assertEquals("1,20,70,100", lo1.toString());
    }

    /*
        Conferir que o método buscar() localiza um dado armazenado
     */
    @Test
    public void TestBuscar01() {
        assertEquals(2, lo.buscar(20));
    }

    /*
        Conferir que o método buscar() localiza um dado armazenado
     */
    @Test
    public void TestBuscar02() {
        assertEquals(4, lo.buscar(40));
    }

    /*
        Conferir que o método buscar() localiza um dado armazenado
     */
    @Test
    public void TestBuscar03() {
        assertEquals(7, lo.buscar(70));
    }

    /*
        Conferir que o método buscar() localiza um dado armazenado
     */
    @Test
    public void TestBuscar04() {
        assertEquals(10, lo.buscar(100));
    }

    /*
        Conferir que o método buscar() localiza um dado armazenado
     */
    @Test
    public void TestBuscar05() {
        assertEquals(-1, lo.buscar(85));
    }
}