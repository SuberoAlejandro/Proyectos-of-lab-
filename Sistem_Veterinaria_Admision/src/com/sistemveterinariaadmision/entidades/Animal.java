package com.sistemveterinariaadmision.entidades;

public class Animal {

	private String tipo;
	private String nombre;
	private String raza;
	private String causaatencion;
	private int edad;
	
	
	private boolean revidsado;
	private String revision;
	private String caused;
	private String treatment;
	

	public Animal(String tipo, String nombre, String raza, int edad, String causaatencion) {
		
		this.tipo = tipo;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.causaatencion = causaatencion;
		revidsado=false;
	}

	
		
	public boolean isRevidsado() {
		return revidsado;
	}

	public void setRevidsado(boolean revidsado) {
		this.revidsado = revidsado;
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCausaatencion() {
		return causaatencion;
	}

	public void setCausaatencion(String causaatencion) {
		this.causaatencion = causaatencion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public String getRevision() {
		return revision;
	}

	public String getCaused() {
		return caused;
	}

	public String getTreatment() {
		return treatment;
	}



	//Metodo es para pasar los resultados de la revision del animal
	public String revisionresult(String result) {
			
			return revision="Los resultdos de la revisión del "+ tipo +" llamado " + nombre +" son: "+ result;
		}

	//Metodo es para pasar las causas de enfermedad o tratamiento
	public String causedisease(String cause) {
		
		return caused="Las causas de la enfermedad son: "+cause;
	}
	
	//Metodo es para pasar las medicinas
	public String treatment(String medicines) {
		return treatment="Las medicinas requeridas para tratar al animal son: "+ medicines;
	}
	
	
}
