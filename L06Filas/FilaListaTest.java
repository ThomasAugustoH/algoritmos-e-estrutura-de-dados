package L06Filas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaListaTest {
    private FilaLista<Integer> fila;
    @Before
    public void setUp() throws Exception {
        fila = new FilaLista<>();
    }

    // Conferir se o método estaVazia() reconhece fila vazia.
    @Test
    public void test01(){
        assertTrue(fila.estaVazia());
    }

    // Conferir se o método estaVazia() reconhece fila não vazia.
    @Test
    public void test02(){
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    // Conferir se os dados são enfileirados e desenfileirados corretamente
    @Test
    public void test03(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals((Integer) 10, fila.retirar());
        assertEquals((Integer) 20, fila.retirar());
        assertEquals((Integer) 30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    // Conferir se o método peek() retorna o início da fila
    @Test
    public void test04(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals((Integer) 10, fila.peek());
        assertEquals((Integer) 10, fila.retirar());
    }

    // Conferir se o método liberar() remove os elementos da fila
    @Test
    public void test05(){
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();

        assertTrue(fila.estaVazia());
    }
}