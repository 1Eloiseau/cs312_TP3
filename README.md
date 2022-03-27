# TP3 de CS312 - Java & POO - 2021-2022

_authors_  
Eloi Donval  
Martin Boulin  
Loïc Savornin  

# Howto

* Compiler avec `javac Restaurant/*.java`
* Exécuter avec `java Restaurant.testRestaurant`
* Les 2 en même temps avec `make` (en étant dans _code/)

# Not implemented

* V1 fonctionelle.
* V2 presque fonctionnelle, mais nous n'avons pas réussi à implémenté la méthode de la dernière question `public void proposerMenu(int Kc, int epsilon)` car :  
  Pour récupérer le nombre de kcal, nous avons besoin des méthodes déclarées dans *Nutrition* et redéfinies dans ses héritières, or nous avons une liste de *Consommable* (`menu.getItems` ci-dessous). Nous ne savons pas comment accéder aux méthodes `getKcal()` des *Plat* (et ses sous-classes) et *Boisson* à partir d'une liste de *Consommable*.

>     public void proposerMenu(int Kc, int epsilon) {
>         ArrayList<Menu> menus = new ArrayList<Menu>();
>         String message;
>         int kcal = 0;
>         float glucides = 0;
>         for (Menu menu : this.menus) {
>            // for (Nutrition consommable : menu.getItems()) { // Il faudrait utiliser des méthodes de Nutrition alors que j'ai une liste de Consommable
>            //
>            //}
>         }
>         message="Les menus ayant " +KC+"±"epsilon+" kcal sont :" +menus;
>         System.out.println(message);
>     }

  Le diagramme UML fourni (UML.png) peut aider à comprendre ce problème.

# Known bugs

* Pas de bug connu.
