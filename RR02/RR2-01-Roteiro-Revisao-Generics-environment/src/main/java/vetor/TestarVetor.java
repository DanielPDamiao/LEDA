package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);
		// ComparadorMaximo compMax = new ComparadorMaximo();
		// vetor.setComparadorMaximo(compMax);
		// ComparadorMinimo compMin = new ComparadorMinimo();
		// vetor.setComparadorMinimo(compMin);
		Aluno daniel = new Aluno("Daniel", 2);
		vetor.inserir(daniel);
		System.out.println(vetor.procurar(daniel));
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
	}
}
