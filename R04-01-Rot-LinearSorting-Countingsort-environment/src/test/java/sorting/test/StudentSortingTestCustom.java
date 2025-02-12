package sorting.test;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTestCustom {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorValoresNegativo;
	private Integer[] vetorValoresMisto;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorNegativo(new Integer[] { -5, -6, -2, -7, -1, -9, -2});
		populavetorMisto(new Integer[] { -4, 6, -1, 2, -6, 7, -4, 6});

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new ExtendedCountingSort();
		// Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorNegativo(Integer[] arrayPadrao) {
		this.vetorValoresNegativo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populavetorMisto(Integer[] arrayPadrao) {
		this.vetorValoresMisto = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

    public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
    
    public void genericTest(Integer[] array, int leftIndex, int rightIndex) {
        Integer[] copy1 = {};
        if(array.length > 0){
            copy1 = Arrays.copyOf(array, array.length);
        }
        implementation.sort(array, leftIndex, rightIndex);
        Arrays.sort(copy1, leftIndex, rightIndex + 1);
        Assert.assertArrayEquals(copy1, array);
    }

    @Test
    public void testSort07() {
        genericTest(vetorTamPar, 2, 2);
    }

    @Test
    public void testSort08() {
        genericTest(vetorTamPar, 0, 1);
    }

    @Test
    public void testSort09() {
        genericTest(vetorTamPar, 0, 2);
    }

    @Test
    public void testSort10() {
        genericTest(vetorTamImpar, 0, 1);
    }

    @Test
    public void testSort11() {
        genericTest(vetorTamImpar, 0, 2);
    }

    @Test
    public void testSort12() {
        genericTest(vetorValoresIguais, 0, 1);
    }

    @Test
    public void testSort13() {
        genericTest(vetorValoresIguais, 0, 2);
    }

    @Test
    public void testSort14() {
        genericTest(vetorValoresRepetidos, 0, 1);
    }

    @Test
    public void testSort15() {
        genericTest(vetorValoresRepetidos, 0, 2);
    }

    @Test
    public void testSort15_2() {
        genericTest(vetorValoresRepetidos, 2, 6);
    }

    @Test
    public void testSort16() {
        Integer[] array = new Integer[] {7, 6, 5, 4, 3, 2, 1, 0};
        implementation.sort(array, 0, 99);
        Integer[] copy = Arrays.copyOf(array, array.length);
        Assert.assertArrayEquals(copy, array);
    }

    @Test
    public void testSort17() {
        Integer[] array = new Integer[] {7, 6, 5, 4, 3, 2, 1, 0};
        genericTest(array);
    }

    @Test
    public void testSort18() {
        genericTest(vetorValoresNegativo);
    }

    @Test
    public void testSort19() {
        genericTest(vetorValoresNegativo, 0, 2);
    }

    @Test
    public void testSort20() {
        genericTest(vetorValoresNegativo, 0, 1);
    }

    @Test
    public void testSort21() {
        genericTest(vetorValoresNegativo, 0, 4);
    }

    @Test
    public void testSort22() {
        genericTest(vetorValoresNegativo, 2, 4);
    }
}
