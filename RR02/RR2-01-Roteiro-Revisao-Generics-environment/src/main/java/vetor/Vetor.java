package vetor;

import java.util.Comparator;

import javax.management.RuntimeErrorException;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = 0;
		this.arrayInterno = new Object[tamanho];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		if(isCheio()){
			throw new RuntimeException("erro");
		}
		arrayInterno[indice] = o;
		indice++;
	}

	// Remove um objeto do vetor
	public Object remover(T o) {
		if(isVazio()){
			throw new RuntimeException("erro");
		}
		arrayInterno[(Integer) procurar(o)] = null;
		return o;
	}

	// Procura um elemento no vetor
	public Object procurar(T o) {
		Integer result = 0;
		if(isVazio()){
			throw new RuntimeException("erro");
		}
		for(int i = 0; i < arrayInterno.length; i++){
			if(o.equals(arrayInterno[i])){
				result = i;
			}
		}
		return result;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		for(Object o : arrayInterno){
			if(o != null){
				return false;
			}
		}
		return true;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		for(Object o : arrayInterno){
			if(o == null){
				return false;
			}
		}
		return true;
	}
}
