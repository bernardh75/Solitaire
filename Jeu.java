import java.util.*;

public class Jeu {
	
	
	//ATTRIBUTS
	ArrayList listCartes = new ArrayList();
	ArrayList piocheJeu = new ArrayList(); 
	ArrayList pileJeu[] = new ArrayList[4]; //tab de 4 arraylist d'entiers : 1 par symbole
	ArrayList colonneJeu[] = new ArrayList[7]; // tab de 7 arrayList d'entiers.
	int instanceJeu;
	
	// constructeur
	public Jeu() {
		jouer();
		//initialisation();
	}
	
	public void jouer() {
		instanceJeu++; // maj de l instance du jeu 
		sommaire(instanceJeu); // introduction du jeu ...
		
		initialisation();  // initialise pioche, piles et colonnes 
		System.out.println("\n");
		
		displayEtatCarteJeu();
		System.out.println("\n");
		
		System.out.println("Choix possibles :");
		System.out.println("1 : Prendre une carte de la pioche");
		System.out.println("2 : Prendre une carte des piles");
		System.out.println("3 : Prendre une (ou des) carte(s) des colonnes");
		
		int choix =0;
		
		do {
			System.out.print("Votre choix : ");

			 Scanner clavier =  new Scanner(System.in);
			
			try {
				choix = clavier.nextInt();
			}
			catch(Exception e) {
				System.out.println("impossible");
				choix = -1;
								
			}
			
		} while(choix > 10 || choix < 1);
		
		//switch(choix) {
			//case.getClass()..
			
		
		switch(choix)
		{
		case 1 : 
			methode1();
			break;
		case 2 : 
			methode2();
			break;
		case 3 :
			methode3();
			break;
		case 4 :
			methode4();
			break;
		//default :
		//	methodeDefaut();
		}
		
		
		
		//}
		
//		System.out.println("Choix possibles :");
//		System.out.println("1 : Prendre une carte de la pioche");
//		System.out.println("2 : Prendre une carte des piles");
//		System.out.println("3 : Prendre une (ou des) carte(s) des colonnes");
//		System.out.println("4 : Afficher l'état du jeu");
//		System.out.println("5 : Undo");
//		System.out.println("6 : Redo");
//		System.out.println("7 : Activer le mode triche");
//		System.out.println("8 : Recommencer la partie");
//		System.out.println("9 : Sauver la partie");
//		System.out.println("10 : Quitter\n\n");
//		
//		System.out.print("Veuillez faire votre choix : ");
//		
//		Scanner clavier = new Scanner(System.in) ;
//		int choix = 0;
//		try {
//			choix = clavier.nextInt();
//		}
//				
//		catch(Exception e) {
//			// cas a part 
//		}
//				
//		while(choix > 10 || choix < 1) {
//			System.out.println("Choix incorrect");
//		 	System.out.println();
//		 	// cas a part
//		}
//		
//		System.out.println("choix bon on traite ...");
		//System.out.println("totototototo");
	
		
	}
	// methode qquitter
	public void methode4() {
		return;
	}
	
	public void methode3() {		
		System.out.println("bienvenue dans la methode 3");
	}
	
	public void methode2() {
		System.out.println("methode2");
	}
	
	public void methode1() {
		System.out.println("methode1");
	}
	// initialise pile, colonne, pioche 
	public void initialisation() {
		initJeuGlobal(); // creer tes 52 cartes
		melangeCartes(); // pour melanger cartes
		initPioche();  // prend les 24 derniers cartes
		initColonne(); // initialise tes colonnes 
 		// init de pile est implicite 	
		initPile();
	}
			
	// affiche pile colonne et pioche
	public void displayEtatEntierJeu() {
		displayPioche();
		displayColonnes();
		displayPiles();
	}
	
	public void displayEtatCarteJeu() {
		displayCartePioche();
		displayCarteColonnes();
		displayCartePiles();
	}
	
	public void displayCartePioche() {
		System.out.println(displayListCarte("Pioche : ", this.piocheJeu));
	}
	public void displayCarteColonnes() {
		for(int j=0; j<colonneJeu.length; j++) 
			System.out.println(displayListCarte("Colonne "+j+" : ", this.colonneJeu[j]));
	}
	public void displayCartePiles() {
		for(int j=0; j<pileJeu.length; j++) 
			System.out.println(displayListCarte("Pile "+j+" : ", this.pileJeu[j]));
	}
	public void displayPioche() {		
		System.out.println(displayListEntier("Pioche : ", this.piocheJeu));
	}
	
	public void displayColonnes() {
		for(int j=0; j<colonneJeu.length; j++) 
			System.out.println(displayListEntier("Colonne "+j+" : ", this.colonneJeu[j]));		
	}
	
	public void displayPiles() {
		for(int j=0; j<pileJeu.length; j++) 
			System.out.println(displayListEntier("Pile "+j+" : ", this.pileJeu[j]));		
		
	}
	
	
	
	
	public void sommaire(int indice) {
		String res = "";
		res += "\n PROJET SOLITAIRE";
		res += "\n Auteur : Bernard Hounkonnou";
		res += "\n Date : 31 Octobre 2017";
		res += "\n \n Solitaire instance N° " + indice; 
		System.out.println(res);	
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
	
	public void initPile() {
		for(int j=0; j<pileJeu.length; j++) {
			pileJeu[j] = new ArrayList();
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
	//NEWNEWNEW : retourne nom + valeur entiere de ta liste
	public String displayListEntier(String nom, ArrayList lalist) {
		String res = nom;
		if(lalist.isEmpty())
			return res+" Rien";
		
		for (int i=0; i<lalist.size(); i++) {
			res += " " + (lalist.get(i).toString());
		}
		return res;
	}
	
	// renvoie le nom + le display des cartes associees aux entiers  de la liste
	public String displayListCarte(String nom, ArrayList lalist) {
		String res = nom;
		
		if(lalist.isEmpty())
			return res+" Rien";
		
		for (int i=0; i<lalist.size(); i++) {
			int indTemp = (int) lalist.get(i);			
			res += " " + getCarteVS(indTemp);
		}
		return res;		
	}
	
	
	//LES ACTIONS DANS UNE PARTIE 
	
	public void actionn() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		Jeu j = new Jeu();
		//j.intro();
		/*int a=1 ;
		if (a == 1) 
			return; EXIIIIITT*/
		/*
		//***COL
		ArrayList ltemp ;
		System.out.println("Colonne : ");
		for(int k=0; k<7; k++) {
			ltemp= j.getlistColonnes(k);
			
			for (int z=0; z<ltemp.size(); z++) {
				System.out.print(ltemp.get(z) + " ");
			}
			System.out.println();
		}
		System.out.println();
		//***PILE
		ArrayList pile ; 
		System.out.println("Pile : ");
		for(int op=1; op<=4; op++) {
			System.out.print("Rien  ");
		}
		System.out.println();
		System.out.println();
		//***PIOCHE
		System.out.println("Pioche : ");
		System.out.println(j.listCartes);
		*/
		
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
