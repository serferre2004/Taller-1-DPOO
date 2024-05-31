package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelTablero extends JPanel{

	private int lado = 5;
	private boolean[][] tablero;
	private Ventana principal;
	protected boolean inicial;
	
	public PanelTablero(boolean[][] tablero, Ventana principal) {
		this.tablero = tablero;
		this.lado = tablero[0].length;
		this.principal = principal;
		inicial= true;
		MListener mouse = new MListener();
		addMouseListener(mouse);
	}
	
	public void setTablero(boolean[][] tablero) {
		this.tablero = tablero;
		this.lado = tablero[0].length;
		inicial = false;
		repaint();
	}
	
	public class MListener implements MouseListener {
		

		@Override
		public void mousePressed(MouseEvent e)
		{
			int click_x = e.getX();
			int click_y = e.getY();
			int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
			if(casilla[0] < lado && casilla[1] < lado && !inicial) {principal.jugar(casilla[0], casilla[1]);}
		}
		private int[] convertirCoordenadasACasilla(int x, int y)
		{
			int altoCasilla = 330 / lado;
			int anchoCasilla = 330 / lado;
			int fila = (int) (y / altoCasilla);
			int columna = (int) (x / anchoCasilla);
			return new int[] { fila, columna };
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i=0; i<lado; i++) {
			for(int j=0; j<lado; j++) {
				if (tablero[i][j]) {
					g2d.setPaint(new GradientPaint(330/lado*j+1,330/lado*i+1,new Color(250, 246, 180),330/lado*j+1+330/lado-2,330/lado*i+1+330/lado-2,new Color(219, 208, 15)));
					g2d.fillRoundRect(330/lado*j+1, 330/lado*i+1, 330/lado-2, 330/lado-2,7,7);
				}else {
					g2d.setPaint(new GradientPaint(330/lado*j+1,330/lado*i+1,new Color(64, 62, 58),330/lado*j+1+330/lado-2,330/lado*i+1+330/lado-2,new Color(10, 10, 10)));
					g2d.fillRoundRect(330/lado*j+1, 330/lado*i+1, 330/lado-2, 330/lado-2,7,7);
				}
			}
		}
	}
	
}
