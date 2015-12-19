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

public class VuePartie extends JFrame implements Observer{
	
	private Partie partie;
	private Controleur controleur;
	private JPanel container;
	private JPanel vueAjouterJoueur;

	/**
	 * Create the frame.
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
	public void initContentPane(){
		JLabel lblJeuDuMenhirs = new JLabel("Jeu du menhir");
		lblJeuDuMenhirs.setFont(new Font("Calibri", Font.BOLD, 14));
		lblJeuDuMenhirs.setBounds(163, 11, 97, 17);
		container.add(lblJeuDuMenhirs);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6}));
		comboBox.setBounds(214, 91, 46, 20);
		container.add(comboBox);
		
		JLabel lblNombreDeJoueurs = new JLabel("Nombre de joueurs humains");
		lblNombreDeJoueurs.setBounds(10, 94, 183, 14);
		container.add(lblNombreDeJoueurs);
		
		JLabel lblNombreDeJoueurs_1 = new JLabel("Nombre de joueurs IA");
		lblNombreDeJoueurs_1.setBounds(10, 119, 183, 14);
		container.add(lblNombreDeJoueurs_1);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0,1,2,3,4,5}));
		comboBox_1.setMaximumRowCount(5);
		comboBox_1.setBounds(214, 116, 46, 20);
		container.add(comboBox_1);
		
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
				ajouterJoueur((int)comboBox.getSelectedItem());
			}
		});
		btnOk.setBounds(171, 227, 89, 23);
		container.add(btnOk);
		
		JLabel lblJoueursMaximum = new JLabel("2 \u00E0 6 joueurs");
		lblJoueursMaximum.setBounds(10, 69, 183, 14);
		container.add(lblJoueursMaximum);
			
		this.setVisible(true);
	}
	
	public void ajouterJoueur(int nbJoueursHumain){
		int i =0;
		container.removeAll();
		container.repaint();
		
		ArrayList<VueAjouterJoueurHumain> listeAjouterH = new ArrayList<VueAjouterJoueurHumain>();				
		
		for (i=0; i<nbJoueursHumain; i++){
			listeAjouterH.add(new VueAjouterJoueurHumain(partie, controleur));			
		}

		i=0;
		for (Iterator<VueAjouterJoueurHumain> it = listeAjouterH.iterator(); it.hasNext();){			
			VueAjouterJoueurHumain vH = (VueAjouterJoueurHumain) it.next();
			vH.setBounds(0, i, 450, 39);
			container.add(vH);
			i+=40;
		}
		
		this.setVisible(true);

		
		
	}
	
	public void update(Observable arg0, Object arg1){
		
	}
}
