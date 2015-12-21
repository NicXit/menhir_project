package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueAjouterJoueurIA extends JPanel{
	private JTextField textField;
	
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
