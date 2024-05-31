package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDerecho extends JPanel implements ActionListener{
	
	private Ventana padre;
	
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiarJugador;
	
	public final static String NUEVO = "n";
	public final static String REINICIAR = "r";
	public final static String TOP10 = "t";
	public final static String CAMBIAR_JUGADOR = "c";
	
	public PanelDerecho(Ventana principal) {
		this.padre = principal;
		setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(150,460));
		
		nuevo = new JButton("NUEVO");
		nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nuevo.setAlignmentY(Component.CENTER_ALIGNMENT);
		nuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
		nuevo.setFont(principal.fuente);
		nuevo.setActionCommand(NUEVO);
		nuevo.addActionListener(this);
		
		reiniciar = new JButton("REINICIAR");
		reiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
		reiniciar.setAlignmentY(Component.CENTER_ALIGNMENT);
		reiniciar.setFont(principal.fuente);
		reiniciar.setActionCommand(REINICIAR);
		reiniciar.addActionListener(this);
		
		top10 = new JButton("TOP-10");
		top10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		top10.setAlignmentX(Component.CENTER_ALIGNMENT);
		top10.setAlignmentY(Component.CENTER_ALIGNMENT);
		top10.setFont(principal.fuente);
		top10.setActionCommand(TOP10);
		top10.addActionListener(this);
		
		cambiarJugador = new JButton("CAMBIAR JUGADOR");
		cambiarJugador.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cambiarJugador.setAlignmentX(Component.CENTER_ALIGNMENT);
		cambiarJugador.setAlignmentY(Component.CENTER_ALIGNMENT);
		cambiarJugador.setFont(principal.fuente);
		cambiarJugador.setActionCommand(CAMBIAR_JUGADOR);
		cambiarJugador.addActionListener(this);
		
		Dimension buttonSize = new Dimension(150, 20);
        nuevo.setMaximumSize(buttonSize);
        reiniciar.setMaximumSize(buttonSize);
        top10.setMaximumSize(buttonSize);
        cambiarJugador.setMaximumSize(buttonSize);
		
        add(Box.createVerticalStrut(120));
		add(nuevo);
		add(Box.createVerticalStrut(20));
		add(reiniciar);
		add(Box.createVerticalStrut(20));
		add(top10);
		add(Box.createVerticalStrut(20));
		add(cambiarJugador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand().toString();
		if (comando.equals(NUEVO)) {
			padre.nuevoJuego();
		}else if (comando.equals(REINICIAR)) {
			padre.reiniciar();
		}else if (comando.equals(TOP10)) {
			padre.mostrarTop();
		}else if (comando.equals(CAMBIAR_JUGADOR)) {
			padre.cambiarJugador();
		}
	}
}
