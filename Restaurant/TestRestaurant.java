package Restaurant;

public class TestRestaurant {

    public TestRestaurant() {
    }

    public static void main(String args[]) {
        System.out.println("Début du programme");
        try {
            Entree salade = new Entree("Salade", 4);
            PlatPrincipal risotto = new PlatPrincipal("Risotto", 6);
            Dessert tarteFraises = new Dessert("Tarte aux fraises", 3);
            Boisson citronade = new Boisson("Citronade", 2, 33);

            Menu menu = new Menu(10, salade, risotto, tarteFraises, citronade);
            System.out.println("##Question 4");
            System.out.println(menu.toString());

            Carte carte = new Carte();
            carte.addBoisson(citronade);
            carte.addBoisson(new Boisson("Citronade", 1, 1));// test de l'ajout d'un doublon

            System.out.println("##Question 6");
            carte.afficherCarte();

            carte.addEntree(salade);
            carte.addPlatPrincipal(risotto);
            carte.addMenu(menu);
            System.out.println("##Question 7");
            System.out.println("Menus de la carte :" + carte.getMenus());
            System.out.println("Ajout du dernier élément du menu pour que ce menu puisse être ajouté");
            carte.addDessert(tarteFraises);
            carte.addMenu(menu);
            System.out.println("Menus de la carte :" + carte.getMenus());

            Entree saladeVerte = new Entree("Salade verte", 4);
            Entree saladeComposee = new Entree("Salade Composée", 6);
            PlatPrincipal pizzaReine = new PlatPrincipal("Pizza Reine", 9);
            PlatPrincipal pizzaMargarita = new PlatPrincipal("Pizza Margarita", 8);
            PlatPrincipal spaghetti = new PlatPrincipal("Spaghetti à la Bolognaise", 25);
            Dessert tiramisu = new Dessert("Tiramisu", 4);
            Boisson eau = new Boisson("Eau Gratuite", 33);
            Menu menu1 = new Menu(15, saladeVerte, pizzaReine, tiramisu, eau);
            Carte carte1 = new Carte();
            carte1.addEntree(saladeVerte);
            carte1.addEntree(saladeComposee);
            carte1.addPlatPrincipal(pizzaReine);
            carte1.addPlatPrincipal(pizzaMargarita);
            carte1.addPlatPrincipal(spaghetti);
            carte1.addDessert(tiramisu);
            carte1.addBoisson(eau);
            carte1.addMenu(menu1);
            Commande commande = new Commande();
            commande.addItem(pizzaReine);
            commande.addItem(pizzaMargarita);
            commande.addItem(saladeVerte);
            commande.addItem(tiramisu);
            commande.addItem(eau);
            System.out.println("##Question 8");
            System.out.println("Prix commande : " + carte1.calculerPrixCommande(commande) + "€");
            System.out.println("##Question 9");
            carte1.afficherRecapitulatifCommande(commande);
        } catch (Exception e) {
            System.out.println("##Question 5");
            System.out.println(e.getMessage());
        }

    }

}
