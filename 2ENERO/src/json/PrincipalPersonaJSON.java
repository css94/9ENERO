package json;

import com.google.gson.Gson;

public class PrincipalPersonaJSON {
	public static void main(String[] args){
		Gson gson= new Gson();
		Persona p= new Persona("Mikel ", false,false,4);
		
		String jsonpersona = gson.toJson(p);
		System.out.println(jsonpersona);
		
		Persona p2=gson.fromJson(jsonpersona, Persona.class);
		System.out.println("Nhijos =" +p2.getN_hijos());
		System.out.println("Nombre =" +p2.getNombre());
		System.out.println("Nombre =" +p2.isCasada());
		System.out.println("Nombre =" +p2.isParado());
		
	}
}
