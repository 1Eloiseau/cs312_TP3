package Restaurant;

public class Plat implements Consommable{
    
    protected String nom;
    protected int prix; // en cents d'euros

    public Plat(String nom, int prix) {
	    this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }
	
    public int getPrix() {
        return prix;
    }
}
