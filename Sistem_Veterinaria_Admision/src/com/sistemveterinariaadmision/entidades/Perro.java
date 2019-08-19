package com.sistemveterinariaadmision.entidades;

public class Perro extends Animal {

	
	public Perro(String tipo, String nombre, String raza, int edad, String causaatencion) {
		super(tipo, nombre, raza, edad, causaatencion);

		this.setTipo("Perro");
	}

	
	
	@Override
	public String toString() {
		return "El " + getTipo() + " con el nombre: " + getNombre()+ " de raza: " + getRaza() + ", tiene una edad de: "
						+ getEdad()+" años, "+ " presenta: " + getCausaatencion();
	}

	

	
	
	
	
}
