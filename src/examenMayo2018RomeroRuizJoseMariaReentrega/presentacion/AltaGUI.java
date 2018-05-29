package examenMayo2018RomeroRuizJoseMariaReentrega.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.*;
import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.excepciones.*;

public class AltaGUI extends PadreGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AltaGUI() {
		okButton.setText("Añadir");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!txtNombre.getText().equals("")) {
						if (txtCaducida.getText().equals("")) {
							Stock.altaProducto(txtNombre.getText());
						} else {
							Stock.altaProducto(txtNombre.getText(), txtCaducida.getText());
						}
						txtNombre.setText("");
						txtCaducida.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Introduzca un nombre de producto", "Mensaje",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (ProductoYaExisteException | NombreNoValidoException | CaducidadNoValidaException e) {
					JOptionPane.showMessageDialog(contentPanel, e.getMessage());
				}
			}
		});

		cancelButton.setText("Mostrar stock");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Stock.getNumeroProductos() != 0) {
					MostrarGUI mostrarGUI = new MostrarGUI();
					mostrarGUI.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "No hay producto que mostrar", "Mensaje",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

}
