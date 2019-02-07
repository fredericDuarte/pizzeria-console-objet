package fr.pizzeria.console;

import java.sql.Savepoint;
import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author F.Duarte
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		/* d�fintiions des variables */
		int choix = 1; // pour la saisie de l'utilisateur
		String code;
		String nom;
		double prix;

		/* d�finitions pour la saisie au clavier */
		PizzaMemDao pizzaDao = new PizzaMemDao();
		Scanner choixUser = new Scanner(System.in);

		while (true) {

			/* Affichage d'un menu */
			System.out.println("***** Pizzeria Administration *****\n");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre � jour une pizzas");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("votre choix : \n");
			choix = choixUser.nextInt(); // saisie clavier par l'utilisateur

			/*  */
			switch (choix) {
			case 1:
				/* Affiche la liste des pizzas */
				System.out.println("Les pizzas");
				for (int i = 0; i < pizzaDao.findAllPizzas().length; i++) {

					pizzaDao.findAllPizzas()[i].affiche();
				}
				choixUser.nextLine(); // pause jusqu'� l'action par l'utilisateur
				break;

			case 2:
				// Affiche les messages et r�cup�re les saisies pour pour cr�er un nouveau pizza
				System.out.println("Veuillez saisir le code :");
				code = choixUser.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				nom = choixUser.next();
				System.out.println("Veuillez saisir le prix :");
				prix = choixUser.nextDouble();
				Pizza pizza = new Pizza(code, nom, prix);
				pizzaDao.saveNewPizza(pizza);
				break;

			case 3:
				// pour la modification d'un pizza existant
				System.out.println("Veuillez choisir le code de la pizza � modifier.");
				code = choixUser.next();
				// recherche le pizza demand�
				if (pizzaDao.pizzaExists(code)) {
					Pizza pizzaFind = pizzaDao.findPizzaByCode(code);

					System.out.println("Veuillez saisir le nouveau code :");
					pizzaFind.setCode(choixUser.next());
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					pizzaFind.setLibbelle(choixUser.next());
					System.out.println("Veuillez saisir le nouveau prix :");
					pizzaFind.setPrix(choixUser.nextDouble());

					pizzaDao.updatePizza(code, pizzaFind);

				} else {
					System.out.println("Pizza inexistant");
				}

				break;
			case 4:
				// demande le code pour le pizza � supprimer
				System.out.println("Veuillez choisir le code de la pizza � supprimer.");
				code = choixUser.next();
				// recherche le pizza demand�
				if (pizzaDao.pizzaExists(code)) {
					pizzaDao.deletePizza(code);

				} else {
					System.out.println("Pizza inexistant");
				}

				break;
			case 99:
				choixUser.close(); // quitte le programme
				break;

			}

		}

	}
}
