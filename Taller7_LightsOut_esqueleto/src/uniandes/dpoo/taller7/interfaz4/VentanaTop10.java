package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class VentanaTop10 extends JDialog implements MouseListener{
	private JList lista;
	private DefaultListModel<String> model;
	private JScrollPane scrollLista;
	
	public VentanaTop10(Collection<RegistroTop10> registro, Ventana principal, boolean modal) {
		super(principal, modal);
		setLayout(null);
		setBounds(500,200,200,230);
		setTitle("Top 10");
		setResizable(false);
		JLabel header = new JLabel("#    NOMBRE   PTS");
		header.setFont(principal.fuente);
		header.setBounds(40, 10, 300, 20);
		add(header);
		model = new DefaultListModel<String>();
		int index = 1;
		for (RegistroTop10 r:registro) {
			model.addElement(String.valueOf(index));
			model.addElement(r.darNombre());
			model.addElement(String.valueOf(r.darPuntos()));
			index++;
		}
		lista = new JList(model);
		lista.setFont(principal.fuente);
		lista.setLayoutOrientation(lista.HORIZONTAL_WRAP);
		lista.setFixedCellWidth(42);
		lista.setVisibleRowCount(10);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) lista.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		renderer.setBackground(new Color(15, 15, 15, 175));
		lista.setCellRenderer(renderer);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.addMouseListener(this);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(21, 30,142, 150);
		scrollLista.setViewportView(lista);
		add(scrollLista);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = lista.locationToIndex(e.getPoint());
		if (index%3 == 0) {
			lista.setSelectionInterval(index, index+2);
		} else if (index%3 == 1) {
			lista.setSelectionInterval(index-1, index+1);
		} else if (index%3 == 2) {
			lista.setSelectionInterval(index-2, index);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
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
