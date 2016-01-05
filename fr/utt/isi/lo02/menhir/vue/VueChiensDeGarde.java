package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.utt.isi.lo02.menhir.controleur.ControleurVue;
import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe qui créé une fenêtre de dialogue pour la carte chiens de garde
 * @author Mathieu DELALANDE, Nicolas Granêt
 *
 */
public class VueChiensDeGarde extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel buttonPane;
	private JLabel lblVoulezvousJouerChiens;
	
	/**
	 * Constructeur de la fenêtre de dialogue 
	 * @param joueurSuivant Le joueur qui joue après
	 * @param joueurActif Le joueur qui vient de jouer
	 * @param joueurAttaque Le joueur qui se fait attaquer
	 * @param value La valeur de la carte jouée
	 * @param p La partie associée
	 * @param valueDef La valeur de la carte Chien de Garde
	 */
	public VueChiensDeGarde(int joueurSuivant, Joueur joueurActif, Joueur joueurAttaque, int value, Partie p, int valueDef, ControleurVue c, VuePartie vp, int numCarte) {
		setBounds(100, 100, 450, 300);
		{
			panel = new JPanel();
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
		}
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(contentPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		
		JLabel lblValeurDeLattaque = new JLabel("Valeur de l'attaque : " + value);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addComponent(lblValeurDeLattaque, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(136))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(lblValeurDeLattaque, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblValeurDeVotre = new JLabel("Valeur de votre carte :" + valueDef);
		lblValeurDeVotre.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(136)
					.addComponent(lblValeurDeVotre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblValeurDeVotre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			lblVoulezvousJouerChiens = new JLabel("Voulez-vous jouer Chiens de Garde ?");
			lblVoulezvousJouerChiens.setHorizontalAlignment(SwingConstants.CENTER);
		}
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addComponent(lblVoulezvousJouerChiens, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblVoulezvousJouerChiens, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueDef >= value){
					joueurActif.getCarteIngredientJoueur().remove(numCarte-1);
				}
				else if (joueurAttaque.getNbGraines() + valueDef >= value){
					joueurActif.setNbGraines(joueurActif.getNbGraines()+ value - valueDef);
					joueurAttaque.setNbGraines(joueurAttaque.getNbGraines()- value + valueDef);
					joueurActif.getCarteIngredientJoueur().remove(numCarte-1);
				}
				else{
					joueurActif.setNbGraines(joueurActif.getNbGraines()+ joueurAttaque.getNbGraines());
					joueurAttaque.setNbGraines(0);
					joueurActif.getCarteIngredientJoueur().remove(numCarte-1);
				}
				if (joueurSuivant == 666)
					c.finTour();
				else
					if (p.ordreJeu.get(joueurSuivant).getCarteAllieJoueur() != null && p.ordreJeu.get(joueurSuivant).getCarteAllieJoueur().getNom() != "")    					 						
						vp.vueManche(p.ordreJeu.get(joueurSuivant), p, true);
					else
						vp.vueManche(p.ordreJeu.get(joueurSuivant), p, false);
				joueurAttaque.setCarteAllieJoueur(new CarteAllie("",null));
				setVisible(false);
				vp.setVisible(true);
			}
		});
		
		JButton btnNon = new JButton("Non");
		btnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (joueurAttaque.getNbGraines() >= value){
					joueurActif.setNbGraines(joueurActif.getNbGraines()+ value);
					joueurAttaque.setNbGraines(joueurAttaque.getNbGraines()- value);
					joueurActif.getCarteIngredientJoueur().remove(numCarte-1);
				}
				else{
					joueurActif.setNbGraines(joueurActif.getNbGraines()+ joueurAttaque.getNbGraines());
					joueurAttaque.setNbGraines(0);
					joueurActif.getCarteIngredientJoueur().remove(numCarte-1);
				}
				setVisible(false);
				vp.setVisible(true);
			}
		});
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPane.createSequentialGroup()
					.addGap(110)
					.addComponent(btnOui)
					.addGap(100)
					.addComponent(btnNon)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOui)
						.addComponent(btnNon))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		buttonPane.setLayout(gl_buttonPane);
		getContentPane().setLayout(groupLayout);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
