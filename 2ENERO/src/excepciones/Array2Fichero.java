package excepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Array2Fichero {
	public static String[] fromFichero2Array(File file) throws IOException
	{
		String[] lista_cadena= new String[5];
		int contador=0;
		FileReader filetereader=new FileReader(file);
		BufferedReader br= new BufferedReader(filetereader);
		while(br.ready())
		{
			lista_cadena[contador]=br.readLine();
			System.out.println(lista_cadena[contador]);
			contador++;
			
		}
		br.close();
		filetereader.close();
		return lista_cadena;
	}
		
	
	public static boolean fromArray2Fichero(String []lista_cadena) throws IOException
	{
		FileWriter filetewriter= new FileWriter("C:\\Users\\Alumno\\workspace\\9ENERO\\Carpeta\\fich2.txt");
		BufferedWriter bw= new BufferedWriter(filetewriter);
		boolean ok=true;
		for(int i =0; i<lista_cadena.length; i++){
			
				bw.write(lista_cadena[i]);
				bw.newLine();
	//			System.out.println(lista_cadena[i]);
				ok=false;
			
		}
		bw.close();
		filetewriter.close();
		return ok;
	}

	public static void main(String []args){
		try {
			File file = new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Carpeta\\fichero.txt");
			String [] lista= fromFichero2Array(file);
			fromArray2Fichero(lista);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
