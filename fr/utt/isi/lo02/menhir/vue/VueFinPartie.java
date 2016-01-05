package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Iterator;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import fr.utt.isi.lo02.menhir.controleur.ControleurVue;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

public class VueFinPartie extends JPanel {
	/**
	 * Create the panel.
	 */
	public VueFinPartie(Partie p) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
		);
		panel_2.setLayout(new GridLayout(6, 0, 0, 0));
		
		//Affiche les scores des joueurs
		for (Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur joueur = (Joueur) it.next();
			panel_2.add(jLabelScore(joueur));
		}		
		
		
		JLabel lblLeGagnantEst = new JLabel("Le gagnant est donc : " + p.ordreJeu.get(0).getNom());
		lblLeGagnantEst.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(55)
					.addComponent(lblLeGagnantEst, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(19)
					.addComponent(lblLeGagnantEst, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFinDeLa = new JLabel("Fin de la partie");
		lblFinDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblFinDeLa);
		panel.setLayout(gl_panel);

	}
	
	/**
	 * Affiche le score d'un joueur dans un label
	 * @param j Le joueur pour lequel afficher le score
	 * @return Le label composé du scrore
	 */
	public JLabel jLabelScore(Joueur j){
		JLabel lblNewLabel = new JLabel("Nom : " +j.getNom()+ "             Nombre de graines : " +j.getNbGraines()+"             Nombre de Menhirs : " +j.getNbMenhir()
		+"             Nombre de points : "+j.getNbPoints());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		return lblNewLabel;
	}

}
