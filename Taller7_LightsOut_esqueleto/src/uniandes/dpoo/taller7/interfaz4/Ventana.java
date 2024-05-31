package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarculaLaf;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class Ventana extends JFrame{
	
	private PanelSuperior superior;
	private PanelDerecho derecha;
	private PanelInferior inferior;
	private PanelTablero tablero;
	

	public static final String FACIL = "f";
	public static final String MEDIO = "m";
	public static final String DIFICIL = "d";
	
	private int ladoTablero = 5;
	private String dificultad = FACIL;
	private String nombreActual = "AAA";
	
	private Tablero elTablero = new Tablero(ladoTablero);
	private static Top10 top10 = new Top10();
	
	protected Font fuente = new Font("Microsoft JhengHei", Font.PLAIN, 12);
	
	public Ventana () {
		setSize(500, 500);
		setLocation(450, 100);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout());
		setFont(fuente);
		ImageIcon img = new ImageIcon("./data/luz.png");
		this.setIconImage(img.getImage());
		superior = new PanelSuperior(this);
		derecha = new PanelDerecho(this);
		inferior = new PanelInferior(this);
		tablero = new PanelTablero(elTablero.darTablero(), this);
		add(superior, BorderLayout.NORTH);
		add(derecha, BorderLayout.EAST);
		add(inferior, BorderLayout.SOUTH);
		add(tablero, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FlatDarculaLaf.install();
		File file = new File("./data/top10.csv");
		top10.cargarRecords(file);
		SwingUtilities.invokeLater(() -> new Ventana());
	}
	
	public void cambiarTamano(int lado) {
		ladoTablero=lado;
	}

	public void actualizarDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public void nuevoJuego() {
		elTablero = new Tablero(ladoTablero);
		int numDificultad = 0;
		if(dificultad.equals(FACIL)) {numDificultad = 5;}
		else if(dificultad.equals(MEDIO)) {numDificultad = 7;}
		else if(dificultad.equals(DIFICIL)) {numDificultad = 10;}
		elTablero.desordenar(numDificultad);
		tablero.setTablero(elTablero.darTablero());
	}
	
	public void reiniciar() {
		elTablero.reiniciar();
		tablero.setTablero(elTablero.darTablero());
	}
	
	public void mostrarTop() {
		Collection<RegistroTop10> registro = top10.darRegistros();
		VentanaTop10 ventanaTop = new VentanaTop10(registro, this, true);
		ventanaTop.setVisible(true);
	}
	
	public void cambiarJugador() {
		String nombre = (String)JOptionPane.showInputDialog(this,"Ingrese el nombre", "",            
	               JOptionPane.PLAIN_MESSAGE,null,null,"");
		if (nombre == null) {nombre = "AAA";}
		if (nombre.length() == 0) {nombre = "AAA";}
		inferior.cambiarJugador(nombre);
		nombreActual = nombre;
	}
	
	private void ganar() {
		int puntaje = elTablero.calcularPuntaje();
		if(top10.esTop10(puntaje)) {
			top10.agregarRegistro(nombreActual, puntaje);
		}
		tablero.inicial = true;
		JOptionPane.showMessageDialog(this, "¡Felicidades "+nombreActual+"! has ganado con un puntaje de: "+puntaje);
		try {
			top10.salvarRecords(new File("./data/top10.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void jugar(int x, int y) {
		elTablero.jugar(x, y);
		tablero.setTablero(elTablero.darTablero());
		inferior.sumarJugada(elTablero.darJugadas());
		if(elTablero.tableroIluminado()) {
			ganar();
		}
	}
}
