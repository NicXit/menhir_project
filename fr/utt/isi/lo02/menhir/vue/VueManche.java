package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JToggleButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import fr.utt.isi.lo02.menhir.controleur.ControleurVue;
import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Classe qui crée la vue quand on lance la partie
 * @author Mathieu DELALANDE, Nicolas GRANET
 *
 */
public class VueManche extends JPanel {
	private JPanel panel_4;
	
	/**
	 * Constructeur, crée le panel général
	 * @param j Le joueur qui joue
	 * @param p La partie associée à la fenêtre
	 */
	public VueManche(Joueur j, Partie p, ControleurVue c) {
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_902101674402135");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		JLabel label = new JLabel("C'est au tour de "+j.getNom()+" de jouer");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_1 = new JLabel("Manche : " +p.getNumManche());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Saison : " +p.getSaison());
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(243, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(240))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		

		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {116, 116, 116, 116, 116};
		gbl_panel_4.rowHeights = new int[] {30, 96, 30, 0, 20};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblCartesIngrdients = new JLabel("Cartes ingr\u00E9dients");
		lblCartesIngrdients.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCartesIngrdients = new GridBagConstraints();
		gbc_lblCartesIngrdients.gridwidth = 4;
		gbc_lblCartesIngrdients.fill = GridBagConstraints.VERTICAL;
		gbc_lblCartesIngrdients.insets = new Insets(0, 0, 5, 5);
		gbc_lblCartesIngrdients.gridx = 0;
		gbc_lblCartesIngrdients.gridy = 0;
		panel_4.add(lblCartesIngrdients, gbc_lblCartesIngrdients);	
		
		jLabelIngredient(j, panel_4);
		ButtonGroup groupAction = new ButtonGroup();
		
		JLabel lblCartes = new JLabel("Cartes");
		GridBagConstraints gbc_lblCartes = new GridBagConstraints();
		gbc_lblCartes.anchor = GridBagConstraints.EAST;
		gbc_lblCartes.insets = new Insets(0, 0, 5, 5);
		gbc_lblCartes.gridx = 0;
		gbc_lblCartes.gridy = 2;
		panel_4.add(lblCartes, gbc_lblCartes);
		
		JRadioButton rdbtnGant = new JRadioButton("G\u00E9ant");
		rdbtnGant.setSelected(true);
		GridBagConstraints gbc_rdbtnGant = new GridBagConstraints();
		gbc_rdbtnGant.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnGant.gridx = 0;
		gbc_rdbtnGant.gridy = 3;
		panel_4.add(rdbtnGant, gbc_rdbtnGant);
		groupAction.add(rdbtnGant);
		
		JRadioButton rdbtnEngrais = new JRadioButton("Engrais");
		GridBagConstraints gbc_rdbtnEngrais = new GridBagConstraints();
		gbc_rdbtnEngrais.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnEngrais.gridx = 1;
		gbc_rdbtnEngrais.gridy = 3;
		panel_4.add(rdbtnEngrais, gbc_rdbtnEngrais);
		groupAction.add(rdbtnEngrais);
		
		JRadioButton rdbtnFarfadets = new JRadioButton("Farfadets");
		GridBagConstraints gbc_rdbtnFarfadets = new GridBagConstraints();
		gbc_rdbtnFarfadets.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnFarfadets.gridx = 2;
		gbc_rdbtnFarfadets.gridy = 3;
		panel_4.add(rdbtnFarfadets, gbc_rdbtnFarfadets);
		groupAction.add(rdbtnFarfadets);
		
		
		JComboBox<String> comboBoxNomJoueurs = new JComboBox<String>();
		String nomJoueur[] = new String[p.ordreJeu.size()];
		for(int i=0; i<p.ordreJeu.size();i++){			
			nomJoueur[i] = p.ordreJeu.get(i).getNom();					
		}		
		comboBoxNomJoueurs.setModel(new DefaultComboBoxModel(nomJoueur));
		GridBagConstraints gbc_comboBoxJoueurs = new GridBagConstraints();
		gbc_comboBoxJoueurs.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxJoueurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxJoueurs.gridx = 3;
		gbc_comboBoxJoueurs.gridy = 3;
		panel_4.add(comboBoxNomJoueurs, gbc_comboBoxJoueurs);
		
		Integer choixCarte[] = new Integer[j.getCarteIngredientJoueur().size()];
		for(int i=0; i<j.getCarteIngredientJoueur().size();i++){
			choixCarte[i] = i+1;
		}
		JComboBox<Integer> comboBoxCartes = new JComboBox<Integer>();
		comboBoxCartes.setModel(new DefaultComboBoxModel<Integer>(choixCarte));
		GridBagConstraints gbc_comboBoxCartes = new GridBagConstraints();
		gbc_comboBoxCartes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCartes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCartes.gridx = 1;
		gbc_comboBoxCartes.gridy = 2;
		panel_4.add(comboBoxCartes, gbc_comboBoxCartes);
		
		
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));		
		JLabel lblScores = new JLabel("Scores");
		lblScores.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblScores);		
		
		//Affiche les scores des joueurs
		for (Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur joueur = (Joueur) it.next();
			panel_3.add(jLabelScore(joueur));
		}
		
		JButton btnJouer = new JButton("Jouer");		
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				c.validationJoueur(j,rdbtnEngrais.isSelected(),rdbtnFarfadets.isSelected(), (String)comboBoxNomJoueurs.getSelectedItem(),
						(int)comboBoxCartes.getSelectedItem());
				if(p.ordreJeu.get(p.ordreJeu.size()-1)==j){
					c.finTour();
				}
			}
		});
		panel_5.add(btnJouer);
		
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
	
	/**
	 * Affiche les cartes ingrédients d'un joueur dans dans un JTextArea et ajoute l'affichage au panel entré en paramètre 
	 * @param j Le joueur pour lequel afficher les cartes ingrédients
	 * @param panel Le panel qui ajoutera le résultat
	 */
	public void jLabelIngredient(Joueur j, JPanel panel){
		int i=0;
		for(Iterator<CarteIngredient> it = j.getCarteIngredientJoueur().iterator(); it.hasNext();){
			CarteIngredient carte = (CarteIngredient) it.next();
			
			JTextArea lblNewLabel = new JTextArea();
			lblNewLabel.setBackground(SystemColor.control);
			lblNewLabel.setEditable(false);
			lblNewLabel.setEditable(false);
			lblNewLabel.setText(carte.toString());
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();	
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = i;
			gbc_lblNewLabel.gridy = 1;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			i++;
		}	
	}
	
	/**
	 * Affiche la carte Alliés d'un joueur dans un JTextArea et ajoute le résultat dans le panel_4
	 * @param carte La carte Alliés à afficher
	 */
	public void jLabelAlliés(CarteAllie carte){
		JLabel lblCarteAllis = new JLabel("Carte Alli\u00E9s");
		GridBagConstraints gbc_lblCarteAllis = new GridBagConstraints();
		gbc_lblCarteAllis.fill = GridBagConstraints.VERTICAL;
		gbc_lblCarteAllis.gridwidth = 3;
		gbc_lblCarteAllis.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarteAllis.gridx = 4;
		gbc_lblCarteAllis.gridy = 0;
		panel_4.add(lblCarteAllis, gbc_lblCarteAllis);
		
		JTextArea lblNewLabel = new JTextArea();
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setEditable(false);
		lblNewLabel.setEditable(false);
		lblNewLabel.setText(carte.toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();	
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
	}

}
