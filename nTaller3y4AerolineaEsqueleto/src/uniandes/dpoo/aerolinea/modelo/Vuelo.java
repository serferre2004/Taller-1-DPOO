package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.*;

import java.util.Collection;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
	
	public Ruta getRuta() {
		return ruta;
	}

	
	public String getFecha() {
		return fecha;
	}


	public Avion getAvion() {
		return avion;
	}
	
	
	public Collection<Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora,
			int cantidad)throws VueloSobrevendidoException{
		int tarifa = calculadora.calcularTarifa(this, cliente);
		for (int i=0; i<cantidad; i++) {
			Tiquete tiquete = new Tiquete(this.fecha, this, cliente, tarifa);
			tiquetes.add(tiquete);
		}
		return tarifa*cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		Vuelo v = null;
		try {
			v = (Vuelo) obj;
		}catch (Exception e) {
			return false;
		}
		if (fecha.equals(v.fecha) && ruta.equals(v.ruta) && avion.equals(v.avion)&& tiquetes.equals(v.tiquetes)) {
			return true;
		}
		return false;
	}

}
