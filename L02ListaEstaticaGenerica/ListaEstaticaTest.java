package L02ListaEstaticaGenerica;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListaEstaticaTest {
    private ListaEstatica<Integer> l;

    public ListaEstaticaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        l = new L02ListaEstaticaGenerica.ListaEstatica<>();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void Test01() {
        assertEquals("5,10,15,20", l.toString());
    }

    @Test
    public void Test02() {
        assertEquals(4, l.getTamanho());
    }

    @Test
    public void Test03() {
        assertEquals(2, l.buscar(15));
    }

    @Test
    public void Test04() {
        assertEquals(-1, l.buscar(30));
    }

    @Test
    public void Test05() {
        l.retirar(10);
        assertEquals("5,15,20", l.toString());
        assertEquals(3, l.getTamanho());
    }

    @Test
    public void Test06() {
        l.liberar();
        for (int i = 1; i < 16; i++) {
            l.inserir(i);
        }
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", l.toString());
        assertEquals(15, l.getTamanho());
    }

    @Test
    public void Test07() {
        assertEquals(20, (int) l.obterElemento(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Test08() {
        l.obterElemento(5);
    }

    @Test
    public void Test09() {
        l.liberar();
        assertTrue(l.estaVazia());
    }

    @Test
    public void Test10() {
        l.inverter();
        assertEquals("20,15,10,5", l.toString());
    }

    @Test
    public void Test11() {
        l.inserir(25);
        l.inverter();
        assertEquals("25,20,15,10,5", l.toString());
    }
}