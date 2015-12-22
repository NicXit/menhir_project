package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

import java.awt.TextField;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 * Classe qui crée un panel avec les champs pour la saisie d'un joueur humain
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class VueAjouterJoueurHumain extends JPanel {
	private JTextField textField;
	JFormattedTextField formattedTextField ;
	JComboBox<String> comboBox; 
	
	/**
	 * Constructeur, crée le panel
	 */
	public VueAjouterJoueurHumain() {		
		
		setLayout(null);		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 11, 46, 14);
		add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(55, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(183, 11, 46, 14);
		add(lblAge);
		
		formattedTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		formattedTextField.setBounds(235, 8, 27, 20);
		add(formattedTextField);
		
		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setBounds(285, 11, 46, 14);
		add(lblSexe);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"masculin", "f\u00E9minin"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(344, 8, 79, 20);
		add(comboBox);
		
		
		
	}
	
	public String getItemNom(){
		return textField.getText();
	}
	public String getItemAge(){
		return formattedTextField.getText();
	}
	public String getItemSexe(){
		return (String) comboBox.getSelectedItem();
	}
}
