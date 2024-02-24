package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.vuelo = vuelo;
		this.cliente = clienteComprador;
	}

	public int getTarifa() {
		return tarifa;
	}

	public boolean esUsado() {
		return usado;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void marcarComoUsado() {
		this.usado = true;
	}
	
}
