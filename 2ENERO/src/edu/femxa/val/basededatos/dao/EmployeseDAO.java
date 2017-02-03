package edu.femxa.val.basededatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeseDAO {
	
	public List<EmployeesDTO> consultaAllEmpleados(String departamento)
	{
	
	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	List<EmployeesDTO> lista_empleados = null;
	
	lista_empleados = new ArrayList<EmployeesDTO>();
	try
	{
		//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
		//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
		conn = DriverManager.getConnection ("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "password");
	        stmt = conn.createStatement();
		rset = stmt.executeQuery(Consultas.CONSULTA_EMPLOYEES_DEPARTMENT_ID+ departamento);
		String nombre = null;
		Integer id = null;
		while (rset.next())
			
		    {
				  
				nombre = rset.getString("FIRST_NAME");
				id = rset.getInt("EMPLOYEE_ID");
				System.out.println("Nombre = "+nombre + " ID = " +id);
			 }
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	   
	}
	return lista_empleados;   

}
	}


