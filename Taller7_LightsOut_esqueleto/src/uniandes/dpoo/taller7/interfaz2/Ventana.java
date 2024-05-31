package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame{
	
	private PanelSuperior superior;
	private PanelDerecho derecha;
	private PanelInferior inferior;	
	
	public static final String FACIL = "f";
	public static final String MEDIO = "m";
	public static final String DIFICIL = "d";
	
	public Ventana () {
		setSize(500, 500);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout());
		superior = new PanelSuperior(this);
		derecha = new PanelDerecho(this);
		inferior = new PanelInferior(this);
		add(superior, BorderLayout.NORTH);
		add(derecha, BorderLayout.EAST);
		add(inferior, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Ventana());
	}
	
	public void cambiarTamano(int ancho, int alto) {
		
	}

	public void actualizarDificultad(String dificultad) {
		
	}

	public void nuevoJuego() {
		
	}
	
	public void reiniciar() {
		
	}
	
	public void mostrarTop() {
		
	}
	
	public void cambiarJugador() {

	}
}
