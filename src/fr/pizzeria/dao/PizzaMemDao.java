package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizza;
	Iterator<Pizza> iterator;
	Pizza[] arrayTemp;

	public PizzaMemDao() {
		/* D�finiions des pizzas */
		listPizza = new ArrayList<Pizza>();
		listPizza.add(new Pizza(0, "PEP", "P�p�roni", 12.50));
		listPizza.add(new Pizza(1, "MAR", "Margherita", 14.00));
		listPizza.add(new Pizza(2, "REIN", "La Reine", 11.50));
		listPizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listPizza.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		listPizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		listPizza.add(new Pizza(6, "ORI", "L�orientale", 13.50));
		listPizza.add(new Pizza(7, "IND", "L�indienne", 14.00));

	}

	@Override
	public List<Pizza> findAllPizzas() {

		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		listPizza.add(pizza);

	}

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

	@Override
	public void deletePizza(String codePizza) {

		for (int i = 0; i < listPizza.size(); i++) {
			Pizza pizzo = (Pizza) listPizza.get(i);
			if (pizzo.getCode().equals(codePizza))
				listPizza.remove(i);
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizzaFind = new Pizza(null, null, 0);

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCode().equals(codePizza))
				pizzaFind = (Pizza) iterator.next();

		}
		return pizzaFind;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean find = false;

		iterator = listPizza.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getCode().equals(codePizza))
				find = true;
		}
		return find;
	}

}
