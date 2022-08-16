package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Envio;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FormularioAlta extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private List<Envio> listaEnvios;
	private JComboBox<Envio>  comboEnvio;
	private JRadioButton rdbtnOrigenExtranjero;
	private JRadioButton rdbtnOrigenNacional;
	private JRadioButton rdbtnDestinoNacional;
	private JRadioButton rdbtnDestinoExtranjero;
	private JSpinner peso;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlta frame = new FormularioAlta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAlta() {
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Calculadora envíos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[grow][][][][][][][grow][][][][grow][grow][grow][grow][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Ciudad Origen");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		txtOrigen = new JTextField();
		txtOrigen.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtOrigen, "cell 1 0,grow");
		txtOrigen.setColumns(10);
		
		rdbtnOrigenNacional = new JRadioButton("Nacional");
		rdbtnOrigenNacional.setSelected(true);
		rdbtnOrigenNacional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOrigenNacional.isSelected()) {
					rdbtnOrigenExtranjero.setSelected(false);
				}
			}
		});
		contentPane.add(rdbtnOrigenNacional, "flowx,cell 1 1");
		
		rdbtnOrigenExtranjero = new JRadioButton("Extranjero");
		rdbtnOrigenExtranjero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOrigenExtranjero.isSelected()) {
					rdbtnOrigenNacional.setSelected(false);
				}
			}
		});
		contentPane.add(rdbtnOrigenExtranjero, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Ciudad Destino:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		txtDestino = new JTextField();
		txtDestino.setMaximumSize(new Dimension(2147483647, 35));
		contentPane.add(txtDestino, "cell 1 2,grow");
		txtDestino.setColumns(10);
		
		rdbtnDestinoNacional = new JRadioButton("Nacional");
		rdbtnDestinoNacional.setSelected(true);
		rdbtnDestinoNacional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDestinoNacional.isSelected()) {
					rdbtnDestinoExtranjero.setSelected(false);
				}
			}
		});
		contentPane.add(rdbtnDestinoNacional, "flowx,cell 1 3");
		
		rdbtnDestinoExtranjero = new JRadioButton("Extranjero");
		rdbtnDestinoExtranjero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDestinoExtranjero.isSelected()) {
					rdbtnDestinoNacional.setSelected(false);
				}
			}
		});
		contentPane.add(rdbtnDestinoExtranjero, "cell 1 3");
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de envío:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		comboEnvio = new JComboBox<Envio>();
		comboEnvio.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10 h", "Paq 14 - Antes de las 14 h", "Paq 24 - Al día siguiente"}));
		comboEnvio.setMaximumSize(new Dimension(32767, 35));
		contentPane.add(comboEnvio, "cell 1 4,grow");
		
		JLabel lblNewLabel_5 = new JLabel("Peso:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		
		peso = new JSpinner();
		peso.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		peso.setPreferredSize(new Dimension(50, 20));
		contentPane.add(peso, "flowx,cell 1 5");
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		contentPane.add(btnCalcularPrecio, "cell 0 6 2 1,alignx center");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		btnCalcularPrecio.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel("Kg");
		contentPane.add(lblNewLabel_1, "cell 1 5");
	}

	public void setListaEnvios(List<Envio> listaEnvios) {
		this.listaEnvios = listaEnvios;
		
		DefaultComboBoxModel<Envio> modelo = 
				new DefaultComboBoxModel<>();
		
		modelo.addAll(listaEnvios);
		comboEnvio.setModel(modelo);
		comboEnvio.setSelectedIndex(0);
	}
	
	public void comprobar() {
		String Destino = txtDestino.getText();
		String Origen = txtOrigen.getText();
		
		if(Destino.equals("") || Origen.equals("")) {
			JOptionPane.showMessageDialog(this, 
					"Debe Rellenar los datos de Destino y Origen.");
		}else {
			boolean origenNacional = rdbtnOrigenNacional.isSelected();
			boolean destinoNacional = rdbtnDestinoNacional.isSelected();
			String tipoEnvio = (String) comboEnvio.getSelectedItem();
			int pesoEnvio = (int) peso.getValue();
			
			Envio Envio = new Envio(Origen, origenNacional, Destino, destinoNacional, tipoEnvio, pesoEnvio);
			
			Envio.calcularImporte();
		}
	}
	
}
