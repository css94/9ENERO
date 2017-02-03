package registro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registrar_Acceder {

	public static void main(String[] args) {
		int option=-1;
		Scanner sc=null;
		sc=new Scanner (System.in);
		while(option!=3){
			System.out.println("Choose an option");
			System.out.print("1.Sign Up\n2.Sign In\npress 3 to Exit\n ");
			option=sc.nextInt();
			
		switch(option){
			case 1:
				//registrarse
				Registro();
				break;
			case 2:
				//acceder
				Acceso();
				break;
		}
		}
		
			
		}
		public static void Registro(){
			String usuario=null;
			String contrasenia=null;
			Scanner sc=null;
			File file_usuario=new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Ususario.txt");
			File file_contrasenia=new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Contrasenia.txt");
			sc=new Scanner(System.in);
			System.out.println("Enter User");
			usuario=sc.next();
		if(!Exists(usuario)){
			
			if(CreateUser(usuario, file_usuario))
			{
			//ver si existe y crear usuario
			System.out.println("Enter Password");
			contrasenia=sc.next();
			contrasenia =Codificar(contrasenia);
			if(CreateUser(contrasenia, file_contrasenia)){
				System.out.println("User created correctly");
			}
			}
			
		}else{
			System.out.println("Used user");
		}
		
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
		public static String Codificar(String passw){
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
		
		public static void Acceso(){
			String usere=null;
			String contras=null;
			Scanner sc=null;
			File file_usuario=new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Ususario.txt");
			File file_contrasenia=new File("C:\\Users\\Alumno\\workspace\\9ENERO\\Contrasenia.txt");
			sc=new Scanner(System.in);
			System.out.println("Enter User");
			usere=sc.next();
		if(!Exists(usere)){
			
			if(CreateUser(usere, file_usuario))
			{
			//ver si existe y crear usuario
			System.out.println("Enter Password");
			contras=sc.next();
			contras =Codificar(contras);
			if(CreateUser(contras, file_contrasenia)){
				System.out.println("User created correctly");
			}
			}
			
		}else{
			System.out.println("Used user");
		}
		
		}
		}

		


	


