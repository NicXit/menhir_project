package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.controleur.ControleurVue;
import fr.utt.isi.lo02.menhir.modele.joueur.Humain;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe qui crée une fenêtre de dialogue pour demander à l'utilisateur s'il veut 2 graines ou une carte Alliés
 * @author Mathieu DELALANDE, Nicolas Granêt
 *
 */
public class VueChoixPartieAvancee extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControleurVue controleur;
	
	/**
	 * Constructeur, crée la fenêtre de dialogue.
	 * @param j Le joueur à qui s'adresse la fenêtre
	 * @param c Le controleur associé à la fenêtre
	 */
	public VueChoixPartieAvancee(Joueur j, ControleurVue c) {
		this.controleur=c;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 391, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(j.getNom() + " veuillez choisir entre 2 graines ou une carte Alli\u00E9s");
		lblNewLabel.setBounds(40, 11, 298, 37);
		contentPanel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Graines");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(67, 55, 125, 37);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Carte Alli\u00E9s");
		rdbtnNewRadioButton_1.setBounds(244, 55, 125, 37);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER, 5, 5);
			buttonPane.setLayout(fl_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controleur.initCarteAllies(j, rdbtnNewRadioButton.isSelected());
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setVisible(true);
	}
}
