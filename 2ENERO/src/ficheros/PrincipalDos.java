package ficheros;

import java.io.File;

public class PrincipalDos {

	public static void main(String[] args) {
		File file =null;
		file = new File(" . ");
		
		String[] ficheros=null;
		File[] lista=null;
		lista =new File (".").listFiles();
		ficheros =file.list();
		for (int i=0; i<ficheros.length; i++){
			if(lista[i].isHidden()){
				System.out.println(lista[i]+ "Es oculta");
			}
			else{
				System.out.println(lista[i]+ "No es oculta");
			
		}
		
	}

	}
}
