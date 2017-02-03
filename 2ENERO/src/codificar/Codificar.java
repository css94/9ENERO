package codificar;

public class Codificar {

	public static void main(String[] args) {
		String palabra= "Hola";
		String codificada=codifica(palabra);
		System.out.println(codificada);
		System.out.println(descodifica(codificada));

	}

	public static String codifica(String cadena){
		
		String codificada="";
		char palabra=0;
		int longi= cadena.length();
		char caracter_actual = 0;
		int numero_caracter = 0;
		char caracter_cifrado = 0;
		for (int pos = 0; pos < longi; pos++)
		{
			caracter_actual = cadena.charAt(pos);
			numero_caracter = (int)caracter_actual;
			numero_caracter = numero_caracter +1;
			caracter_cifrado = (char)numero_caracter;
			codificada = codificada + caracter_cifrado;
			}
		
		
	
		return codificada;
}
	
public static String descodifica(String cadena){
		
		String decodificada="";
		char palabra=0;
		int longi= cadena.length();
		char caracter_actual = 0;
		int numero_caracter = 0;
		char caracter_cifrado = 0;
		for (int pos = 0; pos < longi; pos++)
		{
			caracter_actual = cadena.charAt(pos);
			numero_caracter = (int)caracter_actual;
			numero_caracter = numero_caracter -1;
			caracter_cifrado = (char)numero_caracter;
			decodificada = decodificada + caracter_cifrado;
			}
		
		
	
		return decodificada;
}
}
