package dni;

import java.util.Scanner;

public class CalcularLetraDni {
	public static String caracteresDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static void main(String[] args) {
		Scanner numero=null;
		int dni=0;
		
		System.out.println("Donnez-moi votre carte d´identité");
		numero=new Scanner(System.in);
		dni=numero.nextInt();
		
			dni=dni%23;
			char letra = caracteresDNI.charAt(dni);
			System.out.println(letra);
	}

}
