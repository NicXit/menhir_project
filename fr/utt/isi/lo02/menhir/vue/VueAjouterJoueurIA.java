package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Classe qui crée un panel contenant les champs pour ajouter un joueur IA
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class VueAjouterJoueurIA extends JPanel{
	private JTextField textField;
	
	/**
	 * Constructeur, crée le panel avec le label nom et le champs pour récupérer l'information
	 */
	public VueAjouterJoueurIA(){
		setLayout(null);		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 11, 46, 14);
		add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(55, 8, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
	
	public String getItemNom(){
		return textField.getText();
	}
}
