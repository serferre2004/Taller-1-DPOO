package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel{
	
	private Ventana padre;
	
	private JTextField jugadas;
	private JTextField jugador;
	
	public PanelInferior(Ventana principal) {
		this.padre = principal;
		setLayout(new GridLayout(1,4));
		
		add(new JLabel("Jugadas:"));
		
		jugadas = new JTextField("0");
		jugadas.setEnabled(false);
		jugadas.setBackground(getBackground());
		add(jugadas);
		
		add(new JLabel("Jugador:"));
		
		jugador = new JTextField();
		jugador.setEnabled(false);
		jugador.setBackground(getBackground());
		add(jugador);
	}
	
}
