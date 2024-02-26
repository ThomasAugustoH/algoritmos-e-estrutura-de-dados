package Lista01;

import org.junit.*;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class ListaEstaticaTest {
    private ListaEstatica l;

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
        l = new ListaEstatica();
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01() {
        assertEquals("5,10,15,20", l.toString());
    }

    @Test
    public void test02() {
        assertEquals(4, l.getTamanho());
    }

    @Test
    public void test03() {
        assertEquals(2, l.buscar(15));
    }

    @Test
    public void test04() {
        assertEquals(-1, l.buscar(30));
    }

    @Test
    public void test05() {
        l.retirar(10);
        assertEquals("5,15,20", l.toString());
        assertEquals(3, l.getTamanho());
    }

    @Test
    public void test06() {
        l.liberar();
        for (int i = 1; i < 16; i++) {
            l.inserir(i);
        }
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", l.toString());
        assertEquals(15, l.getTamanho());
    }

    @Test
    public void test07() {
        assertEquals(20, l.obterElemento(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test08() {
        l.obterElemento(5);
    }

    @Test
    public void test09() {
        l.liberar();
        assertEquals(true, l.estaVazia());
    }
}