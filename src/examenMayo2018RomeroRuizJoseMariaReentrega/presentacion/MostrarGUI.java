package examenMayo2018RomeroRuizJoseMariaReentrega.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import examenMayo2018RomeroRuizJoseMariaReentrega.negocio.*;

public class MostrarGUI extends PadreGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListIterator<Producto> iterador = Stock.getIterator();
	private Producto producto;
	private int control = 0;

	public MostrarGUI() {
		setTitle("Stock");
		cancelButton.setText(">");
		okButton.setText("<");

		txtNombre.setEditable(false);
		txtCaducida.setEditable(false);
		controlarMovimiento();
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
				mostrar();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
				mostrar();
			}
		});
	}

	private void mostrar() {
		txtNombre.setText(producto.getNombre());
		if (producto instanceof Perecedero)
			txtCaducida.setText(((Perecedero) producto).getCaducidad());
		else
			txtCaducida.setText("");
		controlarMovimiento();
	}

	protected void siguiente() {
		if (iterador.hasNext())
			producto = iterador.next();
		if (control == 1)
			if (iterador.hasNext())
				producto = iterador.next();
		control = 0;
	}

	protected void anterior() {
		if (iterador.hasPrevious())
			producto = iterador.previous();
		if (control == 1)
			if (iterador.hasPrevious())
				producto = iterador.previous();
		control = 1;

	}

	private void controlarMovimiento() {
		if (Stock.getNumeroProductos() == 1) {
			okButton.setEnabled(false);
			cancelButton.setEnabled(false);
			return;
		}

		if (!iterador.hasNext()) {
			cancelButton.setEnabled(false);
			iterador.previous();
		} else {
			cancelButton.setEnabled(true);
		}

		if (!iterador.hasPrevious()) {
			okButton.setEnabled(false);
		} else {
			okButton.setEnabled(true);
		}
	}
}
