package Lista01;

import org.junit.*;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class ListaEstaticaTest {

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class ListaEstatica.
     */
    @Test
    public void test01() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);

        assertEquals("5,10,15,20", l.toString());
    }

    @Test
    public void test02() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);

        assertEquals(4, l.getTamanho());
    }

    @Test
    public void test03() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);

        assertEquals(2, l.buscar(15));
    }

    @Test
    public void test04() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);

        assertEquals(-1, l.buscar(30));
    }

    @Test
    public void test05() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(10);

        assertEquals("5,15,20", l.toString());
        assertEquals(3, l.getTamanho());
    }

    @Test
    public void test06() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(1);
        l.inserir(2);
        l.inserir(3);
        l.inserir(4);
        l.inserir(5);
        l.inserir(6);
        l.inserir(7);
        l.inserir(8);
        l.inserir(9);
        l.inserir(10);
        l.inserir(11);
        l.inserir(12);
        l.inserir(13);
        l.inserir(14);
        l.inserir(15);

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", l.toString());
        assertEquals(15, l.getTamanho());
    }

    @Test
    public void test07() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);

        assertEquals(20, l.obterElemento(3));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void test08() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.obterElemento(5);
    }

    @Test
    public void test09() {
        ListaEstatica l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.liberar();

        assertEquals(true, l.estaVazia());
    }
}