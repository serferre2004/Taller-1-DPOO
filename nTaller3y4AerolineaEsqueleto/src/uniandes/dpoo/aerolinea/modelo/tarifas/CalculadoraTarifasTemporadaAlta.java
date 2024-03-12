package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	protected int COSTO_POR_KM = 1000;
	
	public CalculadoraTarifasTemporadaAlta() {
	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int distancia  = this.calcularDistanciaVuelo(vuelo.getRuta());
		return COSTO_POR_KM*distancia;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0.00;
	}

}
