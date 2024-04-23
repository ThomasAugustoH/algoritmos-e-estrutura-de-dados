package L06Filas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaVetorTest {

    @Before
    public void setUp() throws Exception {
    }


    //Conferir se o método estaVazia() reconhece fila vazia.
    @Test
    public void test01() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        assertTrue(fila.estaVazia());
    }

    // Conferir se o método estaVazia() reconhece fila não vazia.
    @Test
    public void test02() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    // Conferir se os dados são enfileirados e desenfilerados corretamente
    @Test
    public void test03() {
        FilaVetor<Integer> fila = new FilaVetor(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals((Integer) 10, fila.retirar());
        assertEquals((Integer) 20, fila.retirar());
        assertEquals((Integer) 30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    // Conferir se a exceção FilaCheiaException é lançada ao tentar exceder a capacidade da fila.
    @Test(expected = FilaCheiaException.class)
    public void test04() {
        FilaVetor<Integer> fila = new FilaVetor(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
    }

    // Conferir se a exceção FilaVaziaException é lançada ao tentar desenfileirar dados de uma fila vazia.
    @Test(expected = FilaVaziaException.class)
    public void test05() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        fila.retirar();
    }

    // Conferir se o método peek() retorna o início da fila
    @Test
    public void test06() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals((Integer) 10, fila.peek());
        assertEquals((Integer) 10, fila.retirar());
    }

    // Conferir se o método liberar() remove os elementos da fila
    @Test
    public void test07() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }

    // Conferir a concatenação de filas
    @Test
    public void test08() {
        FilaVetor<Integer> fila = new FilaVetor(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        FilaVetor<Integer> fila2 = new FilaVetor(3);
        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> fila3 = fila.criarFilaConcatenada(fila2);

        assertEquals("10,20,30,40,50", fila3.toString());
        assertEquals("10,20,30", fila.toString());
        assertEquals("40,50", fila2.toString());
        assertEquals((Integer) 8, (Integer) fila3.getLimite());
    }
}