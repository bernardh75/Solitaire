import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Jeu {
	
	
	//ATTRIBUTS
	ArrayList listCartes = new ArrayList();
	ArrayList piocheJeu = new ArrayList(); 
	ArrayList pileJeu[] = new ArrayList[4]; //tab de 4 arraylist d'entiers : 1 par symbole
	ArrayList colonneJeu[] = new ArrayList[7]; // tab de 7 arrayList d'entiers.
	
	
	// constructeur
	public Jeu() {
		initialisation();
	}
	
	public void initialisation() {
		initJeuGlobal(); // creer tes 52 cartes
		//melangeCartes(); // pour melanger cartes
		initPioche();  // prend les 24 derniers cartes
		initColonne(); 
 
		// init de pile est implicite 
		
	}
	
	public void initJeuGlobal() {
		listCartes = new ArrayList();
		for (int i=1; i<=52; i++) {
			listCartes.add(i);
		}		
	}
	
	public void initPioche() {
		
		for (int ap=29; ap<=52; ap++) {
			piocheJeu.add(this.listCartes.get(ap-1));
		}
	}
	
	public void initColonne() {
		
		// prend le paquet initial et le reparti en 7 colonnes c1:1 c2:2 .... c7: 7 premieres cartes
		ArrayList lTemp = new ArrayList();
		lTemp =  listCartes;
		
		
		int ind = 0;
		for(int j=0; j<colonneJeu.length; j++) {
			colonneJeu[j] = new ArrayList();
			
			for(int k=0; k<=j; k++) {
				
				colonneJeu[j].add(lTemp.get(0));
				lTemp.remove(0);
				//colonneJeu[0].add(listCartes.get(0));
				
						
			}	
			
		}
		
		
	}

	
	
	public ArrayList getlistCartes() {
		return this.listCartes;
	}
	
	public ArrayList getPioche() {
		return this.piocheJeu;
	}

	
	public ArrayList getlistColonnes(int i) {
		return this.colonneJeu[i];
	}

	
	
	// pour la pioche
	public ArrayList pioche() {
		ArrayList res = new ArrayList();
		
		for (int ap=29; ap<=52; ap++) {
			res.add(this.listCartes.get(ap-1));
		}
		
		return res;
	} 
	
	
	//MELANGER LISTE ACTUELLE
	public void melangeCartes() {
		Collections.shuffle(this.listCartes);
	}
	public ArrayList melangeCartes(ArrayList l) {
		ArrayList res = new ArrayList();
		res = l;
		Collections.shuffle(res);
		return res;
	}
	
	// to do
	public void intro() {
	
		String res = "";
		res += "\n PROJET SOLITAIRE";
		res += "\n Auteur : Bernard Hounkonnou";
		res += "\n Date : 31 Octobre 2017";
		
		System.out.println(res);	
	}
	
	public Carte getCarteVS(int nombre) {
		String valeur=3+"";
		String symbole="carreau";
		//maj de valeur
		int a = nombre % 13;
		switch(a)
		{
		case 1 : 
			valeur="as";
			break;
		case 11 : 
			valeur="valet";
			break;
		case 12 :
			valeur="dame";
			break;
		case 0 :
			valeur="roi";
			break;
		default :
			valeur=a+"";
		}
		// maj de symbole
		int b = nombre / 13;
		switch(b)
		{
		case 0 : 
			symbole="coeur";
			break;
		case 1 : 
			symbole="carreau";
			break;
		case 2 :
			symbole="pique";
			break;
		case 3 :
		case 4 :
			symbole="trefle";
			break;
		}
		return new Carte(valeur, symbole);
		
	}
	
	public static void main(String[] args) {
		Jeu j = new Jeu();
		//j.intro();
		/*int a=1 ;
		if (a == 1) 
			return; EXIIIIITT*/
		ArrayList ltemp ;
		
		for(int k=0; k<7; k++) {
			ltemp= j.getlistColonnes(k);
			
			for (int z=0; z<ltemp.size(); z++) {
				System.out.print(ltemp.get(z) + " ");
			}
			System.out.println();
			
		}
		
		
		// TEST LE getcarte et shuffle
		/*int ip;
		for (ip=1; ip<=52; ip++) {
			System.out.println(j.getCarteVS(ip));
		}*/
		
		
		
		/*	
		VERIFIER isrouge
		Carte c = new Carte("as", "trefle");
		System.out.println(c.isRouge());
		
		Carte d = new Carte("3", "coeur");
		System.out.println(d.isRouge()); 
		 */
		
		}

}
