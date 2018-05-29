package examenMayo2018RomeroRuizJoseMariaReentrega.negocio;

import java.util.ArrayList;
import java.util.ListIterator;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.excepciones.*;

public class Stock {

	private static ArrayList<Producto> almacen = new ArrayList<Producto>();

	public static void altaProducto(String nombreProducto) throws ProductoYaExisteException, NombreNoValidoException {
		Producto producto = new Producto(nombreProducto);
		if (almacen.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe");
		almacen.add(producto);
	}

	public static void altaProducto(String nombre, String fechaCaducidad)
			throws ProductoYaExisteException, NombreNoValidoException, CaducidadNoValidaException {
		Perecedero perecedero = new Perecedero(nombre, fechaCaducidad);
		if (almacen.contains(perecedero))
			throw new ProductoYaExisteException("El producto ya existe");
		almacen.add(perecedero);
	}

	public static ListIterator<Producto> getIterator() {
		return almacen.listIterator();
	}

	public static int getNumeroProductos() {
		return almacen.size();
	}

}
