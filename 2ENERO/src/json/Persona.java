package json;

public class Persona {
	private String nombre;
	private boolean casada;
	private boolean parado;
	private int n_hijos;
	
	public Persona(String nombre, boolean casada, boolean parado, int n_hijos) {
		super();
		this.nombre = nombre;
		this.casada = casada;
		this.parado = parado;
		this.n_hijos = n_hijos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCasada() {
		return casada;
	}
	public void setCasada(boolean casada) {
		this.casada = casada;
	}
	public boolean isParado() {
		return parado;
	}
	public void setParado(boolean parado) {
		this.parado = parado;
	}
	public int getN_hijos() {
		return n_hijos;
	}
	public void setN_hijos(int n_hijos) {
		this.n_hijos = n_hijos;
	}
	
	
	

}
