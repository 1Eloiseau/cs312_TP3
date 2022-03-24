package Restaurant;

public class Plat implements Consommable {

    protected String nom;
    protected int prix; // en cents d'euros
    protected int kcal = -1; // nombre de Kcal
    protected float glucides = -1; // en grammes

    public Plat(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Plat(String nom, int prix, int kcal, float glucides) {
        this.nom = nom;
        this.prix = prix;
        this.kcal = kcal;
        this.glucides = glucides;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getKcal() {
        return kcal;
    }

    public float getGlucides() {
        return glucides;
    }
}
