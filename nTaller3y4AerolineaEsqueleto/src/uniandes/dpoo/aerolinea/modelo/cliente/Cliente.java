package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private ArrayList<Tiquete> tiquetesSinUsar;
	private ArrayList<Tiquete> tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public String getTipoCliente() {
		return null;
	}
	
	public String getIdentificador () {
		return null;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for (Tiquete t:tiquetesSinUsar) {
			total += t.getTarifa();
		}
		return total;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for (Tiquete t:tiquetesSinUsar) {
			if (t.getVuelo().equals(vuelo)) {
				t.marcarComoUsado();
				tiquetesSinUsar.remove(t);
				tiquetesUsados.add(t);
			}
		}
	}
}
