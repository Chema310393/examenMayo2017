package examenMayo2018RomeroRuizJoseMariaReentrega.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PadreGUI extends JDialog {

	final JPanel contentPanel = new JPanel();
	JTextField txtNombre;
	JTextField txtCaducida;
	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");

	/**
	 * Create the dialog.
	 */
	public PadreGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				switch (JOptionPane.showConfirmDialog(null, "Vas a salir del programa. ¿Estás seguro?", "Saliendo",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(null, "Adioooooooooooos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
					break;
				default:
					break;
				}
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Producto");
		setBounds(100, 100, 332, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(73, 35, 46, 14);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(129, 32, 151, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		txtCaducida = new JTextField();
		txtCaducida.setBounds(129, 63, 151, 20);
		contentPanel.add(txtCaducida);
		txtCaducida.setColumns(10);

		JLabel lblFechaCaducidad = new JLabel("Fecha caducidad");
		lblFechaCaducidad.setBounds(31, 66, 88, 14);
		contentPanel.add(lblFechaCaducidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

				buttonPane.add(cancelButton);
			}
		}

	}

}
