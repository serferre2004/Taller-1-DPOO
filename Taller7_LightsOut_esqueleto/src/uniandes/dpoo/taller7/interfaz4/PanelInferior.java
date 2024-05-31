package uniandes.dpoo.taller7.interfaz4;

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
		
		JLabel J = new JLabel("Jugadas:");
		J.setFont(principal.fuente);
		add(J);
		
		jugadas = new JTextField("0");
		jugadas.setEnabled(false);
		jugadas.setBackground(getBackground());
		jugadas.setFont(principal.fuente);
		add(jugadas);
		
		JLabel P = new JLabel("Jugador:");
		P.setFont(principal.fuente);
		add(P);
		
		jugador = new JTextField("AAA");
		jugador.setEnabled(false);
		jugador.setBackground(getBackground());
		jugador.setFont(principal.fuente);
		add(jugador);
	}

	public void sumarJugada(int num) {
		jugadas.setText(String.valueOf(num));
		repaint();
	}

	public void cambiarJugador(String nombre) {
		jugador.setText(nombre);
		repaint();
	}
	
}
