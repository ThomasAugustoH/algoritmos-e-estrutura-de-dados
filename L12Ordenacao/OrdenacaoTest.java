package L12Ordenacao;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrdenacaoTest {

    /*
        Validar algoritmo de ordenação Bolha
     */
    @Test
    public void testeBolha() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};

        OrdenacaoBolha<Integer> ordenacaoBolha = new OrdenacaoBolha<>();
        ordenacaoBolha.setInfo(vetor);

        ordenacaoBolha.ordenar();

        assertEquals((Integer) 2, vetor[0]);
        assertEquals((Integer) 15, vetor[1]);
        assertEquals((Integer) 30, vetor[2]);
        assertEquals((Integer) 70, vetor[3]);
        assertEquals((Integer) 88, vetor[4]);
        assertEquals((Integer) 90, vetor[5]);
    }

    /*
        Validar algoritmo de ordenação bolha otimizado
     */
    @Test
    public void testeBolhaOtimizada() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};

        OrdenacaoBolhaOtimizada<Integer> ordenacaoBolhaOtimizada = new OrdenacaoBolhaOtimizada<>();
        ordenacaoBolhaOtimizada.setInfo(vetor);

        ordenacaoBolhaOtimizada.ordenar();

        assertEquals((Integer) 2, vetor[0]);
        assertEquals((Integer) 15, vetor[1]);
        assertEquals((Integer) 30, vetor[2]);
        assertEquals((Integer) 70, vetor[3]);
        assertEquals((Integer) 88, vetor[4]);
        assertEquals((Integer) 90, vetor[5]);
    }

    /*
        Validar algoritmo de ordenação Quicksort
     */
    @Test
    public void testeQuickSort() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};

        OrdenacaoQuickSort<Integer> ordenacaoQuickSort = new OrdenacaoQuickSort<>();
        ordenacaoQuickSort.setInfo(vetor);

        ordenacaoQuickSort.ordenar();

        assertEquals((Integer) 2, vetor[0]);
        assertEquals((Integer) 15, vetor[1]);
        assertEquals((Integer) 30, vetor[2]);
        assertEquals((Integer) 70, vetor[3]);
        assertEquals((Integer) 88, vetor[4]);
        assertEquals((Integer) 90, vetor[5]);
    }

    /*
        Validar algoritmo de ordenação MergeSort
     */
    @Test
    public void testeMergeSort() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};

        OrdenacaoMergeSort<Integer> ordenacaoMergeSort = new OrdenacaoMergeSort<>();
        ordenacaoMergeSort.setInfo(vetor);

        ordenacaoMergeSort.ordenar();

        assertEquals((Integer) 2, vetor[0]);
        assertEquals((Integer) 15, vetor[1]);
        assertEquals((Integer) 30, vetor[2]);
        assertEquals((Integer) 70, vetor[3]);
        assertEquals((Integer) 88, vetor[4]);
        assertEquals((Integer) 90, vetor[5]);
    }
}