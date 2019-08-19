package com.sistemveterinariaadmision.entidades;

public class Gato extends Animal {

	public Gato(String tipo, String nombre, String raza, int edad, String causaatencion) {
		super(tipo, nombre, raza, edad, causaatencion);
		
		this.setTipo("Gato");
		
		
		
	}

	
	@Override
	public String toString() {
		return "El " + getTipo() + " con el nombre: " + getNombre()+ " de raza: " + getRaza() + ", tiene una edad de: "
						+ getEdad()+" años, "+ " presenta: " + getCausaatencion();
	}
	
	
	
}
