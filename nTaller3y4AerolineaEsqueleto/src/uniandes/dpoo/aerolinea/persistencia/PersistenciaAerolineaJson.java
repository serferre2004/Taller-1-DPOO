package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {
	
	private static final String NOMBRE_AVION = "nombreAvion";
	private static final String CAPACIDAD = "capacidad";
	private static final String FECHA_VUELO = "fechaVuelo";
	private static final String CODIGO_RUTA = "codigoRuta";
	private static final String TIQUETES = "tiquetes";
	private static final String HORA_SALIDA = "horaSalida";
	private static final String HORA_LLEGADA = "horaLlegada";
	private static final String ORIGEN = "origen";
	private static final String DESTINO = "destino";
	private static final String NOMBRE_AEROPUERTO = "nombreAeropuerto";
	private static final String CODIGO_AEROPUERTO = "codigoAeropuerto";
	private static final String NOMBRE_CIUDAD = "nombreCiudad";
	private static final String LATITUD = "latitud";
	private static final String LONGITUD = "longitud";
	

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
		String jsonCompleto = new String(Files.readAllBytes(new File(archivo).toPath()));
		JSONObject raiz = new JSONObject (jsonCompleto);
		
		cargarAviones(aerolinea, raiz.getJSONArray("aviones"));
		cargarRutas(aerolinea, raiz.getJSONArray("rutas"));
		cargarVuelos(aerolinea, raiz.getJSONArray("vuelos"));
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws FileNotFoundException {
		JSONObject jobject = new JSONObject();
		
		salvarAviones(aerolinea, jobject);
		salvarRutas(aerolinea, jobject);
		salvarVuelos(aerolinea, jobject);
		
		PrintWriter pw = new PrintWriter(archivo);
		jobject.write(pw,2,0);
		pw.close();
	}
	private void cargarAviones (Aerolinea aerolinea, JSONArray javiones) throws InformacionInconsistenteException {
		int numAviones = javiones.length();
		for (int i=0; i<numAviones;i++) {
			JSONObject avion = javiones.getJSONObject(i);
			String nombreAvion = avion.getString(NOMBRE_AVION);
			int capacidad = avion.getInt(CAPACIDAD);
			Avion nuevoAvion = new Avion(nombreAvion, capacidad);
			aerolinea.agregarAvion(nuevoAvion);
		}
	}
	
	private void salvarAviones (Aerolinea aerolinea, JSONObject jobject) {
		JSONArray jAviones = new JSONArray();
		for (Avion avion:aerolinea.getAviones()) {
			JSONObject jAvion = new JSONObject();
			jAvion.put(NOMBRE_AVION, avion.getNombre());
			jAvion.put(CAPACIDAD, avion.getCapacidad());
			jAviones.put(jAvion);
		}
		jobject.put("aviones", jAviones);
	}
	
	private void cargarRutas (Aerolinea aerolinea, JSONArray jrutas) {
		int numRutas = jrutas.length();
		for (int i=0; i<numRutas; i++) {
			JSONObject ruta = jrutas.getJSONObject(i);
			String horaSalida = ruta.getString(HORA_SALIDA);
			String horaLlegada = ruta.getString(HORA_LLEGADA);
			String codigoRuta = ruta.getString(CODIGO_RUTA);
			JSONObject Origen = ruta.getJSONObject(ORIGEN);
			Aeropuerto origen = cargarAeropuerto(Origen);
			JSONObject Destino = ruta.getJSONObject(DESTINO);
			Aeropuerto destino = cargarAeropuerto(Destino);
			Ruta nuevaRuta = new Ruta(origen, destino, horaSalida, horaLlegada, codigoRuta);
			aerolinea.agregarRuta(nuevaRuta);
		}
	}
	
	private void salvarRutas(Aerolinea aerolinea, JSONObject jobject) {
		JSONArray jRutas = new JSONArray();
		for (Ruta ruta:aerolinea.getRutas()) {
			JSONObject jRuta = new JSONObject();
			jRuta.put(HORA_SALIDA, ruta.getHoraSalida() );
			jRuta.put(HORA_LLEGADA, ruta.getHoraLlegada() );
			jRuta.put(CODIGO_RUTA, ruta.getCodigoRuta());
			jRuta.put(ORIGEN, salvarAeropuerto(ruta.getOrigen()));
			jRuta.put(DESTINO, salvarAeropuerto(ruta.getDestino()));
			jRutas.put(jRuta);
		}
		jobject.put("rutas", jRutas);
	}
	
	private Aeropuerto cargarAeropuerto (JSONObject jobject) {
		String nombre = jobject.getString(NOMBRE_AEROPUERTO);
		String codigoAero = jobject.getString(CODIGO_AEROPUERTO);
		String nCiudad = jobject.getString(NOMBRE_CIUDAD);
		double latitud = jobject.getDouble(LATITUD);
		double longitud = jobject.getDouble(LONGITUD);
		return new Aeropuerto(nombre,codigoAero,nCiudad,latitud,longitud);
	}
	
	private JSONObject salvarAeropuerto (Aeropuerto aeropuerto) {
		JSONObject jobject = new JSONObject();
		jobject.put(NOMBRE_AEROPUERTO, aeropuerto.getNombre());
		jobject.put(CODIGO_AEROPUERTO, aeropuerto.getCodigo());
		jobject.put(NOMBRE_CIUDAD, aeropuerto.getNombreCiudad());
		jobject.put(LATITUD, aeropuerto.getLatitud());
		jobject.put(LONGITUD, aeropuerto.getLongitud());
		return jobject;
	}
	
	private void cargarVuelos (Aerolinea aerolinea, JSONArray jvuelos) throws InformacionInconsistenteException {
		int numVuelos = jvuelos.length();
		for (int i=0; i<numVuelos; i++) {
			JSONObject vuelo = jvuelos.getJSONObject(i);
			String codigoRuta = vuelo.getString(CODIGO_RUTA);
			if (!aerolinea.getRutas().contains(codigoRuta)) {
				throw new InformacionInconsistenteException(codigoRuta);
			}
			Ruta ruta = aerolinea.getRuta(codigoRuta);
			String fecha = vuelo.getString(FECHA_VUELO);
			String avion = vuelo.getString(NOMBRE_AVION);
			Avion elAvion = null;
			for (Avion unAvion : aerolinea.getAviones()) {
				if (unAvion.getNombre().equals(avion)) {
					elAvion = unAvion;
					break;
				}
			}
			if (elAvion == null) {
				throw new InformacionInconsistenteException(avion);
			}
			Vuelo nuevoVuelo = new Vuelo(ruta, fecha, elAvion);
			aerolinea.getVuelos().add(nuevoVuelo);
		}
	}
	
	private void salvarVuelos (Aerolinea aerolinea, JSONObject jobject) {
		JSONArray jVuelos = new JSONArray();
		for (Vuelo vuelo: aerolinea.getVuelos()) {
			JSONObject jVuelo = new JSONObject();
			jVuelo.put(CODIGO_RUTA, vuelo.getRuta().getCodigoRuta());
			jVuelo.put(FECHA_VUELO, vuelo.getFecha());
			jVuelo.put(NOMBRE_AVION, vuelo.getAvion().getNombre());
			jVuelos.put(jVuelo);
		}
		jobject.put("vuelos", jVuelos);
	}
}
