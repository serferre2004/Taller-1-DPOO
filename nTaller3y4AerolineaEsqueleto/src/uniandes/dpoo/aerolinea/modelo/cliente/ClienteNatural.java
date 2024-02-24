package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {

	public String NATURAL = "Natural";
	private String nombre;
	
	
	public ClienteNatural(String nombre) {
		// TODO Auto-generated constructor stub
		super();
		this.nombre = nombre;
	}
	
	@Override
	public String getIdentificador() {
		return null;
	}
	
	@Override
	public String getTipoCliente() {
		return null;
	}

}
