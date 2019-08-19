package com.sistemveterinariaadmision.test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.sistemveterinariaadmision.fabricaadmin.Admin;
import com.sistemveterinariaadmision.fabricaadmin.Control;


public class ViewFrameTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrameTest frame = new ViewFrameTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewFrameTest() {
		
		Control amin1 = new Control (new Admin());
		JPanel panel_1 = new JPanel();
		JButton button = new JButton("Individual");
		JButton button_1 = new JButton("Multiple");
		JTextArea textArea = new JTextArea();
		
		panel_1.setVisible(false);
		
		
		setTitle("Sistema de ingreso de la Veterinaria");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 941, 728);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Detalle Atenci\u00F3n");
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//muestra la pantalla de detalle de revision
				
				 panel_1.setVisible(true);
				if (Admin.getDoctor()==null) {
					button_1.setVisible(false);
					button.setVisible(false);
				}else if (Admin.getDoctor()!=null) {
					button_1.setVisible(true);
					button.setVisible(true);
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);//nenu o file

		setContentPane(contentPane);
		//this.setExtendedState(MAXIMIZED_BOTH);
		this.setExtendedState(NORMAL);
		
		JLabel lblReporte_1 = new JLabel("Reporte:  ");
		lblReporte_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Ingreso de Paciente ");
		lblNewLabel.setBounds(26, 28, 200, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel lblIngresoDeReporte = new JLabel("Ingreso de Reporte  ");
		lblIngresoDeReporte.setBounds(26, 63, 200, 17);
		lblIngresoDeReporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(lblIngresoDeReporte);
		
		
		JButton btnNewButton = new JButton("ADD");//ingresa un enfermo
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amin1.callCheckin();
			}
		});
	
		btnNewButton.setBounds(196, 25, 75, 25);
		panel.add(btnNewButton);
		
		JButton btnReprot = new JButton("Reprot");//para ingresar un reporte
		btnReprot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Admin.getDoctor()==null) {
					JOptionPane.showMessageDialog(null, "No hay nada que reportar hasta el momento");
				}else if (Admin.getDoctor()!=null) {
					amin1.reporte();	
				}
			}
		});
		btnReprot.setBounds(196, 60, 75, 25);
		panel.add(btnReprot);
		
		JLabel lblReporte = new JLabel("Reporte  ");
		lblReporte.setBounds(26, 110, 200, 17);
		panel.add(lblReporte);
		lblReporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JButton btnGo = new JButton("Go");//boton de busqueda y leer reporte
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Admin.getDoctor()==null) {
					JOptionPane.showMessageDialog(null, "No hay nada que imprimir hasta el momento");
				}else if (Admin.getDoctor()!=null) {
					textArea.setText(amin1.seeReport());	
				}
			}
		});
		btnGo.setBounds(196, 107, 75, 25);
		panel.add(btnGo);
		
		JButton btnClear = new JButton("Clear ");//boton de limpieza de area de texto
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");	
			}
		});
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
						.addComponent(lblReporte_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblReporte_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClear)
					.addGap(10))
		);
		
		panel_1.setBackground(UIManager.getColor("activeCaption"));
		panel_1.setBounds(390, 0, 365, 158);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Detalle de Atencion de Pasientes");
		label.setBackground(Color.WHITE);
		label.setBounds(58, 37, 222, 17);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(label);
		
		
		button.addActionListener(new ActionListener() {//imprime el detalle individual de los doctores en el area de texto
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(amin1.detalleAtencion());
			}
		});
		button.setBackground(new Color(240, 248, 255));
		button.setBounds(204, 102, 101, 25);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(button);
		

		button_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {//imprime el detalle de todos los doctores en el area de texto
				
				for (String iterable : amin1.multiDetalleAtencion()) {
					textArea.setText(iterable);
				}
	
			}
		});
		
		button_1.setBackground(new Color(240, 248, 255));
		button_1.setBounds(53, 102, 101, 25);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(button_1);
		
		JButton btnNewButton_1 = new JButton("x");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(321, 0, 44, 25);
		panel_1.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
	}
}

	

