package Restaurant;

public class Boisson implements Consommable, Nutrition {

    private String nom;
    private int prix; // en cents d'euros
    private int volume; // en centilitres
    private int kcal = -1; // nombre de Kcal
    private float glucides = -1; // en grammes

    public Boisson(String nom, int prix, int volume) {
        this.nom = nom;
        this.prix = prix;
        this.volume = volume;
    }

    public Boisson(String nom, int prix, int volume, int kcal, float glucides) {
        this.nom = nom;
        this.prix = prix;
        this.volume = volume;
        this.kcal = kcal;
        this.glucides = glucides;
    }

    public Boisson(String nom, int volume) {
        this(nom, 0, volume);
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getVolume() {
        return volume;
    }

    public int getKcal() {
        return kcal;
    }

    public float getGlucides() {
        return glucides;
    }

    public String toString() {
        return this.getNom();
    }
}