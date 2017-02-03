package pacakage2;

public class CalcularArgumentos {

	public static void main(String[] args) {
		String palabragrande = "";
		int contador=0;
		for(String palabra: args)
		{
			if(palabragrande.length()<palabra.length())
			{
				palabragrande=palabra;
			}
			contador++;
		}
		System.out.println("palabra grande: "+palabragrande);
		System.out.println("cantidad de argumentos:" +contador);
	}

}
