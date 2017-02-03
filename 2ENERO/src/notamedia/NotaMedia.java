package notamedia;
import java.util.Scanner;
public class NotaMedia {
	public static void main(String[] args) {
		int sum=0;
		int inputNum;
		int contador;
		float significado;
		Scanner NumSc= new Scanner(System.in);
		Scanner charSc= new Scanner(System.in);
		
		System.out.println("Dime el numero total que quieres");
		
		contador= NumSc.nextInt();
		
		System.out.println(" dime " + contador + " numeros: ");
		
		for(int z =1; z<= contador; z++){
			inputNum = NumSc.nextInt();
	          sum = sum + inputNum;
	          System.out.println();
		}
	
		significado = sum / contador;
	      System.out.println("La media de " + contador + " los números que ingresaste es" + significado);

}

	
	
}
