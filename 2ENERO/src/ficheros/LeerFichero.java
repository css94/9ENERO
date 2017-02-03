package ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

	public static void main(String[] args)throws IOException {
		
		File archivo= new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Carpeta\\shhh.txt");
		FileReader filereader= new FileReader(archivo);
		int i =0;
		int charAux;
		int suma=0;
		while(i!=-1){
			 charAux= filereader.read();
			i=charAux;
			char aux= (char)charAux;
			suma= suma+i;
			System.out.print(aux);
			
			
			
		}
		System.out.println("la suma es "+suma);
		filereader.close();
	}
	
		
}
