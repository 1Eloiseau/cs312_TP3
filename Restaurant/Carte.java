package Restaurant;

import java.util.ArrayList;
import java.util.Iterator;

public class Carte {
    private ArrayList<Consommable> entrees;
    private ArrayList<Consommable> platsPrincipaux;
    private ArrayList<Consommable> desserts;
    private ArrayList<Consommable> boissons;

    private ArrayList<Menu> menus;

    public Carte() {
        entrees = new ArrayList<Consommable>();
        platsPrincipaux = new ArrayList<Consommable>();
        desserts = new ArrayList<Consommable>();
        boissons = new ArrayList<Consommable>();
        menus = new ArrayList<Menu>();
    }

    public void addEntree(Entree e) {
        if (verifCarte(e))
            this.entrees.add(e);
    }

    public void addPlatPrincipal(PlatPrincipal p) {
        if (verifCarte(p))
            this.platsPrincipaux.add(p);
    }

    public void addDessert(Dessert d) {
        if (verifCarte(d))
            this.desserts.add(d);
    }

    public void addBoisson(Boisson b) {
        if (verifCarte(b))
            this.boissons.add(b);
    }

    public void addMenu(Menu m) {
        if (verifMenu(m)) {
            this.menus.add(m);
        }
    }

    public ArrayList<Consommable> getEntrees() {
        return this.entrees;
    }

    public ArrayList<Consommable> getPlatsPrincipaux() {
        return this.platsPrincipaux;
    }

    public ArrayList<Consommable> getDesserts() {
        return this.desserts;
    }

    public ArrayList<Consommable> getBoissons() {
        return this.boissons;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    // Vérifie qu'il n'y a pas d'homonymes dans la carte
    // utiliser equals et des iterateurs
    private boolean verifCarte(Consommable c) {
        String nomItem = c.getNom();
        Iterator<Consommable> iterateurBoisson = this.boissons.iterator();
        Iterator<Consommable> iterateurPlats = this.platsPrincipaux.iterator();
        Iterator<Consommable> iterateurEntrees = this.entrees.iterator();
        Iterator<Consommable> iterateurDesserts = this.desserts.iterator();

        return verifNom(nomItem, iterateurBoisson)
                && verifNom(nomItem, iterateurPlats)
                && verifNom(nomItem, iterateurEntrees)
                && verifNom(nomItem, iterateurDesserts);
    }

    // utilisé par verifCarte, renvoit 0 si un nom de consommable est déjà dans la
    // liste de l'itérateur
    private boolean verifNom(String nom, Iterator<Consommable> iterateur) {
        boolean verif = true;
        while (iterateur.hasNext()) {
            if (nom.equals(iterateur.next().getNom())) {
                verif = false;
            }
        }
        return verif;
    }

    // Vérifie que les plats et boissons du menu sont bien dans la carte
    private boolean verifMenu(Menu menu) {
        boolean verif = true;
        ArrayList<Consommable> items = menu.getItems();
        for (Consommable item : items) {
            verif = verif && (this.boissons.contains(item) // verif à 1 si l'item est dans la carte)
                    || this.desserts.contains(item)
                    || this.platsPrincipaux.contains(item)
                    || this.entrees.contains(item));
        }

        return verif;
    }

    public void afficherRecapitulatifCommande(Commande commande) {
        String message = "Commande composée de : ";
        for (Consommable item : commande.getItemsCommandes()) {
            message += item.getNom() + ", ";
        }
        message += "au prix de " + calculerPrixCommande(commande) + "€";
        System.out.println(message);
    }

    /*
     * Calcule le prix de la commande. A priori, ce prix est la somme des prix des
     * items
     * SAUF si une partie de ces items constituent un menu; dans ce cas, le tarif
     * menu s'applique pour ces items.
     */
    public int calculerPrixCommande(Commande c) {
        int prix = 0;
        ArrayList<Consommable> itemsFinaux = new ArrayList<Consommable>(c.getItemsCommandes());
        ArrayList<Menu> menusFinaux = new ArrayList<Menu>();

        for (Menu menu : this.menus) {// on regarde si chaque menu est présent dans la commande
            boolean menuPresent = true;
            for (Consommable item : menu.items) {
                menuPresent = menuPresent && c.getItemsCommandes().contains(item);
            }
            if (menuPresent) {
                menusFinaux.add(menu);
                for (Consommable conso : menu.items) {
                    itemsFinaux.remove(conso);
                }
            }
        }
        for (Consommable item : itemsFinaux) {
            prix += item.getPrix();
        }
        for (Menu menu : menusFinaux) {
            prix += menu.getPrix();
        }

        return prix;
    }

    public void afficherCarte() {
        System.out.println("Liste des entrees:" + entrees);
        System.out.println("Liste des plats principaux:" + platsPrincipaux);
        System.out.println("Liste des desserts:" + desserts);
        System.out.println("Liste des boissons:" + boissons);
    }
}
