package com.sistemveterinariaadmision.entidades;

public class Conejo extends Animal {

	public Conejo(String tipo, String nombre, String raza, int edad, String causaatencion) {
		super(tipo, nombre, raza, edad, causaatencion);
	
		this.setTipo("conejo");
		
	}

	
	@Override
	public String toString() {
		return "El " + getTipo() + " con el nombre: " + getNombre()+ " de raza: " + getRaza() + ", tiene una edad de: "
						+ getEdad()+" años, "+ " presenta: " + getCausaatencion();
	}
	
}
