package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame{
	
	private PanelSuperior superior;
	private PanelDerecho derecha;
	private PanelInferior inferior;
	private PanelTablero tablero;
	
	private int anchoTablero = 5;
	private int altoTablero = 5;
	
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
		tablero = new PanelTablero(altoTablero, anchoTablero);
		add(superior, BorderLayout.NORTH);
		add(derecha, BorderLayout.EAST);
		add(inferior, BorderLayout.SOUTH);
		add(tablero, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Ventana());
	}
	
	public void cambiarTamano(int alto, int ancho) {
		altoTablero=alto;anchoTablero=ancho;
		tablero.setDimensiones(alto, ancho);
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
