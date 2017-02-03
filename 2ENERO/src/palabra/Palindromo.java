package palabra;

import java.util.Scanner;

public class Palindromo {
	

	public static void main(String[] args)
	{
		String palabra= null;
		Scanner scaner = new Scanner (System.in);
		System.out.println("Introduzca una palabra");
		palabra= scaner.next();
		if (comprobarPalindromo(palabra))
		{
			System.out.println("Es palindromo");
		}
		else {
			System.out.println("No es palindromo");
		}
	}
	
	
	public static boolean comprobarPalindromo (String palabra)
	{
		boolean palindroma = true;
		int inicio = 0;
		int fin = palabra.length()-1;
		while (palindroma && inicio <= fin) 
		{
			if(palabra.charAt(inicio)!=palabra.charAt(fin)){
				palindroma = false;
			}
			inicio++;
			fin--;
		}
		
		return palindroma; 
	}

}
