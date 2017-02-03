package edu.femxa.val.ejernavi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		ListaPersonas lista= new ListaPersonas();//crear el objeto de listaPersonas que contiene la clase PErsona
		String name;
		int age;
		Persona persona= null;
		Scanner scaner= new Scanner(System.in); 
		for (int i=0;i<2;i++ )
		{
		System.out.println("Nombre");
		name=scaner.next();
		System.out.println("Edad");
		age=scaner.nextInt();
		persona= new Persona(name,age );
		lista.insertarPersona(persona);
	
		}
		lista.listarPersonas();

	}

}
