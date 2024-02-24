package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
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
	
	
	public int venderTiquetes(Cliente cliente) {
		return 0;
	}
	
	
	public boolean equals(Object obj) {
		return false;
	}

}
