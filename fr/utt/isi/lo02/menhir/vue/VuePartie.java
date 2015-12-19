package fr.utt.isi.lo02.menhir.vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.utt.isi.lo02.menhir.controleur.Controleur;
import fr.utt.isi.lo02.menhir.modele.joueur.Joueur;
import fr.utt.isi.lo02.menhir.modele.partie.Partie;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Mathieu DELALANDE, Nicolas Granet
 *
 */
public class VuePartie extends JFrame implements Observer{
	
	private Partie partie;
	private Controleur controleur;
	private JPanel container;
	private JPanel vueAjouterJoueur;

	/**
	 * Le constructeur de la classe VuePartie permet la création de la fenêtre du programme
	 * @param p
	 * @param c
	 */
	public VuePartie(Partie p, Controleur c){
		this.partie=p;
		this.controleur=c;
		partie.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(container);
		container.setLayout(null);
		this.initContentPane();
		
	}
	
	/**
	 * La méthode initContentPane permet d'initialiser le ContentePane
	 */
	public void initContentPane(){
		JLabel lblJeuDuMenhirs = new JLabel("Jeu du menhir");
		lblJeuDuMenhirs.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJeuDuMenhirs.setBounds(163, 11, 97, 17);
		container.add(lblJeuDuMenhirs);
		
		JComboBox<Integer> comboBoxNbHumain = new JComboBox<Integer>();
		comboBoxNbHumain.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6}));
		comboBoxNbHumain.setBounds(214, 91, 46, 20);
		container.add(comboBoxNbHumain);
		
		JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs humains");
		lblNombreDeJoueurs.setBounds(10, 94, 183, 14);
		container.add(lblNombreDeJoueurs);
		
		JLabel lblNombreDeJoueurs_1 = new JLabel("Nombre de joueurs IA");
		lblNombreDeJoueurs_1.setBounds(10, 119, 183, 14);
		container.add(lblNombreDeJoueurs_1);
		
		JComboBox<Integer> comboBoxNbIA = new JComboBox<Integer>();
		comboBoxNbIA.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3,4,5}));
		comboBoxNbIA.setMaximumRowCount(5);
		comboBoxNbIA.setBounds(214, 116, 46, 20);
		container.add(comboBoxNbIA);
		
		JLabel lblTypeDePartie = new JLabel("Type de partie");
		lblTypeDePartie.setBounds(10, 151, 136, 14);
		container.add(lblTypeDePartie);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("rapide");
		rdbtnNewRadioButton.setBounds(215, 147, 79, 23);
		container.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("avanc\u00E9e\r\n");
		rdbtnNewRadioButton_1.setBounds(305, 147, 109, 23);
		container.add(rdbtnNewRadioButton_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterJoueur((int)comboBoxNbHumain.getSelectedItem(),(int)comboBoxNbIA.getSelectedItem());
			}
		});
		btnOk.setBounds(171, 227, 89, 23);
		container.add(btnOk);
		
		JLabel lblJoueursMaximum = new JLabel("2 \u00E0 6 joueurs");
		lblJoueursMaximum.setBounds(10, 69, 183, 14);
		container.add(lblJoueursMaximum);
			
		this.setVisible(true);
	}
	
	/**
	 * La méthode ajouterJoueur permet d'ajouter les vues d'ajout de chacun des joueurs
	 * 
	 * @param nbJoueursHumain
	 * @param nbJoueursIA
	 */
	public void ajouterJoueur(int nbJoueursHumain, int nbJoueursIA){
		int i =0;
		//on supprime les composants du contentPane
		container.removeAll();
		container.repaint();
		
		JLabel lblJoueurs = new JLabel("Veuillez remplir les informations des joueurs");
		lblJoueurs.setBounds(80, 0, 350, 17);
		container.add(lblJoueurs);
		
		//on ajoute les vues pour les joueurs humains
		JLabel lblJoueursH = new JLabel("joueurs humains :");
		lblJoueursH.setBounds(10,30, 183, 14);
		container.add(lblJoueursH);
		
		ArrayList<VueAjouterJoueurHumain> listeAjouterH = new ArrayList<VueAjouterJoueurHumain>();
		for (i=0; i<nbJoueursHumain; i++){
			listeAjouterH.add(new VueAjouterJoueurHumain());			
		}
		i=45;
		for (Iterator<VueAjouterJoueurHumain> it = listeAjouterH.iterator(); it.hasNext();){			
			VueAjouterJoueurHumain vH = (VueAjouterJoueurHumain) it.next();
			vH.setBounds(0, i, 450, 39);
			container.add(vH);
			i+=40;
		}
		
		
		//on ajoute les vues pour les joueurs IA
		JLabel lblJoueursIA = new JLabel("joueurs IA :");
		lblJoueursIA.setBounds(10,i+10, 183, 14);
		container.add(lblJoueursIA);
		ArrayList<VueAjouterJoueurIA> listeAjouterIA = new ArrayList<VueAjouterJoueurIA>();
		for (int j=0; j<nbJoueursIA; j++){			
			listeAjouterIA.add(new VueAjouterJoueurIA());			
		}		
		i+=25;
		for (Iterator<VueAjouterJoueurIA> it = listeAjouterIA.iterator(); it.hasNext();){			
			VueAjouterJoueurIA vH = (VueAjouterJoueurIA) it.next();
			vH.setBounds(0, i, 450, 39);
			container.add(vH);
			i+=40;
		}
		
		this.setVisible(true);	
		
	}
	
	public void update(Observable arg0, Object arg1){
		
	}
}
