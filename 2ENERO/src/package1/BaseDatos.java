package package1;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

	public class BaseDatos {
		public static void mostrarLista(ArrayList<Empleados>lemp){
			for(Empleados emp: lemp){
				System.out.println("Empleado: "+emp.getNombre()+"          Salario: "+ emp.getSalario()+"          Departamento: "+emp.getN_dpto());
			}
		}
		public static void main(String[] args) throws Exception {
			
			
			Connection conn = null;
			ResultSet rset = null;
			Statement stmt = null;
			ArrayList<Empleados> lista_empleados = null;
			
			
			lista_empleados = new ArrayList<Empleados>(); //me guarda espacios con el tamaño de Empleado (que contiene 4 tipos de datos)
			
//			Empleado empleado = new Empleado(3, "Juanjo", 27000, 5);
//			lista_empleados.add(empleado);
//			mostrarLista(lista_empleados);
			
			try
			{
				//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
				//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
				conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "password");
	  	       stmt = conn.createStatement();
	  	       
	  	       rset = stmt.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_DESC);//ascendente=ASC; descendente=DESC
//	  	   rset = stmt.executeQuery("SELECT department_name FROM departments WHERE department_id ="+e.getDpto()); //Sería otra forma de hacer la consulta de la linea de arriba   
	  	       while (rset.next()){
	  	    	   Empleados empleado1 = new Empleados(rset.getInt("EMPLOYEE_ID"), rset.getString("FIRST_NAME"), rset.getInt("SALARY"), rset.getInt("DEPARTMENT_ID"), rset.getString("DEPARTMENT_NAME"));
	  	    	   
	  	    	   lista_empleados.add(empleado1);
	/*			while (rset.next()){
//				        System.out.println (rset.getString(1));  
//				        System.out.println (rset.getString(2));
				        String nombre = rset.getString("FIRST_NAME");
				        Integer id = rset.getInt(1);
				        System.out.println("Nombre = "+nombre+" ID = "+id);
	*/
	  	    	 }
	  	     mostrarLista(lista_empleados);
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

		}
	}
		
		
		