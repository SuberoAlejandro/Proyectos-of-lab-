package com.sistemveterinariaadmision.test;

import com.sistemveterinariaadmision.fabricaadmin.Admin;
import com.sistemveterinariaadmision.fabricaadmin.Control;



public class Test {

	public static void main(String[] args) {

		

		Control amin1 = new Control(new Admin());

		amin1.callCheckin();
		amin1.callCheckin();
		amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();
		// amin1.callCheckin();

		// System.out.println(amin1.multiDetalleAtencion());

		// System.out.println("");

		System.out.println(amin1.detalleAtencion());

		System.out.println("");

		amin1.reporte();

		// amin1.reporte();

		System.out.println(amin1.seeReport());

	}
}
