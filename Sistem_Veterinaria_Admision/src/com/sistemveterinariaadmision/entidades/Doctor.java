package com.sistemveterinariaadmision.entidades;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Doctor {

	
	private int animalNumber;
	private String name;
	private LinkedList<Animal> Animal =new LinkedList<Animal>();
	

	//constructor 
	public Doctor(String name, int animalNumber) {
		this.name = name;
		accetAnimal(animalNumber);
	}

	public Doctor(String name) {
		this.name = name;
	}
	
	
	//constructor 
	public Doctor() {
	}
	
	
	//add new animal
	public void addAnimal(int Animal) {
		accetAnimal (Animal);
	}
	
	
	//check the number of animal of doctor
	public void accetAnimal (int number) {
		if ((animalNumber + number)<=5) {
			animalNumber+=number;
			//pasa a gestion numero el nuevo numero
			
		}else {
			if (animalNumber<=5) {
				JOptionPane.showMessageDialog(null, "The doctor has room for "+(5-animalNumber)+" interns");
			}else {
			// se debe colocar en gestin un valor modificable para que el doctor no este disponible en la base de datos
			JOptionPane.showMessageDialog(null, "The Doctor is full of patients");
			}
		}
	}

	@Override
	public String toString() {
		return "Doctor [animalNumber= " + animalNumber + ", name= " + name + "]";
	}
	
	
	public LinkedList<Animal> getAnimal() {
		return Animal;
	}

	public void setAnimal(LinkedList<Animal> animal) {
		Animal = animal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnimalNumber() {
		return animalNumber;
	}

	public void setAnimalNumber(int animalNumber) {
		this.animalNumber = animalNumber;
	}
	
	
	
}
