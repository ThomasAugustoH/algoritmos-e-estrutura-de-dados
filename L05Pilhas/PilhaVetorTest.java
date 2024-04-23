package L05Pilhas;

import org.junit.*;

import static org.junit.Assert.*;

public class PilhaVetorTest {
    
    @Before
    public void setUp() throws Exception {
    }

    /*
        Conferir se o método estaVazia() reconhece pilha vazia
     */
    @Test
    public void Test01() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        assertTrue(pilha.estaVazia());
    }

    /*
        Conferir se o método estaVazia() reconhece pilha não vazia.
     */
    @Test
    public void Test02() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    /*
        Conferir se os dados são empilhados e desempilhados corretamente.
     */
    @Test
    public void Test03() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals((Integer) 30, pilha.pop());
        assertEquals((Integer) 20, pilha.pop());
        assertEquals((Integer) 10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    /*
        Conferir se a exceção PilhaCheiaException é lançada ao tentar exceder a capacidade da pilha.
     */
    @Test(expected = PilhaCheiaException.class)
    public void Test04() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
    }

    /*
        Conferir se a exceção PilhaVaziaException é lançada ao tentar desempilhar dados de uma pilha vazia.
     */
    @Test(expected = PilhaVaziaException.class)
    public void Test05() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.pop();
    }

    /*
        Conferir se o método peek() retorna o topo da pilha.
     */
    @Test
    public void Test06() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals((Integer) 30, pilha.peek());
        assertEquals((Integer) 30, pilha.pop());
    }

    /*
        Conferir se o método liberar() remove os elementos da pilha
     */
    @Test
    public void Test07() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

    /*
        Conferir a concatenação de pilhas
     */
    @Test
    public void Test08() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        PilhaVetor<Integer> pilhaNova = new PilhaVetor<>(5);
        pilhaNova.push(40);
        pilhaNova.push(50);
        pilha.concatenar(pilhaNova);
        assertEquals("50,40,30,20,10", pilha.toString());
    }
}