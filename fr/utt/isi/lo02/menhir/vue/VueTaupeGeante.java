package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.utt.isi.lo02.menhir.modele.partie.Partie;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe qui créé une fenêtre de dialogue pour la carte Taupe Géante
 * @author Mathieu DELALANDE, Nicolas Granêt
 */
public class VueTaupeGeante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel buttonPane;
	private JLabel lblVoulezvousJouerVotre;
	private JLabel lblChoisissezLeJoueur;
	private JComboBox<String> comboBox;
	private JButton btnOui;
	private JButton btnNon;

	/**
	 * Constructeur de la fenêtre de dialogue 
	 * @param value La valeur de la carte jouée
	 * @param p La partie associée
	 */
	public VueTaupeGeante(int value, Partie p) {
		setBounds(100, 100, 450, 300);
		{
			panel = new JPanel();
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
		);
		{
			btnNon = new JButton("Non");
			btnNon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		{
			btnOui = new JButton("Oui");
			btnOui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGap(148)
					.addComponent(btnOui)
					.addGap(58)
					.addComponent(btnNon)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOui)
						.addComponent(btnNon))
					.addContainerGap())
		);
		buttonPane.setLayout(gl_buttonPane);
		{
			lblChoisissezLeJoueur = new JLabel("Choisissez le joueur \u00E0 attaquer :");
		}
		
		comboBox = new JComboBox<String>();
		String nomJoueur[] = new String[p.ordreJeu.size()];
		for(int i=0; i<p.ordreJeu.size();i++){			
			nomJoueur[i] = p.ordreJeu.get(i).getNom();					
		}		
		comboBox.setModel(new DefaultComboBoxModel<String>(nomJoueur));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChoisissezLeJoueur, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChoisissezLeJoueur, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			lblVoulezvousJouerVotre = new JLabel("Voulez-vous jouer votre carte Taupe Geante de valeur : " + value);
			lblVoulezvousJouerVotre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		panel.setLayout(new CardLayout(0, 0));
		panel.add(lblVoulezvousJouerVotre, "name_20014092206573");
		getContentPane().setLayout(groupLayout);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
