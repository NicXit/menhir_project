package fr.utt.isi.lo02.menhir.vue;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JToggleButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import fr.utt.isi.lo02.menhir.modele.carte.CarteAllie;
import fr.utt.isi.lo02.menhir.modele.carte.CarteIngredient;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
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

public class VueManche extends JPanel {
	private JPanel panel_4;
	/**
	 * Create the panel.
	 */
	public VueManche(Joueur j, Partie p) {
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
		
		JButton btnJouer = new JButton("Jouer");
		panel_5.add(btnJouer);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {116, 116, 116, 116, 116};
		gbl_panel_4.rowHeights = new int[] {30, 116, 20, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblCarteAllis = new JLabel("Carte Alli\u00E9s");
		GridBagConstraints gbc_lblCarteAllis = new GridBagConstraints();
		gbc_lblCarteAllis.fill = GridBagConstraints.VERTICAL;
		gbc_lblCarteAllis.gridwidth = 3;
		gbc_lblCarteAllis.insets = new Insets(0, 0, 5, 0);
		gbc_lblCarteAllis.gridx = 4;
		gbc_lblCarteAllis.gridy = 0;
		panel_4.add(lblCarteAllis, gbc_lblCarteAllis);
		
		jLabelIngredient(j, panel_4);
		
		ArrayList<JRadioButton> arjr = new  ArrayList<JRadioButton>();
		ArrayList<GridBagConstraints> argbc = new ArrayList<GridBagConstraints>();
		ButtonGroup group = new ButtonGroup();	
		
		for(int i=0;i<j.getCarteIngredientJoueur().size();i++){			 
			arjr.add(new JRadioButton(""));
			arjr.get(0).setSelected(true);
			group.add(arjr.get(i));			
			GridBagConstraints gbc_radioButton = new GridBagConstraints();
			gbc_radioButton.fill = GridBagConstraints.VERTICAL;
			gbc_radioButton.insets = new Insets(0, 0, 0, 5);
			gbc_radioButton.gridx = i;
			gbc_radioButton.gridy = 2;
			argbc.add(gbc_radioButton);
			panel_4.add(arjr.get(i), argbc.get(i));
		}
		
		
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));		
		JLabel lblScores = new JLabel("Scores");
		lblScores.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblScores);		
		
		for (Iterator<Joueur> it = p.ordreJeu.iterator(); it.hasNext();){
			Joueur joueur = (Joueur) it.next();
			panel_3.add(jLabelScore(joueur));
		}
		
		panel.setLayout(gl_panel);

	}
	
	public JLabel jLabelScore(Joueur j){
		JLabel lblNewLabel = new JLabel("Nom : " +j.getNom()+ "             nombre de graines : " +j.getNbGraines()+"             Nombre de Menhirs : " +j.getNbMenhir());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		return lblNewLabel;
	}
	
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
	
	public void jLabelAlli�s(CarteAllie carte, JPanel panel){
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
		panel.add(lblNewLabel, gbc_lblNewLabel);
	}

	public JPanel getPanel_4() {
		return panel_4;
	}
	
	
	
}
