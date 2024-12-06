package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		
		MetodosRecursivos metR = new MetodosRecursivos();

		metR.calcularFatorial(6);
		
		System.out.println("");

		metR.calcularFibonacci(4);

		System.out.println("");

		Object[] array = {1, null, 1, 1, null, null, 1, 1};
		
		System.out.println("");
		
		metR.countNotNull(array);

		System.out.println("");

		System.out.println(metR.potenciaDe2(0));

		System.out.println("");

		System.out.println(metR.progressaoAritmetica(1, 2, 4));
		
		System.out.println("");

		System.out.println(metR.progressaoGeometrica(1, 2, 4));
	}
}
