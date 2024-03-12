package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES = 0.2;
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		if (cliente.getTipoCliente() != "Corporativo") {
			return this.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM_NATURAL;
		} else {
			return this.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM_CORPORATIVO;
		}
	}
	
	@Override
	public double calcularPorcentajeDescuento(Cliente cliente) {
		if (cliente.getTipoCliente() != "Corporativo") {
			return 0;
		} else {
			if (((ClienteCorporativo) cliente).getTamanoEmpresa() == 1) {
				return DESCUENTO_GRANDES;
			} else if (((ClienteCorporativo) cliente).getTamanoEmpresa() == 2){
				return DESCUENTO_MEDIANAS;
			} else {
				return DESCUENTO_PEQ;
			}
			
		}
	}
}
