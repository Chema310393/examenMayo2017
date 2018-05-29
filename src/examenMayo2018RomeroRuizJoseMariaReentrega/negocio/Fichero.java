package examenMayo2018RomeroRuizJoseMariaReentrega.negocio;

import java.io.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.excepciones.FicheroNoExisteException;

public class Fichero {
	private final static File FICHERO=new File("joseMariaRomero.txt");
	
	public static String leer() throws FicheroNoExisteException, FileNotFoundException, IOException {
	    String mensaje = "";
	    String linea;
	    if (!existeFichero())
	      throw new FicheroNoExisteException("No hay ningún fichero que leer.");
	    try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
	      while ((linea = br.readLine()) != null)
	        mensaje += linea + "\n";
	      return mensaje;
	    }
	  }
	
	public static void escribir() throws FileNotFoundException, IOException {

		LocalDate fecha = LocalDate.now();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
			bw.write("Bienvenido al examen final");
			bw.newLine();
			bw.write(fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " de " + fecha.getYear());
			bw.newLine();
			bw.write("Hoy es día " + fecha.getDayOfMonth() + ", "
					+ fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()) + ".");
			bw.newLine();
			bw.write("José María Romero Ruiz");
		}

	}
	
	public static boolean existeFichero(){
		return FICHERO.exists();
	}
	
	

}
