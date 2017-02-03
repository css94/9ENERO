package registro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.AbstractDocument.BranchElement;

public class UsersAndPassword {
	public static boolean Exists(String User)
	{
		boolean exists=true;
		String yaTa=null;
		FileReader filereader=null;
		BufferedReader br= null;
		
		try{
		 filereader=new FileReader("C:\\Users\\Alumno\\workspace\\9ENERO\\Ususario.txt");
		 br= new BufferedReader(filereader);
		while(br.ready())
				{
			yaTa=br.readLine();
			if(yaTa ==User)
			{
				exists=true;
			}
		}
		
	}
		catch(FileNotFoundException e){
			System.out.println("Error creating the user");
			e.printStackTrace();
		}
		catch (IOException io){
			System.out.println("Error creating the user");
		}
		finally
		{
			try{
				br.close();
				filereader.close();
				
			}catch(Exception e){
				System.out.println("Error liberate resource");
			}
		}
		return exists;
	}
public static boolean CreateUser(String word, File file){
	boolean nuevo=false;
	FileWriter fw= null;
	BufferedWriter bw=null;
	
	try
	{
		fw=new FileWriter(file,true);
		bw=new BufferedWriter(fw);
		bw.newLine();
		bw.write(word);
		nuevo=true;
	}
	catch(IOException e){
		System.out.println("Error created Fw");
		e.printStackTrace();
		nuevo=false;
	}
	finally
	{
		try{
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error closing users/password");
			e.printStackTrace();
			nuevo=false;
		}
	}
	return nuevo;
}
public String Cifrado(String passw){
	String codificada="";
	char palabra=0;
	int longi= passw.length();
	char caracter_actual = 0;
	int numero_caracter = 0;
	char caracter_cifrado = 0;
	for (int pos = 0; pos < longi; pos++)
	{
		caracter_actual = passw.charAt(pos);
		numero_caracter = (int)caracter_actual;
		numero_caracter = numero_caracter +1;
		caracter_cifrado = (char)numero_caracter;
		codificada = codificada + caracter_cifrado;
		}
	
	return codificada;
	
}
 }

