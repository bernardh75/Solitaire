public class Carte {

	// attributs 
	private String valeur, symbole; // valeur : as par exemple ; symbole trêfle par exemple
	private boolean etat; // false si la carte est cachée, 1 si elle est dévoilée

	// constructeurs 
	public Carte (String valeur, String symbole) {
		this.valeur=valeur;
		this.symbole=symbole;
		this.etat=false; // carte cachée par défaut
	}

	// getter setter

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean getEtat() {
		return etat;
	}

	public void setValeur(String valeur) {
		this.valeur=valeur;
	}
	public String getValeur() {
		return valeur;
	}

	public void setSymbole(String symbole) {
		this.symbole=symbole;
	}
	public String getSymbole() {
		return symbole;
	}
	// methodes 
	public boolean isRouge() {
		
		return (symbole == "coeur" || symbole == "carreau");

	}

	public String toString() {
		/*if (etat == true)*/
			return "[" + valeur + "|" + symbole + "]";
		/*else 
			return "X";*/
	}
}
