package edu.femxa.val.basededatos.dao;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Propiedades
{
	public static void main(String[]args) throws IOException
	{
		Properties fichero_propiedades=null;
		fichero_propiedades = new Properties();
		
		FileReader fr = new FileReader("db.propierties");
		fichero_propiedades.load(fr);
		String vd = fichero_propiedades.getProperty("driver"); 
		String cadena_conexion=fichero_propiedades.getProperty("cadena_conexion");
		String usuario=fichero_propiedades.getProperty("user");
		String contraseņa=fichero_propiedades.getProperty("password");
		System.out.println(vd);
		System.out.println(cadena_conexion);
		System.out.println(usuario);
		System.out.println(contraseņa);
		fichero_propiedades.setProperty(contraseņa, "me voy");
		System.out.println(contraseņa+" "+usuario);
		
		fr.close();
	}
}