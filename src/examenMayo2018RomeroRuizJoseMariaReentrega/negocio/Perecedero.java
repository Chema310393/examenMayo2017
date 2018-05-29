package examenMayo2018RomeroRuizJoseMariaReentrega.negocio;

import java.util.regex.*;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.excepciones.*;

public class Perecedero extends Producto {

	private String caducidad;
	private static Pattern patronCaducidad= Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
	

	public Perecedero(String nombre, String caducidad) throws CaducidadNoValidaException, NombreNoValidoException {
		super(nombre);
		setCaducidad(caducidad);
	}

	private void setCaducidad(String caducidad) throws CaducidadNoValidaException {
		if(!esCaducidadValida(caducidad))
			throw new CaducidadNoValidaException("La fecha no es válida");
		this.caducidad = caducidad;
	}
	
	public String getCaducidad() {
		return caducidad;
	}
	
	public boolean esCaducidadValida(String caducidad){
		Matcher matcher= patronCaducidad.matcher(caducidad);
		return matcher.find();
	}

}
