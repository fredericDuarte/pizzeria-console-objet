package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	public Pizza[] array;
	Pizza[] arrayTemp;

	public PizzaMemDao() {
		/* Définiions des pizzas */
		array = new Pizza[8];
		array[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		array[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		array[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		array[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		array[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		array[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		array[6] = new Pizza(6, "ORI", "L’orientale", 13.50);
		array[7] = new Pizza(7, "IND", "L’indienne", 14.00);

	}

	@Override
	public Pizza[] findAllPizzas() {

		return array;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		arrayTemp = new Pizza[array.length + 1];
		// copie la liste
		for (int i = 0; i < array.length; i++) {
			arrayTemp[i] = array[i];
		}
		// ajoute un nouveau pizza dans le tableau temporaire qui contient liste
		arrayTemp[array.length] = pizza;
		// récupére la nouvelle liste
		array = arrayTemp;

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < array.length; i++) {

			if (array[i].getCode().equals(codePizza)) {

				array[i].setCode(pizza.getCode());
				array[i].setLibbelle(pizza.getLibbelle());
				array[i].setPrix(pizza.getPrix());
			}

		}

	}

	@Override
	public void deletePizza(String codePizza) {

		arrayTemp = new Pizza[array.length - 1];
		int iTemp = 0;
		// copie la liste sauf pour le pizza demandé
		for (int i = 0; i < array.length; i++) {
			if (!array[i].getCode().equals(codePizza)) {
				arrayTemp[iTemp] = array[i];
				iTemp++;
			}
		}
		// récupére la nouvelle liste
		array = arrayTemp;

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = new Pizza(null, null, 0);
		for (int i = 0; i < array.length; i++) {

			if (array[i].getCode().equals(codePizza))
				pizzaFind = array[i];

		}
		return pizzaFind;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean find = false;

		for (int i = 0; i < array.length; i++) {

			if (array[i].getCode().equals(codePizza))
				find = true;

		}
		return find;
	}

}
