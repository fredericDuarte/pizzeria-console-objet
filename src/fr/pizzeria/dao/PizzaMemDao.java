package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author F.Duarte
 *
 */
public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizza = new ArrayList<Pizza>();
	Iterator<Pizza> iterator;
	Pizza[] arrayTemp;

	/**
	 * constructeuur
	 */
	public PizzaMemDao() {
		/* Ajouts des pizzas */

		saveNewPizza(new Pizza(0, "PEP", "P�p�roni", 12.50));
		saveNewPizza(new Pizza(1, "MAR", "Margherita", 14.00));
		saveNewPizza(new Pizza(2, "REIN", "La Reine", 11.50));
		saveNewPizza(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		saveNewPizza(new Pizza(4, "CAN", "La cannibale", 12.50));
		saveNewPizza(new Pizza(5, "SAV", "La savoyarde", 13.00));
		saveNewPizza(new Pizza(6, "ORI", "L�orientale", 13.50));
		saveNewPizza(new Pizza(7, "IND", "L�indienne", 14.00));

	}

	/**
	 * retourne la liste des pizzas
	 * 
	 * @return List<Pizza>
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		return listPizza;
	}

	/**
	 * Ajout un nouveau pizza dans la liste
	 * 
	 * @param Pizza
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {

		listPizza.add(pizza);

	}

	/**
	 * Mettre � jour le pizza demand�
	 * 
	 * @param codePizza,pizza
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		for (int i = 0; i < listPizza.size(); i++) {
			Pizza pizzo = (Pizza) listPizza.get(i);
			if (pizzo.getCode().equals(codePizza))
				listPizza.get(i).setCode(codePizza);
			listPizza.get(i).setLibbelle(pizzo.getLibbelle());
			listPizza.get(i).setPrix(pizzo.getPrix());

		}

	}

	/**
	 * supprime un pizza demand�
	 * 
	 * @param codePizza
	 */
	@Override
	public void deletePizza(String codePizza) {

		for (int i = 0; i < listPizza.size(); i++) {
			Pizza pizzo = (Pizza) listPizza.get(i);
			if (pizzo.getCode().equals(codePizza))
				listPizza.remove(i);
		}

	}

	/**
	 * retourne un objet pizza demand� par un code
	 * 
	 * @param codePizza
	 * @return pizzaFind
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = null;

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			Pizza currentPizza = iterator.next();
			if (currentPizza.getCode().equals(codePizza)) {
				pizzaFind = (Pizza) currentPizza;
			}

		}
		return pizzaFind;
	}

	/**
	 * V�rifie si le pizza demand� existe
	 * 
	 * @param codePizza
	 * @return find
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean find = false;

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			Pizza currentPizza = iterator.next();
			if (currentPizza.getCode().equals(codePizza))
				find = true;
		}
		return find;
	}

}
