import java.util.*;

public class Jeu {
	
	//ATTRIBUTS
	ArrayList piocheJeu = new ArrayList(); 
	ArrayList pileJeu[] = new ArrayList[4]; //tab de 4 arraylist d'entiers : 1 par symbole
	ArrayList colonneJeu[] = new ArrayList[7]; // tab de 7 arrayList d'entiers.
	int instanceJeu;
	
	// constructeur
	public Jeu(ArrayList listCartes = new ArrayList();) {
		jouer();
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
		System.out.println("4 : Afficher l'état du jeu");
		System.out.println("5 : Undo");
		System.out.println("6 : Redo");
		System.out.println("7 : Activer le mode triche");
		System.out.println("8 : Recommencer la partie");
		System.out.println("9 : Sauver la partie");
		System.out.println("10 : Quitter la partie \n\n");
		
		int choix = 0;
		
		do {
			System.out.print("Votre choix : ");

			 Scanner clavier =  new Scanner(System.in);
			
			try {
				choix = clavier.nextInt();
			}
			catch(Exception e) {
				System.out.println("Votre droit être entre 1 et 10, Recommencez ! ");
				choix = -1;					
			}
			
		} while(choix > 10 || choix < 1);
		
		switch(choix)
		{
		case 1 : 
			methode1();
			break;
//		case 2 : 
//			methode2();
//			break;
//		case 3 :
//			methode3();
//			break;
//		case 4 :
//			methode4();
//			break;
//		case 5 : 
//			methode5();
//			break;
//		case 6 : 
//			methode6();
//			break;
//		case 7 : 
//			methode7();
//			break;
//		case 8 :
//			methode8();
//			break;
//		case 9 :
//			methode9();
//			break;
		case 10 : 
			methode10();
			break;
//		default :
//			methodeDefault();
		}
	}
	
	public void methode10() {
		return;
	}
	
	public void methode1() {
		// déplacer une carte des pioches, vers les piles
		System.out.println("Déplacer vers la pile : 1 ou la pioche : 2 ?");
		Scanner clavier =  new Scanner(System.in);
		int dir = clavier.nextInt();
		if (dir == 1) {
		System.out.println("bon choix :) vers quelle pile la déplacer ? 0, 1, 2 ou 3 ?");
		int y = clavier.nextInt();
		if (y>-1 && y <4) {
		int ii = piocheJeu.size()-1;
		int valTemp = (int) piocheJeu.get(ii);
		pileJeu[y].add(valTemp);
		piocheJeu.remove(ii);
		displayEtatCarteJeu();
		}
		else
			methode1();
		}
		else if (dir == 2) {
			System.out.println("bon choix :) vers quelle colonne la déplacer ? 0, 1, 2, 3, 4, 5 ou 6 ?");
			int y = clavier.nextInt();
			if (y>-1 && y <7) {
			int ii = piocheJeu.size()-1;
			int valTemp = (int) piocheJeu.get(ii);
			colonneJeu[y].add(valTemp);
			piocheJeu.remove(ii);
			displayEtatCarteJeu();
			}
			else
				methode1();
		}
		else 
			System.out.println("Votre choix doit être 1 ou 2");
	}
	
	// initialise pile, colonne, pioche 
	public void initialisation() {
		initJeuGlobal(); // creer tes 52 cartes
		melangeCartes(); // pour melanger cartes
		initPioche();  // prend les 24 derniers cartes
		initColonne(); // initialise tes colonnes  	
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
	
	public void intro() {
	
		String res = "";
		res += "\n PROJET SOLITAIRE";
		res += "\n Date : 06 Novembre 2017";
		
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
		
	public static void main(String[] args) {
		Jeu j = new Jeu();
		/* si je veux deplacer une liste d element de a vers b 
 
                    ArrayList listeADeplacer = new ArrayList(); // je recupere les elements de a que je veux déplacer ...
                    for (int i = 7; i < 10; i++)
                    {
                           listeADeplacer.Add(a[i]);
                    }
 
 
                    foreach (int aaa in listeADeplacer)     // je parcours les elements de listeAdeplacer : la syntaxe foreach c'est un peu comme la syntaxe for
                    {
                           b.Add(aaa); // ici j ajoute petit a petit les elements dans b
                    }
 
                    // enfin je supprime de ma liste de depart a ...
                    for (int i = 7; i < 10; i++)
                    {
                           a.RemoveAt(i);
                    } */
		}
}
