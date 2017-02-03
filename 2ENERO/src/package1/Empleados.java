package package1;


public class Empleados {
	private int id;
	private String nombre;
	private int salario;
	private int dpto;
	private String n_dpto;
	

	//Constructors (click derecho->Source->Generate Constructor)
	public Empleados(int id, String nombre, int salario, int dpto, String n_dpto) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.dpto = dpto;
		this.n_dpto = n_dpto;
	}
	
	//Getters and setters (click derecho->Source->Generate Getters and Setters)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public int getDpto() {
		return dpto;
	}
	public void setDpto(int dpto) {
		this.dpto = dpto;
	}
	public String getN_dpto() {
		return n_dpto;
	}
	public void setN_dpto(String n_dpto) {
		this.n_dpto = n_dpto;
	}
public Empleados AumentoSueldo(Empleados e){
	e.salario=(int)1.2*e.getSalario();
	return e;
}
	
}


