package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;

/**
 * Pour supprimer un pizza
 * 
 * @author F.Duarte
 *
 */
public class SupprimerPizzaService extends MenuService {

	String code; // choix de l'utilisateur

	/**
	 * V�rifie l'existance le code du pizzza avant suppression
	 * 
	 * @param read
	 * @param dao
	 */
	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) {

		System.out.println("Veuillez choisir le code de la pizza � supprimer.");
		code = read.next();
		// recherche le pizza demand�
		if (dao.pizzaExists(code)) {
			dao.deletePizza(code);

		} else {
			System.out.println("Pizza inexistant");
		}

	}

}
