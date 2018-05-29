package examenMayo2018RomeroRuizJoseMariaReentrega.presentacion;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JOptionPane;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.Fichero;
import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.excepciones.FicheroNoExisteException;

public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leer();
					escribir();
					altaProducto();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void altaProducto() {
		AltaGUI alta = new AltaGUI();
		alta.setVisible(true);
	}

	private static void escribir() {
		try {
			if (Fichero.existeFichero())
				JOptionPane.showMessageDialog(null, "Voy a machacar el fichero");
			Fichero.escribir();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void leer() {
		try {
			JOptionPane.showMessageDialog(null, Fichero.leer());
		} catch (FicheroNoExisteException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
