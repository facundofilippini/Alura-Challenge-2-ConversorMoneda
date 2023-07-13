package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;


public class FrameConversorMoneda extends JFrame {
	
	
	private JTextField CantidadTextField;
	double cantidad = 0;
	String de;
	String a;
	double conversion = 0;
	private JTextField resultadoLabel;
	double conversionRound;

	/**
	 * Launch the application.
	 */
	
	public void frame() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConversorMoneda frame = new FrameConversorMoneda();
					frame.setVisible(true);
					frame.getContentPane().setLayout(null);
					frame.setLocation(700, 250);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	
	public FrameConversorMoneda() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Conversor Moneda");
		getContentPane().setLayout(null);
		
		JLabel deLabel = new JLabel("De:");
		deLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deLabel.setBounds(23, 60, 125, 29);
		getContentPane().add(deLabel);
		
		final JComboBox deComboBox = new JComboBox();
		deComboBox.setToolTipText("");
		deComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de=deComboBox.getSelectedItem().toString();
				
			}
		});
		
		
		deComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione moneda", "USD (dólar americano)", "ARS (peso argentino)", "EUR (euro)", "GBP (libra esterlina)", "JPY (yen japonés)", "KRW (won surcoreano)"}));
		deComboBox.setSelectedIndex(0);
		deComboBox.setBounds(24, 118, 168, 29);
		deComboBox.setEditable(true);
		getContentPane().add(deComboBox);
		
		JLabel aLabel = new JLabel("A:");
		aLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		aLabel.setBounds(245, 65, 125, 19);
		getContentPane().add(aLabel);
		
		final JComboBox aComboBox = new JComboBox();
		aComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = aComboBox.getSelectedItem().toString();
				
			}
		});
		aComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione moneda", "USD (dólar americano)", "ARS (peso argentino)", "EUR (euro)", "GBP (libra esterlina)", "JPY (yen japonés)", "KRW (won surcoreano)"}));
		aComboBox.setEditable(true);
		aComboBox.setBounds(245, 118, 168, 29);
		getContentPane().add(aComboBox);
		
		JLabel tituloLabel = new JLabel("Ingrese la cantidad de dinero a convertir:");
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloLabel.setBounds(65, 11, 309, 23);
		getContentPane().add(tituloLabel);
		
		CantidadTextField = new JTextField();
		CantidadTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CantidadTextField.setBackground(new Color(255, 255, 255));
		CantidadTextField.setBounds(23, 86, 169, 29);
		getContentPane().add(CantidadTextField);
		CantidadTextField.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnConvertir.setBounds(160, 183, 98, 38);
		getContentPane().add(btnConvertir);
		
		JLabel deLabel_1 = new JLabel("=");
		deLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		deLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		deLabel_1.setBounds(202, 86, 33, 61);
		getContentPane().add(deLabel_1);
		
		resultadoLabel = new JTextField();
		resultadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultadoLabel.setBounds(245, 86, 169, 29);
		getContentPane().add(resultadoLabel);
		resultadoLabel.setColumns(10);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				System.exit(WIDTH);
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainConversor.IniciarPrograma();
				
			}
		});
		btnNewButton_1.setBounds(23, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cantidad = Double.parseDouble(CantidadTextField.getText());
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ingrese números unicamente");
					ex.printStackTrace();
							
				}
				
				
				convertirMoneda(cantidad);
					
				resultadoLabel.setText(String.valueOf(conversionRound));
			}
		});
		
		
	}
	

	/*	USD (dólar americano)
		ARS (peso argentino)
		EUR (euro)
		GBP (libra esterlina)
		JPY (yen japonés)
		KRW (won surcoreano)
	*/
	public double convertirMoneda(double cantidad) {
		
		
		switch(de) {
		
			case "Seleccione moneda":
				JOptionPane.showMessageDialog(null,"Seleccione la moneda que quieres convertir");
			
			case "USD (dólar americano)":
				if (a.equals("USD (dólar americano)")) {
					conversion=cantidad;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*260.36;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*0.92;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*0.79;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*144.45;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*1303.78;
				} 
				break;
				
			case "ARS (peso argentino)":
				if (a.equals("USD (dólar americano)")){
					conversion=cantidad*0.0038;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*1;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*0.0035;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*0.0030;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*0.55;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*5.03;
				}
				break;
				
			case "EUR (euro)":
				if (a.equals("USD (dólar americano)")){
					conversion=cantidad*1.09;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*283.57;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*1;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*0.85;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*156.88;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*1426.11;
				} 
				
				break;
				
			case "GBP (libra esterlina)":
				if (a.equals("USD (dólar americano)")){
					conversion=cantidad*1.27;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*331.8;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*1.17;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*1;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*183.56;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*1668.61;
				} 
				break;
				
			case "JPY (yen japonés)":
				if (a.equals("USD (dólar americano)")){
					conversion=cantidad*0.0069;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*1.81;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*0.0064;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*0.0054;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*1;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*9.09;
				}
				break;
				
			case "KRW (won surcoreano)":
				if (a.equals("USD (dólar americano)")){
					conversion=cantidad*0.00076;
				} else if (a.equals("ARS (peso argentino)")){
					conversion=cantidad*0.2;		
				} else if (a.equals("EUR (euro)")) {
					conversion=cantidad*0.00070;
				} else if (a.equals("GBP (libra esterlina)")){
					conversion=cantidad*0.0000060;
				} else if (a.equals("JPY (yen japonés)")){
					conversion=cantidad*0.11;
				} else if (a.equals("KRW (won surcoreano)")){
					conversion=cantidad*1;
				}
				break;
									
		}
		
		conversionRound = (double)Math.round(conversion * 100d) / 100; 	//todo esto para redondear 
																		//la salida a dos decimles aaa
		
		conversion = conversionRound;
		
		
		return conversionRound;
	}
	
	
}



