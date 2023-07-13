package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class FrameConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField CantidadTextField;
	double cantidad = 0;
	String de;
	String a;
	double conversion = 0;
	double conversionRound;

	/**
	 * Launch the application.
	 */
	public  void frame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameConversorTemperatura frame = new FrameConversorTemperatura();
					frame.setVisible(true);
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
	public FrameConversorTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Conversor Temperatura");
		getContentPane().setLayout(null);
		
		JLabel deLabel = new JLabel("De");
		deLabel.setBounds(24, 65, 125, 14);
		getContentPane().add(deLabel);
		
		final JComboBox deComboBox = new JComboBox();
		deComboBox.setToolTipText("");
		deComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de=deComboBox.getSelectedItem().toString();
				
			}
		});
		
		
		deComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione temperatura", "°C (grados Celsius)", "°F (grados Fahrenheit)", "°K (grados Kelvin)", "°R (Rankine)"}));
		deComboBox.setSelectedIndex(0);
		deComboBox.setBounds(24, 130, 157, 29);
		deComboBox.setEditable(true);
		getContentPane().add(deComboBox);
		
		JLabel aLabel = new JLabel("A");
		aLabel.setBounds(259, 65, 125, 14);
		getContentPane().add(aLabel);
		
		final JComboBox aComboBox = new JComboBox();
		aComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = aComboBox.getSelectedItem().toString();
				
			}
		});
		aComboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione temperatura", "°C (grados Celsius)", "°F (grados Fahrenheit)", "°K (grados Kelvin)", "°R (Rankine)"}));
		aComboBox.setEditable(true);
		aComboBox.setBounds(245, 130, 157, 29);
		getContentPane().add(aComboBox);
		
		final JLabel resultadoLabel = new JLabel("");
		resultadoLabel.setBackground(Color.WHITE);
		resultadoLabel.setBounds(245, 90, 157, 29);
		getContentPane().add(resultadoLabel);
		
		JLabel tituloLabel = new JLabel("Ingrese la cantidad a convertir:");
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloLabel.setBounds(24, 11, 349, 23);
		getContentPane().add(tituloLabel);
		
		CantidadTextField = new JTextField();
		CantidadTextField.setBounds(24, 90, 157, 29);
		getContentPane().add(CantidadTextField);
		CantidadTextField.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		
		btnConvertir.setBounds(166, 195, 89, 23);
		getContentPane().add(btnConvertir);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				System.exit(WIDTH);
			}
		});
		btnNewButton.setBounds(324, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainConversor.IniciarPrograma();
			}
			
			
		});
		btnNewButton_1.setBounds(24, 227, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel deLabel_1 = new JLabel("=");
		deLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		deLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		deLabel_1.setBounds(191, 98, 33, 61);
		getContentPane().add(deLabel_1);
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cantidad = Double.parseDouble(CantidadTextField.getText());
					
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese números unicamente");
					ex.printStackTrace();
							
				}
				convertirTemperatura(cantidad);
				resultadoLabel.setText(String.valueOf(conversion));	
			}
		});
		
	
	}
	/*
	 * 	Seleccione temperatura
		°C (grados Celsius)
		°F (grados Fahrenheit)
		°K (grados Kelvin)
		°R (grados Rankine)
	 * 
	 */
	public double convertirTemperatura(double cantidad) {
		
		switch(de) {
		
		case "Seleccione temperatura":
			JOptionPane.showMessageDialog(null,"Seleccione la temperatura que quieres convertir");
		
		case "°C (grados Celsius)":
			if (a.equals("°C (grados Celsius)")) {
				conversion=cantidad;
			} else if (a.equals("°F (grados Fahrenheit)")){
				conversion= (cantidad * 9/5) + 32 ;		
			} else if (a.equals("°K (grados Kelvin)")) {
				conversion= cantidad + 273.15 ;
			} else if (a.equals("°R (Rankine)")){
				conversion= cantidad * 9/5 + 491.67;
			}
			break;
			
		case "°F (grados Fahrenheit)":
			if (a.equals("°C (grados Celsius)")) {
				conversion= (cantidad-32) * 5/9;
			} else if (a.equals("°F (grados Fahrenheit)")){
				conversion=cantidad;		
			} else if (a.equals("°K (grados Kelvin)")) {
				conversion= (cantidad - 32) * 5/9 + 273.15;
			} else if (a.equals("°R (Rankine)")){
				conversion=cantidad + 459.67;
			}
			break;
			
		case "°K (grados Kelvin)":
			if (a.equals("°C (grados Celsius)")) {
				conversion=cantidad*(-272.15);
			} else if (a.equals("°F (grados Fahrenheit)")){
				conversion=cantidad*(-272.15) * 9/5 + 32;		
			} else if (a.equals("°K (grados Kelvin)")) {
				conversion=cantidad;
			} else if (a.equals("°R (Rankine)")){
				conversion=cantidad*1.8;
			}
			break;
			
		case "°R (Rankine)":
			if (a.equals("°C (grados Celsius)")) {
				conversion=(cantidad-491.67)* 5/9;
			} else if (a.equals("°F (grados Fahrenheit)")){
				conversion=cantidad - 459.67;		
			} else if (a.equals("°K (grados Kelvin)")) {
				conversion=cantidad * 5/9;
			} else if (a.equals("°R (Rankine)")){
				conversion=cantidad;
			}
			break;
				
		
		}
		conversionRound = (double)Math.round(conversion * 100d) / 100; 	//todo esto para redondear 
		//la salida a dos decimles aaa

		conversion = conversionRound;


		return conversionRound;
		
	}
}
