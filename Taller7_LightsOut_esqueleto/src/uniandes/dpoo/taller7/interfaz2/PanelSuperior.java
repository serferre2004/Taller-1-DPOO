package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel implements ItemListener, ActionListener{
	
	private Ventana padre;
	private JComboBox<String> selectorTamano;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public static final String FACIL = "f";
	public static final String MEDIO = "m";
	public static final String DIFICIL = "d";
	
	public PanelSuperior(Ventana principal) {
		super();
		setLayout(new GridLayout(1,6));
		this.padre = principal;
		
		JLabel T = new JLabel("Tamaño");
		add(T);
		
		String[] tamanos = {"5x5", "5x4", "4x4", "6x6"};
        selectorTamano = new JComboBox<>(tamanos);
        selectorTamano.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectorTamano.addItemListener(this);
        add(selectorTamano);
		
		JLabel D = new JLabel("Dificultad");
		add(D);
		
		facil = new JRadioButton("Fácil");
		facil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		facil.setActionCommand(FACIL);
		facil.addActionListener(this);
		add(facil);
		
		medio = new JRadioButton("Medio");
		medio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		medio.setActionCommand(MEDIO);
		medio.addActionListener(this);
		add(medio);
		
		dificil = new JRadioButton("Difícil");
		dificil.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dificil.setActionCommand(DIFICIL);
		dificil.addActionListener(this);
		add(dificil);
		
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String tamano = e.getItem().toString();
		padre.cambiarTamano(Integer.valueOf(tamano.substring(0, 1)), Integer.valueOf(tamano.substring(2)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(FACIL)) {
			medio.setSelected(false);
			dificil.setSelected(false);
		}else if (comando.equals(MEDIO)) {
			facil.setSelected(false);
			dificil.setSelected(false);
		}else if (comando.equals(DIFICIL)) {
			facil.setSelected(false);
			medio.setSelected(false);
		}
		padre.actualizarDificultad(comando);
	}
}
