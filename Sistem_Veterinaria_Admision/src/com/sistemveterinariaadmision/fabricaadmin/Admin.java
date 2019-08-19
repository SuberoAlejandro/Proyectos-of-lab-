package com.sistemveterinariaadmision.fabricaadmin;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.sistemveterinariaadmision.entidades.Animal;
import com.sistemveterinariaadmision.entidades.Conejo;
import com.sistemveterinariaadmision.entidades.Doctor;
import com.sistemveterinariaadmision.entidades.Gato;
import com.sistemveterinariaadmision.entidades.Perro;

public class Admin {

	private static LinkedList<Doctor> doctor;
	private static LinkedList<Animal> revisado;
	private int admittedinterns;// number of animals served
	private String docName="";
	private int doctors=5;
	
	
	
	//
	public Admin (){
	revisado =new LinkedList<Animal>();
	
	}
	
	
	//modifica el numero de doctores del dia esta funcionabilidad no fu solicitada queda sin implementar en esta version del programa.
	//public void doctorsInHouse(int doc) {
	//	doctors=doc;
	//}
	
	//esta funcion registra el incremento de los pacientes o clientes
	private int addinterns(int number) {
		return admittedinterns+=number;
	}
	
	//este metodo es para ejecutar la accion de inicio
	protected void Star() {
		checkin();
	}
	

	
	//ejecuta comprobocion y cadena de eventos para el ingreso de un pasiente
	private void checkin() {
		if (admittedinterns < 20) {
			DoctorManage();
			addinterns(1);
			Screentocharge();
		} else {
			JOptionPane.showMessageDialog(null, "Por el dia no se admiten mas pacientes");
			
		}
	}
	
	

	// doctors management
	private String DoctorManage() {
		
		if (doctor == null) {
			doctor = new LinkedList<Doctor>();
			doctor.add(indoctor("1"));
			doctor.get(0).accetAnimal(1);
			docName= "1";
		} else if (doctor.size() == doctors) {
			for (Doctor doc : doctor) {
				if (doc.getAnimalNumber() <3) {
					doc.accetAnimal(1);
					docName =doc.getName();
					JOptionPane.showMessageDialog(null, "El dortor que esta disponible es "+ doc.getName());
					return doc.getName();
				}else if (doc.getAnimalNumber() <4) {
					doc.accetAnimal(1);
					JOptionPane.showMessageDialog(null, "El dortor que esta disponible es "+ doc.getName());
					return doc.getName();
				}
			}	
		} else {
			int nu2= doctor.size()+1;
			doctor.add(indoctor(Integer.toString(nu2)));
			doctor.get(doctor.size()-1).accetAnimal(1);
			docName= Integer.toString(nu2);
		}
		
		UIManager.put("OptionPane.minimumSize",new Dimension(300,100));
		JOptionPane.showMessageDialog(null, "El dortor que esta disponible es "+ docName);
		return docName;
	}

	
	//bueilder of Doctor
	private Doctor indoctor(String name) {
	return new Doctor(name);
	}

	public void inreturnAnimal (String tipo, String nombre, String raza, int edad, String causaatencion) {
		returnAnimal(tipo,nombre,raza,edad,causaatencion);
	}
	
	
	//bueilder Animal
	private void returnAnimal(String tipo, String nombre, String raza, int edad, String causaatencion) {
		
		tipo=tipo.trim();
		tipo = Character.toUpperCase(tipo.charAt(0)) + tipo.substring(1,tipo.length());
		
		if (tipo.equals("Perro")){	
			Animal p= new Perro (tipo, nombre, raza,edad,causaatencion);
			
			doctor.get(Integer.valueOf(docName)-1).getAnimal().add(p);
			
		}else if (tipo.equals("Gato")){	 
			
			Animal p= new Gato (tipo, nombre, raza,edad,causaatencion);
			
			doctor.get(Integer.valueOf(docName)-1).getAnimal().add(p);
			
		}else if (tipo.equals("Conejo")){	 
			
			Animal p= new Conejo (tipo, nombre, raza,edad,causaatencion);
			
			doctor.get(Integer.valueOf(docName)-1).getAnimal().add(p);
		}
	}
	
	
	//pantalla de entrada de datos de animales
	private void Screentocharge() {

				
		JTextField nombre = new JTextField();
		JTextField edad = new JTextField();
		JTextField raza = new JTextField();
		JTextField cuento = new JTextField();
		Choice tipo = new Choice();
						
		tipo.add("Perro");
		tipo.add("Gato");
		tipo.add("Conejo");
		
		edad.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(((caracter<'0')||(caracter>'9'))&&(caracter!='\b'))
		      {
		         e.consume(); 
		      }
		   }
		});
		
		Object[] message = { "Tipo:", tipo, "Nombre:", nombre, "Edad", edad, "Raza", raza, "Causa", cuento };

		UIManager.put("OptionPane.minimumSize",new Dimension(500,400));
		int option = JOptionPane.showConfirmDialog(null, message, "Ingreso de Pasiente", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {	
			if (edad.getText().equals("")) {
				edad.setText("0");
				returnAnimal(tipo.getSelectedItem(), nombre.getText(), raza.getText(), 
						Integer.valueOf(edad.getText()), cuento.getText());
			}
			    returnAnimal(tipo.getSelectedItem(), nombre.getText(), raza.getText(), 
							Integer.valueOf(edad.getText()), cuento.getText());
		}
		
		nombre = null;
		edad =null;
		raza = null;
		cuento = null;
		tipo =null;
		
	}



	
	public static LinkedList<Animal> getRevisado() {
		return revisado;
	}

	public static void setRevisado(LinkedList<Animal> revisado) {
		Admin.revisado = revisado;
	}

	public static LinkedList<Doctor> getDoctor() {
		return doctor;
	}

	public static void setDoctor(LinkedList<Doctor> doctor) {
		Admin.doctor = doctor;
	}


	public int getAdmittedinterns() {
		return admittedinterns;
	}

	public void setAdmittedinterns(int admittedinterns) {
		this.admittedinterns = admittedinterns;
	}

}
