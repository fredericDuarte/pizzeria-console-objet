package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {


	String code;

	@Override
	public void methodeUC(Scanner read, IPizzaDao dao) {

		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		code = read.next();
		// recherche le pizza demandé
		if (dao.pizzaExists(code)) {
			Pizza pizzaFind = dao.findPizzaByCode(code);

			System.out.println("Veuillez saisir le nouveau code :");
			pizzaFind.setCode(read.next());
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			pizzaFind.setLibbelle(read.next());
			System.out.println("Veuillez saisir le nouveau prix :");
			pizzaFind.setPrix(read.nextDouble());

			dao.updatePizza(code, pizzaFind);

		} else {
			System.out.println("Pizza inexistant");
		}

	}

}
