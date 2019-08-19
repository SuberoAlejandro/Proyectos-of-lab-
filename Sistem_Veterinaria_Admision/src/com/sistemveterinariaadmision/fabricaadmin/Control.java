package com.sistemveterinariaadmision.fabricaadmin;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.sistemveterinariaadmision.entidades.Animal;
import com.sistemveterinariaadmision.entidades.Doctor;

public class Control {

	private Admin a;
	private int index1;
	private int index2;
	private static ArrayList<String> detalle;


	public Control(Admin a) {
		this.a = a;
		detalle = new ArrayList<String>();
	}

	//modifica el numero de doctores del dia esta funcionabilidad no fu solicitada queda sin implementar en esta version del programa
	//public void indoctorsInHouse(int doc) {
	//	a.doctorsInHouse(doc);
	//}
	
	
	// Animal admission
	public void callCheckin() {
		a.Star();
	}

	// builder Animal report
	public void reporte() {
		// a.Screenreporte();
		Screentocharge2();
	}

	// metodo para cargar el reporte del paciente
	private void Screentocharge2() {

		Choice animal1 = new Choice();
		Choice cho1 = new Choice();
		JTextField nombre = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();

		for (Doctor doctor : Admin.getDoctor()) {
			cho1.addItem(doctor.getName());
		}

		cho1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cho1.isFocusOwner()) {

					for (int i = 0; i < Admin.getDoctor().size(); i++) {
						if (cho1.getSelectedItem().equals(Admin.getDoctor().get(i).getName())) {
							index1 = i;
							animal1.removeAll();
							break;
						}
					}

					for (int i = 0; i < Admin.getDoctor().size(); i++) {
						for (Animal g : Admin.getDoctor().get(i).getAnimal()) {
							if (!g.isRevidsado()) {
								animal1.addItem(g.getNombre());
							}
						}
					}
				}
			}

		});

		animal1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				for (int i = 0; i < Admin.getDoctor().size(); i++) {
					for (int y = 0; y < Admin.getDoctor().get(i).getAnimal().size(); y++)
						if (animal1.getSelectedItem().equals(Admin.getDoctor().get(i).getAnimal().get(y).getNombre())) {
							index2 = y;
							break;
						}
				}
			}
		});

		Object[] message = { "Doctor:", cho1, "Pasiente:", animal1, "Revision resultado", nombre, "Causa/s", txt3,
				"Medicinas", txt4 };
		UIManager.put("OptionPane.minimumSize", new Dimension(500, 400));
		int option = JOptionPane.showConfirmDialog(null, message, "Reporte de paciente", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {

			Admin.getDoctor().get(index1).getAnimal().get(index2).revisionresult(nombre.getText());
			Admin.getDoctor().get(index1).getAnimal().get(index2).causedisease(txt3.getText());
			Admin.getDoctor().get(index1).getAnimal().get(index2).treatment(txt4.getText());
			Admin.getDoctor().get(index1).getAnimal().get(index2).setRevidsado(true);

			Admin.getRevisado().add(Admin.getDoctor().get(index1).getAnimal().get(index2));
		}
	}

	// "Revision resultado de analisis del doctor"
	public String seeReport() {

		String reporte = "";
		Choice animal1 = new Choice();
		for (Animal g : Admin.getRevisado()) {
			if (g.isRevidsado()) {
				animal1.addItem(g.getNombre());
			}
		}
		Object[] message = { "Pasiente :", animal1 };
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 300));
		int option = JOptionPane.showConfirmDialog(null, message, "Revision resultado", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			for (Animal g1 : Admin.getRevisado()) {
				if (animal1.getSelectedItem().equals(g1.getNombre())) {
					reporte = g1.getNombre() + "\n" + g1.getRevision() + "\n" + g1.getCaused() + "\n"
							+ g1.getTreatment();
					return reporte;
				}
			}
		}
		animal1=null;
		return reporte;
	}

	
	//genera el detalle de la atencion de los 5 doctores
	public ArrayList<String> multiDetalleAtencion() {

		String detalles = "";
		String atencion = "";

		for (int i = 0; i < Admin.getDoctor().size(); i++) {

			atencion = "Cantidad de pacientes atendidos por el doctor " + Admin.getDoctor().get(i).getName() + "=  "
					+ Admin.getDoctor().get(i).getAnimalNumber();

			for (Animal g : Admin.getDoctor().get(i).getAnimal()) {

				detalles = "doctor: " + Admin.getDoctor().get(i).getName() + " atendio a: " + g.getNombre();
			}

			String Master = "\n" + atencion + "\n" + detalles;
			detalle.add(Master);
		}
		return detalle;
	}

	
	//genera el detalle de atencion de un solo doctor
	public String detalleAtencion() {

		String detalles = "";
		String atencion = "";
		String master = "";

		Choice l1 = new Choice();
		for (Doctor gdoct : Admin.getDoctor()) {
			l1.addItem(gdoct.getName());
		}
		Object[] message = { "Pasiente :", l1 };
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 300));
		int option = JOptionPane.showConfirmDialog(null, message, "Detalle Atencion Individual",JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {

			for (int i = 0; i < Admin.getDoctor().size(); i++) {
				atencion = "Cantidad de pacientes atendidos por el doctor " + Admin.getDoctor().get(i).getName() + "=  "
						+ Admin.getDoctor().get(i).getAnimalNumber();
				for (Animal g : Admin.getDoctor().get(i).getAnimal()) {
					detalles = "doctor: " + Admin.getDoctor().get(i).getName() + " atendio a: " + g.getNombre();
				}
				master = "\n" + atencion + "\n" + detalles;
			}
		}
		l1=null;
		return master;
	}


	
}
