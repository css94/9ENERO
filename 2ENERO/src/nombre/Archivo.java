package nombre;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
	public static void main(String []args){
		File file=null;
		Scanner sc=null;
		System.out.println("Introduce el nombre del archivo");
		sc=new Scanner(System.in);
		String name = sc.nextLine();
		file=new File(".", name);
		crearFichero(file);
		borrarFichero(file);
		
		
		
	}
	public static void crearFichero(File file){
		try {
			if(file.createNewFile()){
				System.out.println("Se ha creado");
				
			}
			else{
				System.out.println("No creado");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	public static void borrarFichero(File file){
		if(file.delete());{
			System.out.println("Se ha borrado");
		}
		
	
}


}

