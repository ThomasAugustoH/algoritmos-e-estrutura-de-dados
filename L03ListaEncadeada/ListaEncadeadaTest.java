package L03ListaEncadeada;

import org.junit.*;

import static org.junit.Assert.*;

public class ListaEncadeadaTest {
    private ListaEncadeada<Integer> l;

    @Before
    public void setUp() throws Exception {
        l = new ListaEncadeada<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
        Verificar se é reconhecida lista vazia
     */
    @Test
    public void Test01() {
        assertTrue(l.estaVazia());
    }

    /*
        Verificar se é reconhecida lista não vazia
     */
    @Test
    public void Test02() {
        l.inserir(5);
        assertFalse(l.estaVazia());
    }

    /*
        Validar inclusão de um número
     */
    @Test
    public void Test03() {
        l.inserir(5);
        NoLista<Integer> p = new NoLista<Integer>();
        assertEquals(p.getClass(), l.getPrimeiro().getClass());
        assertEquals((Integer) 5, l.getPrimeiro().getInfo());
        assertNull(l.getPrimeiro().getProximo());
    }

    /*
        Validar inclusão de 3 números
     */
    @Test
    public void Test04() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        assertEquals("15,10,5", l.toString());
        assertEquals(3, l.obterComprimento());
    }

    /*
        Validar busca de dados na lista na primeira posição
     */
    @Test
    public void Test05() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 20, l.buscar(20).getInfo());
    }

    /*
        Validar busca de dados no meio da lista
     */
    @Test
    public void Test06() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 15, l.buscar(15).getInfo());
    }

    /*
        Validar busca de dado inexistente
     */
    @Test
    public void Test07() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertNull(l.buscar(50));
    }

    /*
        Validar exclusão de primeiro elemento da lista
     */
    @Test
    public void Test08() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(20);
        assertEquals("15,10,5", l.toString());
    }

    /*
        Validar exclusão de elemento do meio da lista
     */
    @Test
    public void Test09() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.retirar(15);
        assertEquals("20,10,5", l.toString());
    }

    /*
        Validar que obterNo() retorna nó da posição 0
     */
    @Test
    public void Test10() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 20, l.obterNo(0).getInfo());
    }

    /*
        Validar que obterNo() retorna nó da última posição
     */
    @Test
    public void Test11() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals((Integer) 5, l.obterNo(3).getInfo());
    }

    /*
        Validar que obterNo() recusa tentativa de ler posição invalidade nó
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void Test12() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        l.obterNo(10);
    }

    /*
        Validar método obterComprimento() para lista vazia
     */

    @Test
    public void Test13() {
        assertEquals(0, l.obterComprimento());
    }

    /*
        Validar método obterComprimento() para lista não vazia.
     */
    @Test
    public void Test14() {
        l.inserir(5);
        l.inserir(10);
        l.inserir(15);
        l.inserir(20);
        assertEquals(4, l.obterComprimento());
    }

}