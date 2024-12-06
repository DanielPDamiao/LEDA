package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		if(n == 0){
			result *= 1;
		}
		else{
			result = n * calcularFatorial(n-1);
		}
		System.out.println(n + "! = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if(n == 1 || n == 2){
			result = 1;
		}
		else{
			int v1 = calcularFibonacci(n-1);
			int v2 = calcularFibonacci(n-2);
			result = v1 + v2;
		}
		System.out.print(result + ", ");
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNullCount(array, 0);
		System.out.println(result);
		return result;
	}

	private int countNotNullCount(Object[] array, int n){
		int contador = 0;
		if(n == array.length-1){
			contador = (array[n] != null) ? contador+1 : contador;
		}
		else{
			contador += countNotNullCount(array, n+1);
			contador = (array[n] != null) ? contador+1 : contador;
		}
		return contador;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente == 0){
			result *= 1;
		}
		else{
			result = 2 * potenciaDe2(expoente-1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		if(n == 1){
			result = termoInicial;
		}
		else{
			result = razao + progressaoAritmetica(termoInicial, razao, n-1);
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 0;
		if(n == 1){
			result = termoInicial;
		}
		else{
			result = razao * progressaoGeometrica(termoInicial, razao, n-1);
		}
		return result;
	}
	
	
}
