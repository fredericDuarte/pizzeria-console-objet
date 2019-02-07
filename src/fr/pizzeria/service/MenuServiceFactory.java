package fr.pizzeria.service;

import fr.pizzeria.dao.*;

public class MenuServiceFactory {

	PizzaMemDao pizzaDao = new PizzaMemDao();

	public MenuService choixService(int choixUser) {

		switch (choixUser) {
		case 1:
			/* Affiche la liste des pizzas */
			return new ListerPizzaService();
		case 2:
			// Affiche les messages et r�cup�re les saisies pour pour cr�er un nouveau pizza
			return new AjouterPizzaService();
		case 3:
			// pour la modification d'un pizza existant
			return new ModifierPizzaService();
		case 4:
			// demande le code pour le pizza � supprimer
			return new SupprimerPizzaService();

		default:
			break;

		}
		return null;
	}

}
