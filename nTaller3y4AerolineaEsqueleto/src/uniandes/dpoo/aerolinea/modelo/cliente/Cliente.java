package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private ArrayList<Tiquete> tiquetesSinUsar;
	private ArrayList<Tiquete> tiquetesUsados;
	
	public Cliente() {
		
	}
	
	public String getTipoCliente() {
		return null;
	}
	
	public String getIdentificador () {
		return null;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		
	}
	
	public int calcularValorTotalTiquetes() {
		return 0;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		
	}
}
