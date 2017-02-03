package excepciones;

import java.io.File;
import java.io.FileReader;

public class CheckedVsUnchecked {

	public static void main(String[] args) {
		
		String cadena=null;
		int ae[]=new int[4];
		try  {
			int longi=ae.length;
			ae[ae.length]=3;
			System.out.println(longi);
		
		}catch (Exception e)
		{
			System.out.println("EXCEPCIÓN PRODUCIDA");
			e.printStackTrace();
		}
	
	}
		

}
