package jjj;

import java.io.File;

public class ArchivoConA {
	public static void main (String [] args){
		File file =null;
		file = new File(".");
		int encontrado =0;
		
		String[] ficheros=null;
		ficheros= file.list();
		for (int i=0; i<ficheros.length; i++){
			for(int j=0; j<ficheros[i].length(); j++){
				boolean encon=false;
				if(ficheros[i].charAt(j)=='a'&& !encon){
					System.out.println(ficheros[i]);
					encontrado++;
					encon=true;
					
				}
			}
		}
	}

}
