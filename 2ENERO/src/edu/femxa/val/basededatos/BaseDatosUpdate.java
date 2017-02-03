package edu.femxa.val.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Date;

public class BaseDatosUpdate {
	
	
	private static void liberarRecursos (Statement st, ResultSet rs)
	{
		
		if (rs != null) 	{ try { rs.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		
	}
	
	
	private static void liberarRecursos (Statement st, ResultSet rs, Connection conn)
	{
		
		if (rs != null) 	{ try { rs.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	
		
	}
	
	private static void liberarRecursos (Connection conn)
	{
		
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	  	
		
	}
	
	private static void subeSueldo (Connection conn)
	{
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
			st = conn.createStatement();
			st.execute(Consultas.ACTUALIZAR_EMPLEADOS_SALARIO_ADMON_E_IT);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			liberarRecursos(st, rs);
			
		}
	}
	
	private static void consultaEmpleados (Connection conn)
	{
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			st = conn.createStatement();
			rs = st.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_ADMON_E_IT);
			String nombre = null;
			Integer salario = 0;
			System.out.println("----------------------");
			System.out.println("INICIO DE MOSTRAR");
			System.out.println("----------------------");
			
			
			while (rs.next())
			    {
					nombre = rs.getString(1);
					salario = rs.getInt(2);
					System.out.println("Nombre = "+nombre + " || Salario = " +salario);
				 }
			System.out.println("----------------------");
			System.out.println("FIN DE MOSTRAR");
			System.out.println("----------------------");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			liberarRecursos(st, rs);
			
		}
			
	}
	
	
	public static void main(String[] args) throws Exception {

		Connection conn = null;
		Savepoint save=null;
	
		try{
		
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
			conn.setAutoCommit(false);
			consultaHistoricoAumentoSalario(conn);
			
			subeSueldo(conn);//UPDATE
			save=conn.setSavepoint();//SALVAR
			ejemploError(conn);
			conn.commit();
			
			
			
		} catch (Exception e) {
			conn.rollback(save);
			e.printStackTrace();
			System.out.println("Error ejecutando bd");
		
		} finally {
			liberarRecursos(conn);
		}
	}
public static void ejemploError(Connection conn) throws Exception {
	Statement st=null;
	ResultSet rs=null;
	try{
		st=conn.createStatement();
		rs=st.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_ADMON_E_IT);
		int error =0;
		while(rs.next())
		{
			error=rs.getInt(4);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
		finally{
			liberarRecursos(st,rs);
		}
	}


public static void consultaHistoricoAumentoSalario(Connection conn){
		
		Statement st = null;
		ResultSet rs = null;
		
		try{
			
			st = conn.createStatement();
			rs = st.executeQuery(Consultas.CONSULTA_AUMENTOS_EMPLEADOS_DIARIO );
			Integer id_usuario = 0;
			Integer salario_antiguo = 0;
			Integer salario_nuevo = 0;
			Date fecha = null;
			
			while (rs.next())
			    {
					id_usuario = rs.getInt(5);
					salario_antiguo = rs.getInt(2);
					salario_nuevo = rs.getInt(3);
					fecha = rs.getDate(4);
					System.out.println("ID = "+id_usuario + " salario antiguo = " +salario_antiguo 
							+ " salario nuevo = "+salario_nuevo + " fecha = "+ fecha);
				 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			liberarRecursos(st, rs);
			
		}
	}
}
