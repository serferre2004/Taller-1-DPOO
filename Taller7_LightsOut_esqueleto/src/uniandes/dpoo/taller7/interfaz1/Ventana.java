package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana () {
		setSize(800, 500);
		setTitle("Juego de LightsOut");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ventana();
	}

}
