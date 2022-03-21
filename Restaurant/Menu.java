package Restaurant;

import java.util.ArrayList;

public class Menu {
    ArrayList<Consommable> items = new ArrayList<Consommable>();
    int prix; // en cents

    public Menu(int prix, Entree e, PlatPrincipal p, Dessert d, Boisson b) throws Exception {
        this.prix = prix;
        items.add(e);
        items.add(p);
        items.add(d);
        items.add(b);
        if (verifPrixMenu()) {
            throw new Exception("ERREUR dans le prix lors de la creation du Menu");
        }
    }

    public ArrayList<Consommable> getItems() {
        return this.items;
    }

    public int getPrix() {
        return this.prix;
    }

    public String toString() {
        String message = "Menu composé de ";
        for (Consommable item : items) {
            message += item.getNom();
            message += ", ";
        }
        message += "au prix de " + prix + " euros";
        return message;
    }

    public boolean verifPrixMenu() {
        boolean prixIncorect = false;
        int prixTotal = 0;

        for (Consommable item : items) {
            prixTotal += item.getPrix();
        }
        prixIncorect = (this.prix <= 0 || prixTotal <= this.prix);

        return prixIncorect;
    }
}
