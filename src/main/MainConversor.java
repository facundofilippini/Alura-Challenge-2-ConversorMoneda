package main;
import javax.swing.JOptionPane;

public class MainConversor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		IniciarPrograma();
		
	}
	
	public static void IniciarPrograma() {
		FrameConversorMoneda conversorMoneda = new FrameConversorMoneda();
		FrameConversorTemperatura conversorTemperatura = new FrameConversorTemperatura();
		
		Object option = JOptionPane.showInputDialog(null,"Seleccione una opción de conversión:",
				   "Menu", JOptionPane.QUESTION_MESSAGE, null,
				  new Object[] { "Conversor de Moneda", "Conversor de Temperatura" },"Seleccione");
		

		if(option.toString().equals("Conversor de Moneda")) {
			conversorMoneda.frame();
			
		} else if (option.toString().equals("Conversor de Temperatura")) {
			conversorTemperatura.frame();			
					
		} 
	}

}
