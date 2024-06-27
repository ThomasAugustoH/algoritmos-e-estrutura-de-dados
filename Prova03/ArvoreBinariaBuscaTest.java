package Prova03;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTest {

    ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

    @Test
    public void obterMenorValor() {
        assertNull(arvore.obterMenorValor());
    }
}