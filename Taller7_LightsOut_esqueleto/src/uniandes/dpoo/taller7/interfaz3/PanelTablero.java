package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelTablero extends JPanel{

	private int alto = 5;
	private int ancho = 5;
	
	public PanelTablero(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		repaint();
	}
	
	public void setDimensiones(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i=0; i<alto; i++) {
			for(int j=0; j<ancho; j++) {
				g2d.setColor(Color.YELLOW);
				g2d.fillRect(330/ancho*j+1, 330/alto*i+1, 330/ancho-2, 330/alto-2);				
			}
		}
	}
}
